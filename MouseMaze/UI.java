package cn.edud;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UI extends Application {
	private int countLine; // 绘制迷宫时控制跨行
	private int currentX; // 绘制迷宫时定位X坐标
	private int currentY; // 绘制迷宫时定位Y坐标
	private int ballCol = 0;// 小球当前所在列
	private int ballRaw = 0;// 小球当前所在行
	private final int LENGTH = 10; // 迷宫一个单元格一面墙的长度
	private Timeline animation; // 显示小球路径的动画
	Pane pane = new Pane();// 用来装迷宫的面板
	BorderPane borderpane1 = new BorderPane(); // 用来装迷宫的pane,用于清除迷宫
	BorderPane borderpane = new BorderPane(); // 主面板
	Circle ball = new Circle(55, 55, 5);// 模拟电脑鼠运动的小球
	Button bt1 = new Button("生成迷宫");
	Button bt2 = new Button("寻找路径");
	Button bt3 = new Button("遍历迷宫");
	Button bt4 = new Button("最短路径");
	Button bt5 = new Button("清空迷宫");
	Button bt6 = new Button("退出游戏");
	VBox vbox = new VBox(bt1, bt2, bt3, bt4, bt5, bt6);
	// 存储迷宫信息
	cell[][] cell = new cell[40][40];
	// 存储运动信息的栈
	myStack stack = new myStack();

	// 主函数
	public static void main(String[] args) {
		Application.launch(args);
	}

	// 重写start显示面板
	@Override
	public void start(Stage primaryStage) throws Exception {
		creatXY(); // 绘制坐标轴
		createButton(); // 生成控制按钮
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		borderpane.setRight(vbox);
		borderpane1.setBottom(getHBOox());
		borderpane1.setCenter(pane);
		borderpane.setCenter(borderpane1);
		borderpane.setPadding(new Insets(0, 30, 12, 0));
		Scene scene = new Scene(borderpane, 600, 500);
		primaryStage.setTitle("MouseMaze");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// 绘制坐标轴函数
	private void creatXY() {
		Line l1 = new Line(50, 50, 450, 50);// X轴
		l1.setStrokeWidth(2);
		Line l2 = new Line(50, 50, 50, 450);// Y轴
		l2.setStrokeWidth(2);
		Text t1 = new Text(40, 40, "(50,50)");
		Text t2 = new Text(440, 40, "X  (450,50)");
		Text t3 = new Text(35, 450, "Y");
		Text t4 = new Text(35, 465, "(50,450)");
		borderpane.getChildren().addAll(l1, l2, t1, t2, t3, t4);
	}

	// 控制按钮生成
	private void createButton() {

		bt1.setMinSize(80, 40);// 定义按钮的大小
		bt1.setStyle("-fx-border-color: blue");// 定义按钮边框的颜色

		bt2.setMinSize(80, 40);
		bt2.setStyle("-fx-border-color: blue");

		bt3.setMinSize(80, 40);
		bt3.setStyle("-fx-border-color: blue");

		bt4.setMinSize(80, 40);
		bt4.setStyle("-fx-border-color: blue");

		bt5.setMinSize(80, 40);
		bt5.setStyle("-fx-border-color: blue");

		bt6.setMinSize(80, 40);
		bt6.setStyle("-fx-border-color: blue");

		// 按钮的功能的生成
		bt1.setOnAction(e -> paintMaze());
		bt2.setOnAction(e -> {
			animation = new Timeline(new KeyFrame(Duration.millis(5), e1 -> moveBall()));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
		});
		bt3.setOnAction(e -> travelMzae());
		bt4.setOnAction(e -> shortestPath());
		bt5.setOnAction(e -> deleteMaze());
		bt6.setOnAction(e -> exit());
	}

	// 主面板的底部界面
	private HBox getHBOox() {
		HBox hbox = new HBox();
		// 以下四个文本域分别表示为起点的x,y坐标和终点的x,y坐标
		TextField startX = new TextField();
		TextField startY = new TextField();
		TextField endX = new TextField();
		TextField endY = new TextField();
		startX.setPrefSize(40, 10);
		startY.setPrefSize(40, 10);
		endX.setPrefSize(40, 10);
		endY.setPrefSize(40, 0);
		Label l1 = new Label("起点坐标:");
		Label l2 = new Label("终点坐标:");
		l1.setTextFill(Color.RED);
		l2.setTextFill(Color.RED);
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		hbox.getChildren().addAll(l1, startX, startY, l2, endX, endY);
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.setSpacing(5);
		return hbox;
	}

	// 绘制迷宫
	private void paintMaze() {

		try {
			Mazefile(); // 随机生成迷宫数据文件并将其存入磁盘
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		paintBall(); // 生成模拟电脑鼠的小球
		countLine = 0; // 控制换行
		currentX = 50; // 迷宫的起点坐标的x坐标
		currentY = 50; // 迷宫的起点坐标的y坐标
		File file = new File("Maze.txt");
		Scanner input = null;
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				String str = input.next();
				paintCell(str); // 绘制墙壁
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
		inputMaze();// 获取迷宫数据存入Cell

	}

	// 绘制墙壁
	private void paintCell(String str) {
		if (str.charAt(0) == '0')
			createLine(currentX, currentY, currentX + LENGTH, currentY);// 绘制单元格上边的墙
		if (str.charAt(1) == '0')
			createLine(currentX + LENGTH, currentY, currentX + LENGTH, currentY + LENGTH);// 绘制单元格右边的墙
		if (str.charAt(2) == '0')
			createLine(currentX, currentY + LENGTH, currentX + LENGTH, currentY + LENGTH);// 绘制单元格下边的墙
		if (str.charAt(3) == '0')
			createLine(currentX, currentY, currentX, currentY + LENGTH); // 绘制单元格左边的墙
		currentX += LENGTH; // 绘制下一个单元格
		countLine++;
		if (countLine % 40 == 0)// 控制绘制下一行
		{
			currentX = 50;
			currentY += LENGTH;
		}
	}

	// 绘制单元格的一面墙壁
	private void createLine(int x1, int y1, int x2, int y2) {
		Line line = new Line(x1, y1, x2, y2);
		line.setStrokeWidth(2);
		line.setFill(Color.BLACK);
		pane.getChildren().add(line);
	}

	// 绘制小球
	private void paintBall() {
		ball.setCenterX(55);
		ball.setCenterY(55);
		ball.setRadius(5);
		ball.setStroke(null);
		ball.setFill(Color.RED);
		pane.getChildren().add(ball);
	}

	// 随机生成迷宫数据文件函数 ，“0”表示有墙，“1”表示无墙
	public void Mazefile() throws Exception {
		// 生成迷宫数据 存储到pointList链表里面
		File file = new File("Maze.txt");
		PrintWriter output = new PrintWriter(file);
		Maze maze = new Maze();
		ArrayList<mazePoint> pointList = new ArrayList<mazePoint>();
		pointList = maze.getMaze();
		int i = 0;
		// 定义随机数的一个对象
		Random random = new Random();
		while (i < pointList.size()) {

			int l = random.nextInt(4);
			if ((i + 1) % 8 != 0 && (i + 1) % 7 != 0 && i > 7 && i < 56) {
				if (pointList.get(i).getDirection() < 3) {
					if (l == 0 && pointList.get(i + 1).getDirection() >= 1) {
						pointList.get(i).setRight(1);
						pointList.get(i + 1).setLeft(1);
					} else if (l == 1 && pointList.get(i + 8).getDirection() >= 1) {
						pointList.get(i).setDown(1);
						pointList.get(i + 8).setUp(1);
					} else if (l == 2 && pointList.get(i - 1).getDirection() >= 1) {
						pointList.get(i).setLeft(1);
						pointList.get(i - 1).setRight(1);
					} else if (l == 3 && pointList.get(i - 8).getDirection() >= 1) {
						pointList.get(i).setUp(1);
						pointList.get(i - 8).setDown(1);
					}
				}
			}
			// 将数据存储到文件里面
			output.print(pointList.get(i).getUp());
			output.print(pointList.get(i).getRight());
			output.print(pointList.get(i).getDown());
			output.print(pointList.get(i).getLeft());
			output.print(' ');
			i++;

			if (i % 8 == 0) {
				output.println();
			}
		}
		output.close();

	}

	// 绘制寻找路径行走路线
	private void paintMoveBall(double i, double j, double m, double n) {
		Line line = new Line(i, j, m, n);
		line.setStrokeWidth(2.5);
		line.setFill(Color.GREENYELLOW);
		line.setStroke(Color.RED);
		pane.getChildren().add(line);
	}

	// 绘制遍历行走路线
	private void paintMoveBall1(double i, double j, double m, double n) {
		Line line = new Line(i, j, m, n);
		line.setStrokeWidth(2.5);
		line.setFill(Color.GREENYELLOW);
		line.setStroke(Color.BLUE);
		pane.getChildren().add(line);
	}

	private void inputMaze() {
		// 迷宫地图数据导入栈
		File file = new File("Maze.txt");
		Scanner input = null;
		while (!stack.empty()) {
			stack.pop();
		}
		stack.push(cell[ballCol][ballRaw]);// 将起点压入栈
		try {
			int i = 0;
			int j = 0;
			int n = 0;
			input = new Scanner(file);
			while (input.hasNext()) {
				String str = input.next();
				char a1 = str.charAt(0);
				int a = a1 - '0';
				char b1 = str.charAt(1);
				int b = b1 - '0';
				char c1 = str.charAt(2);
				int c = c1 - '0';
				char d1 = str.charAt(3);
				int d = d1 - '0';
				cell[i][j] = new cell(a, b, c, d);// 将迷宫地图数据存储到Cell[][]
				cell[i][j].setDix(n);
				n++;
				i++;
				if (i % 40 == 0) {
					i = 0;
					j++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
	}

	// 移动小球
	private void moveBall() {
		// 优先顺序，右左下上
		if (ballCol == 39 && ballRaw == 39) {
			animation.pause();
		} else if (stack.getSize() >= 0) {
			xunzhaolujing();
		}
	}

	// 遍历迷宫的函数
	private void travelMzae() {
		animation = new Timeline(new KeyFrame(Duration.millis(5), e1 -> bianli()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}

	// 寻找最短路径的函数
	private void shortestPath() {
		// void 自动生成的方法存根
	}

	// 清空迷宫函数
	private void deleteMaze() {
		animation = null;
		pane.getChildren().clear();
		ballCol = 0; // 将行重新初始化
		ballRaw = 0; // 将列重新初始化
		while (!stack.empty()) {
			stack.pop();
		}
	}

	// 退出函数
	public void exit() {
		System.exit(0);
	}

	private void xunzhaolujing() { // 右手法则
		cell[ballCol][ballRaw].setVisted(true);
		if (cell[ballCol][ballRaw].getRight() == 1 && cell[ballCol + 1][ballRaw].getLeft() == 1
				&& cell[ballCol + 1][ballRaw].isVisted() == false && cell[ballCol + 1][ballRaw].isPass() == true) {// 右转
			stack.push(cell[ballCol][ballRaw]);
			cell[ballCol + 1][ballRaw].setVisted(true);
			double i = ball.getCenterX();
			double j = ball.getCenterY();
			ballCol++;
			ball.setCenterX(55 + ballCol * LENGTH);
			ball.setCenterY(55 + ballRaw * LENGTH);
			double m = ball.getCenterX();
			double n = ball.getCenterY();
			paintMoveBall(i, j, m, n);
		} else if (ballCol > 0 && cell[ballCol][ballRaw].getLeft() == 1 && cell[ballCol - 1][ballRaw].getRight() == 1
				&& cell[ballCol - 1][ballRaw].isVisted() == false && cell[ballCol - 1][ballRaw].isPass() == true) {// 左转
			stack.push(cell[ballCol][ballRaw]);
			cell[ballCol - 1][ballRaw].setVisted(true);
			double i = ball.getCenterX();
			double j = ball.getCenterY();
			ballCol--;
			ball.setCenterX(55 + ballCol * LENGTH);
			ball.setCenterY(55 + ballRaw * LENGTH);
			double m = ball.getCenterX();
			double n = ball.getCenterY();
			paintMoveBall(i, j, m, n);
		} else if (cell[ballCol][ballRaw].getDown() == 1 && cell[ballCol][ballRaw + 1].getUp() == 1
				&& cell[ballCol][ballRaw + 1].isVisted() == false && cell[ballCol][ballRaw + 1].isPass() == true) {// 下转
			stack.push(cell[ballCol][ballRaw]);
			cell[ballCol][ballRaw + 1].setVisted(true);
			double i = ball.getCenterX();
			double j = ball.getCenterY();
			ballRaw++;
			ball.setCenterX(55 + ballCol * LENGTH);
			ball.setCenterY(55 + ballRaw * LENGTH);
			double m = ball.getCenterX();
			double n = ball.getCenterY();
			paintMoveBall(i, j, m, n);
		} else if (ballRaw > 0 && cell[ballCol][ballRaw].getUp() == 1 && cell[ballCol][ballRaw - 1].getDown() == 1
				&& cell[ballCol][ballRaw - 1].isVisted() == false && cell[ballCol][ballRaw - 1].isPass() == true) {// 上转
			stack.push(cell[ballCol][ballRaw]);
			cell[ballCol][ballRaw - 1].setVisted(true);
			double i = ball.getCenterX();
			double j = ball.getCenterY();
			ballRaw--;
			ball.setCenterX(55 + ballCol * LENGTH);
			ball.setCenterY(55 + ballRaw * LENGTH);
			double m = ball.getCenterX();
			double n = ball.getCenterY();
			paintMoveBall(i, j, m, n);
		} else {// 不转则退栈，再比较找到上一个节点
			cell cell1 = new cell();
			if (stack.getSize() > 0) {
				cell1 = stack.pop();
				for (int i = 0; i < 40; i++)
					for (int j = 0; j < 40; j++) {
						if (cell1.compareTo(cell[i][j]) == 0) {
							if (j > 1 && cell[i][j].getDir() == 0 && cell[i][j].getDirection() <= 1) {
								cell[i][j - 1].setPass();
							} else if (i < 39 && cell[i][j].getDir() == 1 && cell[i][j].getDirection() <= 1) {
								cell[i + 1][j].setPass();
							} else if (j < 39 && cell[i][j].getDir() == 2 && cell[i][j].getDirection() <= 1) {
								cell[i][j + 1].setPass();
							} else if (i > 0 && cell[i][j].getDir() == 3 && cell[i][j].getDirection() <= 1) {
								cell[i - 1][j].setPass();
							}
							ballCol = i;
							ballRaw = j;
							ball.setCenterX(55 + ballCol * LENGTH);
							ball.setCenterY(55 + ballRaw * LENGTH);
							break;
						}
					}
			}
		}
	}

	private void bianli() {
		boolean visitedAll = true;
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell[i].length; j++) {
				if (cell[i][j].isVisted() == false)
					visitedAll = false;
			}
		}
		if (ballCol == 0 && ballRaw == 0 && visitedAll == true) {
			animation.stop();
			while (!stack.empty()) {
				stack.pop();
			}
		} else {// 左手法则
			if (ballCol > 0 && cell[ballCol][ballRaw].getLeft() == 1 && cell[ballCol - 1][ballRaw].getRight() == 1
					&& cell[ballCol - 1][ballRaw].isVisted() == false && cell[ballCol - 1][ballRaw].isPass() == true) {
				stack.push(cell[ballCol][ballRaw]);
				cell[ballCol - 1][ballRaw].setVisted(true);
				double i = ball.getCenterX();
				double j = ball.getCenterY();
				ballCol--;
				ball.setCenterX(55 + ballCol * LENGTH);
				ball.setCenterY(55 + ballRaw * LENGTH);
				double m = ball.getCenterX();
				double n = ball.getCenterY();
				paintMoveBall1(i, j, m, n);
			} else if (cell[ballCol][ballRaw].getRight() == 1 && cell[ballCol + 1][ballRaw].getLeft() == 1
					&& cell[ballCol + 1][ballRaw].isVisted() == false && cell[ballCol + 1][ballRaw].isPass() == true) {
				stack.push(cell[ballCol][ballRaw]);
				cell[ballCol + 1][ballRaw].setVisted(true);
				double i = ball.getCenterX();
				double j = ball.getCenterY();
				ballCol++;
				ball.setCenterX(55 + ballCol * LENGTH);
				ball.setCenterY(55 + ballRaw * LENGTH);
				double m = ball.getCenterX();
				double n = ball.getCenterY();
				paintMoveBall1(i, j, m, n);
			} else if (ballRaw > 0 && cell[ballCol][ballRaw].getUp() == 1 && cell[ballCol][ballRaw - 1].getDown() == 1
					&& cell[ballCol][ballRaw - 1].isVisted() == false && cell[ballCol][ballRaw - 1].isPass() == true) {
				stack.push(cell[ballCol][ballRaw]);
				cell[ballCol][ballRaw - 1].setVisted(true);
				double i = ball.getCenterX();
				double j = ball.getCenterY();
				ballRaw--;
				ball.setCenterX(55 + ballCol * LENGTH);
				ball.setCenterY(55 + ballRaw * LENGTH);
				double m = ball.getCenterX();
				double n = ball.getCenterY();
				paintMoveBall1(i, j, m, n);
			} else if (cell[ballCol][ballRaw].getDown() == 1 && cell[ballCol][ballRaw + 1].getUp() == 1
					&& cell[ballCol][ballRaw + 1].isVisted() == false && cell[ballCol][ballRaw + 1].isPass() == true) {
				stack.push(cell[ballCol][ballRaw]);
				cell[ballCol][ballRaw + 1].setVisted(true);
				double i = ball.getCenterX();
				double j = ball.getCenterY();
				ballRaw++;
				ball.setCenterX(55 + ballCol * LENGTH);
				ball.setCenterY(55 + ballRaw * LENGTH);
				double m = ball.getCenterX();
				double n = ball.getCenterY();
				paintMoveBall1(i, j, m, n);
			} else {
				cell cell1 = new cell();
				if (stack.getSize() > 0) {
					cell1 = stack.pop();
					for (int i = 0; i < 40; i++)
						for (int j = 0; j < 40; j++) {
							if (cell1.compareTo(cell[i][j]) == 0) {
								if (j > 1 && cell[i][j].getDir() == 0 && cell[i][j].getDirection() <= 1) {
									cell[i][j - 1].setPass();
								} else if (i < 39 && cell[i][j].getDir() == 1 && cell[i][j].getDirection() <= 1) {
									cell[i + 1][j].setPass();
								} else if (j < 39 && cell[i][j].getDir() == 2 && cell[i][j].getDirection() <= 1) {
									cell[i][j + 1].setPass();
								} else if (i > 0 && cell[i][j].getDir() == 3 && cell[i][j].getDirection() <= 1) {
									cell[i - 1][j].setPass();
								}
								ballCol = i;
								ballRaw = j;
								ball.setCenterX(55 + ballCol * LENGTH);
								ball.setCenterY(55 + ballRaw * LENGTH);
								break;
							}
						}
				}
			}
		}
	}
}
