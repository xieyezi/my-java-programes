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
	private int countLine;// �����Թ�ʱ���ƿ���
	private int currentX;// �����Թ�ʱ��λX����
	private int currentY;// �����Թ�ʱ��λY����
	private final int LENGTH = 10;// �Թ�һ����Ԫ��ĳ���
	Pane pane = new Pane();// ���
	Circle ball = new Circle(55, 55, 5);// ģ��������˶���С��
	
	Button b1 = new Button("�����Թ�");
	Button b2 = new Button("Ѱ��·��");
	Button b3 = new Button("�����Թ�");
	Button b4 = new Button("���·��");
	Button b5 = new Button("����Թ�");
	Button b6 = new Button("�˳���Ϸ");
    // main����
	public static void main(String[] args) {
		Application.launch(args);
	}

// ��дstart��ʾ���
	@Override
	public void start(Stage primaryStage) throws Exception {	

		Maze(); // ��������Թ������ļ�
		creatXY(); // ����������
		createButton(); // ���ɿ��ư�ť
		Scene scene = new Scene(pane, 700, 500);
		primaryStage.setTitle("MouseMaze");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void creatXY() { // ���������ắ��
		Line l1 = new Line(50, 50, 450, 50);// X��
		l1.setStrokeWidth(2);
		Line l2 = new Line(50, 50, 50, 450);// Y��
		l2.setStrokeWidth(2);
		Text t1 = new Text(40, 40, "(0,0)");
		Text t2 = new Text(440, 40, "X  (450,50)");
		Text t3 = new Text(35, 450, "Y");
		Text t4 = new Text(35,465,"(50,450)");
		pane.getChildren().addAll(l1, l2, t1, t2, t3,t4);
	}

	private void createButton(){ // ���ư�ť���ɺ���
	

		b1.setLayoutX(500);// ���尴ť��X����
		b1.setLayoutY(50);// ���尴ť��Y����
		b1.setMinSize(80, 40);// ���尴ť�Ĵ�С
		b1.setStyle("-fx-border-color: blue");// ���尴ť�߿����ɫ

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
		// ��ť�Ĺ��ܵ�����
		b1.setOnAction(e -> createMaze());
		b2.setOnAction(e -> searchEndPoint());
		b3.setOnAction(e -> travelMzae());
		b4.setOnAction(e -> shortestPath());
		b5.setOnAction(e -> deleteMaze());
		b6.setOnAction(e -> exit());
	}
	private void createMaze() {// �����Թ��ĺ���

		createBall();// ����ģ��������Բ
		countLine = 0;
		currentX = 50;
		currentY = 50;
		File file = new File("Maze.txt");
		Scanner input = null;
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				String str = input.next();

				paintCell(str); // ����ǽ��
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
	}

	private void paintCell(String str) { // ����ǽ�ڵĺ���

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
		// ���ƻ�����һ��
		if (countLine % 40 == 0) {
			currentX = 50;
			currentY += 10;
		}
	}

	private void ceartLine(int x1, int y1, int x2, int y2) { // ���Ƶ�Ԫ���һ��ǽ��
		Line line = new Line(x1, y1, x2, y2);
		line.setStrokeWidth(2);
		line.setFill(Color.BLACK);
		pane.getChildren().add(line);
	}

	private void createBall() {// ����Բ

		ball.setStroke(null);
		ball.setFill(Color.RED);
		pane.getChildren().add(ball);
	}

	public void Maze() throws Exception { // ��������Թ������ļ����� ����0����ʾ��ǽ����1����ʾ��ǽ

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
	private void searchEndPoint() { // Ѱ����㵽�յ�·���ĺ���
		// TODO �Զ����ɵķ������
	}

	private void travelMzae() { // �����Թ��ĺ���
		// TODO �Զ����ɵķ������
	}

	private void shortestPath() { // Ѱ�����·���ĺ���
		// TODO �Զ����ɵķ������
	}
    private void deleteMaze(){  //����Թ�
    	// TODO �Զ����ɵķ������
    }
    public void exit() {   //�˳���Ϸ
		System.exit(0);
	}
}
