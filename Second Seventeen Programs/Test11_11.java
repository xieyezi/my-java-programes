package io.github.xieyezi;

import java.util.ArrayList;
import java.util.Scanner;

public class Test11_11 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner input =new Scanner(System.in);
		System.out.println("请输入五个数字：");
		for(int i = 0;i<5;i++){
			list.add(input.nextInt());
		}
		input.close();
		sort(list);
		for (int i : list) {
			System.out.printf("%d ",i);
		}
	}
     public static void sort(ArrayList<Integer> list) {
    	 Integer temp;
    	 for(int i = 0;i<list.size()-1;i++){
    		 for(int j=0;j<list.size()-1-i;j++){
    			 if(list.get(j)>list.get(j+1)){
    				 temp = list.get(j);
    				 list.set(j, list.get(j+1));
    				 list.set(j+1, temp);
    			 }
    		 }
    	 }
     }
}
