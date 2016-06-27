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
	private int countLine;   // �����Թ�ʱ���ƿ���
	private int currentX;    // �����Թ�ʱ��λX����
	private int currentY;    // �����Թ�ʱ��λY����
	private final int LENGTH = 10;// �Թ�һ����Ԫ��ĳ���
	Pane pane = new Pane();        // ����װ�Թ������
	BorderPane borderpane1 = new BorderPane(); //�����
	BorderPane borderpane = new BorderPane(); //�����
	Circle circle = new Circle(55, 55, 5);// ģ��������˶���С��
	Button b1 = new Button("�����Թ�");
	Button b2 = new Button("Ѱ��·��");
	Button b3 = new Button("�����Թ�");
	Button b4 = new Button("���·��");
	Button b5 = new Button("����Թ�");
	Button b6 = new Button("�˳���Ϸ");
	VBox vbox = new VBox(b1,b2,b3,b4,b5,b6);
    // main����
	public static void main(String[] args) {
		Application.launch(args);
	}

// ��дstart��ʾ���
	@Override
	public void start(Stage primaryStage) throws Exception {	
		creatXY(); // ����������
		createButton(); // ���ɿ��ư�ť
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
	 // ���������ắ��
	private void creatXY() {
		Line l1 = new Line(50, 50, 450, 50);// X��
		l1.setStrokeWidth(2);
		Line l2 = new Line(50, 50, 50, 450);// Y��
		l2.setStrokeWidth(2);
		Text t1 = new Text(40, 40, "(0,0)");
		Text t2 = new Text(440, 40, "X  (450,50)");
		Text t3 = new Text(35, 450, "Y");
		Text t4 = new Text(35,465,"(50,450)");
		borderpane.getChildren().addAll(l1, l2, t1, t2, t3,t4);
	}
	//�����ĵײ�����
    private HBox getHBOox(){  
    	HBox hbox = new HBox();
    	//�����ĸ��ı���ֱ��ʾΪ����x,y������յ��x,y����
        TextField startX  = new TextField();
        TextField startY  = new TextField();
        TextField endX  = new TextField();
        TextField endY  = new TextField();
        startX.setPrefSize(40,10);
        startY.setPrefSize(40, 10);
        endX.setPrefSize(40, 10);
        endY.setPrefSize(40, 0);
        Label l1 = new Label("�������:");
        Label l2 = new Label("�յ�����:");
        l1.setTextFill(Color.RED);
        l2.setTextFill(Color.RED);
        l1.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
        l2.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
        hbox.getChildren().addAll(l1,startX,startY,l2,endX,endY);
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setSpacing(5);
        return hbox;
    }
    // ���ư�ť���ɺ���
    private void createButton(){ 
		b1.setMinSize(80, 40);// ���尴ť�Ĵ�С
		b1.setStyle("-fx-border-color: blue");// ���尴ť�߿����ɫ

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
	
		// ��ť�Ĺ��ܵ�����
		b1.setOnAction(e -> createMaze());
		b2.setOnAction(e -> searchEndPoint());
		b3.setOnAction(e -> travelMzae());
		b4.setOnAction(e -> shortestPath());
		b5.setOnAction(e -> deleteMaze());
		b6.setOnAction(e -> exit());
	}
    //�����Թ��ĺ���
	private void createMaze() {  

		createBall();// ����ģ��������Բ
		countLine = 0;
		currentX = 50;
		currentY = 50;
		Scanner input = null;
		try {
			Mazefile();  // ��������Թ������ļ�
			File file = new File("Maze.txt");
			
			input = new Scanner(file);
			while (input.hasNext()) {
				String str = input.next();
				paintCell(str); // ����ǽ��
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
	}
    // ����ǽ�ڵĺ���
	private void paintCell(String str) { 
		if (str.charAt(0) == '0')
			ceartLine(currentX, currentY, currentX + LENGTH, currentY); //���Ƶ�Ԫ���ϱߵ�ǽ
		if (str.charAt(1) == '0')
			ceartLine(currentX + LENGTH, currentY, currentX + LENGTH, currentY + LENGTH); //���Ƶ�Ԫ���ұߵ�ǽ
		if (str.charAt(2) == '0')
			ceartLine(currentX, currentY + LENGTH, currentX + LENGTH, currentY + LENGTH);  //���Ƶ�Ԫ���±ߵ�ǽ
		if (str.charAt(3) == '0')
			ceartLine(currentX, currentY, currentX, currentY + LENGTH); //���Ƶ�Ԫ����ߵ�ǽ
		currentX += LENGTH;
		countLine++;
		// ���ƻ�����һ��
		if (countLine % 40 == 0) {
			currentX = 50;
			currentY += 10;
		}
	}
   // ���Ƶ�Ԫ���һ��ǽ��
	private void ceartLine(int x1, int y1, int x2, int y2) { 
		Line line = new Line(x1, y1, x2, y2);
		line.setStrokeWidth(2);
		line.setFill(Color.BLACK);
		pane.getChildren().add(line);
	}
    // ����Բ
	private void createBall() {

		circle.setStroke(null);
		circle.setFill(Color.RED);
		pane.getChildren().add(circle);
	}
    // ��������Թ������ļ� ,����������
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
	private void searchEndPoint() { // Ѱ����㵽�յ�·���ĺ���
		File file = new File("Maze.txt");
		
	}

	private void travelMzae() { // �����Թ��ĺ���
		// TODO �Զ����ɵķ������
	}

	private void shortestPath() { // Ѱ�����·���ĺ���
		// TODO �Զ����ɵķ������
	}
    private void deleteMaze(){  //����Թ�
    	pane.getChildren().clear();
    }
    //�˳���Ϸ
    public void exit() {   
		System.exit(0);
	}
}
