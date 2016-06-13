package io.github.xieyezi;

import java.util.ArrayList;
import java.util.Scanner;

public class Test11_12 {
	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();
		Scanner input =new Scanner(System.in);
		System.out.println("请输入五个数字：");
		for(int i = 0;i<5;i++){
			list.add(input.nextDouble());
		}
		input.close();
	    System.out.println(sum(list));
	}
    public static double  sum(ArrayList<Double> list){
    	double sum = 0.0;
    	for(int i = 0;i<list.size();i++){
    		sum += list.get(i);
    	}
    	return sum;
    }
}
