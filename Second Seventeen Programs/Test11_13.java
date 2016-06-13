package io.github.xieyezi;

import java.util.ArrayList;
import java.util.Scanner;

public class Test11_13 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner input =new Scanner(System.in);
		System.out.println("ÇëÊäÈë10¸öÊı×Ö£º");
		for(int i = 0;i<10;i++){
			list.add(input.nextInt());
		}
		input.close();
		removeDuplicate(list);
		for (int i : list) {
			System.out.printf("%d ",i);
		}
	}
       public static void removeDuplicate(ArrayList<Integer> list){
    	   for(int i = 0;i<list.size();i++){
    		   Integer temp = list.get(i);
    		   for(int j= i+1;j<list.size();j++){
    			   if(temp == list.get(j)){
    				   list.remove(j);
    			   }
    		   }
    	   }
       }
}
