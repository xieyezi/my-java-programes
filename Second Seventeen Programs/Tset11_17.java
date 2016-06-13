package io.github.xieyezi;

import java.util.ArrayList;
import java.util.Scanner;

public class Tset11_17 {
	public static void main(String[] args) {
		int m,n;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer m:");
		m = input.nextInt();
		input.close();
		n = getMinNum(m);
		System.out.println("The smallest number n for m*n to be a perfect square is "+n);
		System.out.println("m*n="+m*n);
	}
    public static int getMinNum(int m){
    	ArrayList<Integer> list = new ArrayList<>();
    	int n=1,count=1;
    	while(m>1){
    	    for(int i = 2;i<=m;i++){
    		  if(m % i == 0){
    			list.add(i);
    			m = m/i;
    			break;
    		}
    	}
      }
    	for(int i=0;i<list.size();i++)
		{
			count=1;
			for(int j=i+1;j<list.size();j++)
			{
				if(list.get(i)==list.get(j))
				{
					count++;
					list.remove(j);
					
				}
			}
			if(count%2==1)
				n*=list.get(i);
		}
      return n;
    }
}
