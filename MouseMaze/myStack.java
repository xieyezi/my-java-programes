package io.github.xieyezi;

public class myStack {
    private int elements[][]; //表示可行路径的点的坐标
    private int size; //表示点的个数
    public static final int COL = 200; //表示二维数组的行数
    public static final int RAW = 1; //表示二维数组的列数
    public myStack(){   //建造长度默认为200的栈
    	this(COL);
    }
    //建造指定长度的栈
    public myStack(int col){  
    	elements =new int[col][RAW];
    }
    //将一个点的x,y坐标压入栈中
    public void push(int x,int y){  
    	if( size >= elements.length){
    		int temp[][] = new int[elements.length*2][RAW];
    		System.arraycopy(elements, 0, temp, 0, elements.length);
    		elements = temp;
    	}
    	elements[size++][0] = x;
    	elements[size++][RAW] = y;
    }
    //返回栈顶的那个点的x,y坐标而不删除它
    public int[][] peek(){
    	int temp[][] = new int[1][1];
    	System.arraycopy(elements, elements.length-1, temp, 0, elements.length);
    	return temp;
    }
   //返回栈顶的那个点的x,y坐标并删除它
    public int[][] pop(){
    	int temp1[][] = new int[1][RAW];
    	int temp2[][] = new int[elements.length-1][RAW];
    	System.arraycopy(elements, elements.length-1, temp1, 0, elements.length);
    	System.arraycopy(elements, 0, temp2, 0, elements.length-1);
    	elements = temp2;
    	return temp1;
    }
    //若栈为空,则返回ture
    public boolean empty(){
    	return size == 0;
    }
    //返回栈中元素的个数
    public int getSize(){
    	return size;
    }
}
