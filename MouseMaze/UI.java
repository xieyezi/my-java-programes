package io.github.xieyezi;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
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

public class UI extends Application {
	private int countLine;   // 绘制迷宫时控制跨行
	private int currentX;    // 绘制迷宫时定位X坐标
	private int currentY;    // 绘制迷宫时定位Y坐标
	private final int LENGTH = 10;// 迷宫一个单元格的长度
	Pane pane = new Pane();        // 用来装迷宫的面板
	BorderPane borderpane1 = new BorderPane(); //主面板
	BorderPane borderpane = new BorderPane(); //主面板
	Circle circle = new Circle(55, 55, 5);// 模拟电脑鼠运动的小球
	Button b1 = new Button("生成迷宫");
	Button b2 = new Button("寻找路径");
	Button b3 = new Button("遍历迷宫");
	Button b4 = new Button("最短路径");
	Button b5 = new Button("清空迷宫");
	Button b6 = new Button("退出游戏");
	VBox vbox = new VBox(b1,b2,b3,b4,b5,b6);
    // main函数
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
		borderpane.setPadding(new Insets(0,30,12,0));
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
		Text t1 = new Text(40, 40, "(0,0)");
		Text t2 = new Text(440, 40, "X  (450,50)");
		Text t3 = new Text(35, 450, "Y");
		Text t4 = new Text(35,465,"(50,450)");
		borderpane.getChildren().addAll(l1, l2, t1, t2, t3,t4);
	}
	//主面板的底部界面
    private HBox getHBOox(){  
    	HBox hbox = new HBox();
    	//以下四个文本域分别表示为起点的x,y坐标和终点的x,y坐标
        TextField startX  = new TextField();
        TextField startY  = new TextField();
        TextField endX  = new TextField();
        TextField endY  = new TextField();
        startX.setPrefSize(40,10);
        startY.setPrefSize(40, 10);
        endX.setPrefSize(40, 10);
        endY.setPrefSize(40, 0);
        Label l1 = new Label("起点坐标:");
        Label l2 = new Label("终点坐标:");
        l1.setTextFill(Color.RED);
        l2.setTextFill(Color.RED);
        l1.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
        l2.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
        hbox.getChildren().addAll(l1,startX,startY,l2,endX,endY);
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setSpacing(5);
        return hbox;
    }
    // 控制按钮生成函数
    private void createButton(){ 
		b1.setMinSize(80, 40);// 定义按钮的大小
		b1.setStyle("-fx-border-color: blue");// 定义按钮边框的颜色

		b2.setMinSize(80, 40);
		b2.setStyle("-fx-border-color: blue");

		b3.setMinSize(80, 40);
		b3.setStyle("-fx-border-color: blue");

		b4.setMinSize(80, 40);
		b4.setStyle("-fx-border-color: blue");

		b5.setMinSize(80, 40);
		b5.setStyle("-fx-border-color: blue");
		
	
		b6.setMinSize(80, 40);
		b6.setStyle("-fx-border-color: blue");
	
		// 按钮的功能的生成
		b1.setOnAction(e -> createMaze());
		b2.setOnAction(e -> searchEndPoint());
		b3.setOnAction(e -> travelMzae());
		b4.setOnAction(e -> shortestPath());
		b5.setOnAction(e -> deleteMaze());
		b6.setOnAction(e -> exit());
	}
    //绘制迷宫的函数
	private void createMaze() {  

		createBall();// 生成模拟电脑鼠的圆
		countLine = 0;
		currentX = 50;
		currentY = 50;
		Scanner input = null;
		try {
			Mazefile();  // 随机生成迷宫数据文件
			File file = new File("Maze.txt");
			
			input = new Scanner(file);
			while (input.hasNext()) {
				String str = input.next();
				paintCell(str); // 绘制墙壁
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
	}
    // 绘制墙壁的函数
	private void paintCell(String str) { 
		if (str.charAt(0) == '0')
			ceartLine(currentX, currentY, currentX + LENGTH, currentY); //绘制单元格上边的墙
		if (str.charAt(1) == '0')
			ceartLine(currentX + LENGTH, currentY, currentX + LENGTH, currentY + LENGTH); //绘制单元格右边的墙
		if (str.charAt(2) == '0')
			ceartLine(currentX, currentY + LENGTH, currentX + LENGTH, currentY + LENGTH);  //绘制单元格下边的墙
		if (str.charAt(3) == '0')
			ceartLine(currentX, currentY, currentX, currentY + LENGTH); //绘制单元格左边的墙
		currentX += LENGTH;
		countLine++;
		// 控制绘制下一行
		if (countLine % 40 == 0) {
			currentX = 50;
			currentY += 10;
		}
	}
   // 绘制单元格的一面墙壁
	private void ceartLine(int x1, int y1, int x2, int y2) { 
		Line line = new Line(x1, y1, x2, y2);
		line.setStrokeWidth(2);
		line.setFill(Color.BLACK);
		pane.getChildren().add(line);
	}
    // 绘制圆
	private void createBall() {

		circle.setStroke(null);
		circle.setFill(Color.RED);
		pane.getChildren().add(circle);
	}
    // 随机生成迷宫数据文件 ,将其存入磁盘
	public void Mazefile() throws Exception {  

		File file = new File("Maze.txt");
		PrintWriter output = new PrintWriter(file);
		Maze maze = new Maze();
		ArrayList<mazePoint> pointList = new ArrayList<mazePoint>();
		pointList = maze.getMaze();
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
		File file = new File("Maze.txt");
		
	}

	private void travelMzae() { // 遍历迷宫的函数
		// TODO 自动生成的方法存根
	}

	private void shortestPath() { // 寻找最短路径的函数
		// TODO 自动生成的方法存根
	}
    private void deleteMaze(){  //清空迷宫
    	pane.getChildren().clear();
    }
    //退出游戏
    public void exit() {   
		System.exit(0);
	}
}
