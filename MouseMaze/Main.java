package io.github.xieyezi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	private int countLine;// 绘制迷宫时控制跨行
	private int currentX;// 绘制迷宫时定位X坐标
	private int currentY;// 绘制迷宫时定位Y坐标
	private final int LENGTH = 10;// 迷宫一个单元格的长度
	Pane pane = new Pane();// 面板
	Circle ball = new Circle(55, 55, 5);// 模拟电脑鼠运动的小球
	
	Button b1 = new Button("生成迷宫");
	Button b2 = new Button("寻找路径");
	Button b3 = new Button("遍历迷宫");
	Button b4 = new Button("最短路径");
	Button b5 = new Button("清空迷宫");
	Button b6 = new Button("退出游戏");
    // main函数
	public static void main(String[] args) {
		Application.launch(args);
	}

// 重写start显示面板
	@Override
	public void start(Stage primaryStage) throws Exception {	

		Maze(); // 随机生成迷宫数据文件
		creatXY(); // 绘制坐标轴
		createButton(); // 生成控制按钮
		Scene scene = new Scene(pane, 700, 500);
		primaryStage.setTitle("MouseMaze");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void creatXY() { // 绘制坐标轴函数
		Line l1 = new Line(50, 50, 450, 50);// X轴
		l1.setStrokeWidth(2);
		Line l2 = new Line(50, 50, 50, 450);// Y轴
		l2.setStrokeWidth(2);
		Text t1 = new Text(40, 40, "(0,0)");
		Text t2 = new Text(440, 40, "X  (450,50)");
		Text t3 = new Text(35, 450, "Y");
		Text t4 = new Text(35,465,"(50,450)");
		pane.getChildren().addAll(l1, l2, t1, t2, t3,t4);
	}

	private void createButton(){ // 控制按钮生成函数
	

		b1.setLayoutX(500);// 定义按钮的X坐标
		b1.setLayoutY(50);// 定义按钮的Y坐标
		b1.setMinSize(80, 40);// 定义按钮的大小
		b1.setStyle("-fx-border-color: blue");// 定义按钮边框的颜色

		b2.setLayoutX(500);
		b2.setLayoutY(120);
		b2.setMinSize(80, 40);
		b2.setStyle("-fx-border-color: blue");

		b3.setLayoutX(500);
		b3.setLayoutY(190);
		b3.setMinSize(80, 40);
		b3.setStyle("-fx-border-color: blue");

		b4.setLayoutX(500);
		b4.setLayoutY(260);
		b4.setMinSize(80, 40);
		b4.setStyle("-fx-border-color: blue");

		b5.setLayoutX(500);
		b5.setLayoutY(330);
		b5.setMinSize(80, 40);
		b5.setStyle("-fx-border-color: blue");
		
		b6.setLayoutX(500);
		b6.setLayoutY(400);
		b6.setMinSize(80, 40);
		b6.setStyle("-fx-border-color: blue");
		pane.getChildren().addAll(b1, b2, b3, b4, b5,b6);
		// 按钮的功能的生成
		b1.setOnAction(e -> createMaze());
		b2.setOnAction(e -> searchEndPoint());
		b3.setOnAction(e -> travelMzae());
		b4.setOnAction(e -> shortestPath());
		b5.setOnAction(e -> deleteMaze());
		b6.setOnAction(e -> exit());
	}
	private void createMaze() {// 绘制迷宫的函数

		createBall();// 生成模拟电脑鼠的圆
		countLine = 0;
		currentX = 50;
		currentY = 50;
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
	}

	private void paintCell(String str) { // 绘制墙壁的函数

		if (str.charAt(0) == '0')
			ceartLine(currentX, currentY, currentX + LENGTH, currentY);
		if (str.charAt(1) == '0')
			ceartLine(currentX + LENGTH, currentY, currentX + LENGTH, currentY + LENGTH);
		if (str.charAt(2) == '0')
			ceartLine(currentX, currentY + LENGTH, currentX + LENGTH, currentY + LENGTH);
		if (str.charAt(3) == '0')
			ceartLine(currentX, currentY, currentX, currentY + LENGTH);
		currentX += LENGTH;
		countLine++;
		// 控制绘制下一行
		if (countLine % 40 == 0) {
			currentX = 50;
			currentY += 10;
		}
	}

	private void ceartLine(int x1, int y1, int x2, int y2) { // 绘制单元格的一面墙壁
		Line line = new Line(x1, y1, x2, y2);
		line.setStrokeWidth(2);
		line.setFill(Color.BLACK);
		pane.getChildren().add(line);
	}

	private void createBall() {// 绘制圆

		ball.setStroke(null);
		ball.setFill(Color.RED);
		pane.getChildren().add(ball);
	}

	public void Maze() throws Exception { // 随机生成迷宫数据文件函数 ，“0”表示有墙，“1”表示无墙

		File file = new File("Maze.txt");
		PrintWriter output = new PrintWriter(file);
		Maze mazeModel = new Maze();
		ArrayList<mazePoint> pointList = new ArrayList<mazePoint>();
		pointList = mazeModel.getMaze();
		int i = 0;
		while (i < pointList.size()) {
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
	private void searchEndPoint() { // 寻找起点到终点路径的函数
		// TODO 自动生成的方法存根
	}

	private void travelMzae() { // 遍历迷宫的函数
		// TODO 自动生成的方法存根
	}

	private void shortestPath() { // 寻找最短路径的函数
		// TODO 自动生成的方法存根
	}
    private void deleteMaze(){  //清空迷宫
    	// TODO 自动生成的方法存根
    }
    public void exit() {   //退出游戏
		System.exit(0);
	}
}
