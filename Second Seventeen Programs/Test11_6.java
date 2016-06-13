package io.github.xieyezi;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.shape.Circle;

public class Test11_6 {
   public static void main(String[] args) {
	ArrayList<Object> list = new ArrayList<>();
	Loan loan = new Loan();
	Date date = new Date();
	String str = "abcd";
	Circle circle = new Circle(5.0);
	list.add(loan);
	list.add(date);
	list.add(str);
	list.add(circle);
	for(int i = 0;i<list.size();i++) {
		System.out.println(list.get(i).toString());
	}
 }
}
class Loan{   
  public Loan(){   
	   }
 }

