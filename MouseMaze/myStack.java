package io.github.xieyezi;

public class myStack {
    private int elements[][]; //��ʾ����·���ĵ������
    private int size; //��ʾ��ĸ���
    public static final int COL = 200; //��ʾ��ά���������
    public static final int RAW = 1; //��ʾ��ά���������
    public myStack(){   //���쳤��Ĭ��Ϊ200��ջ
    	this(COL);
    }
    //����ָ�����ȵ�ջ
    public myStack(int col){  
    	elements =new int[col][RAW];
    }
    //��һ�����x,y����ѹ��ջ��
    public void push(int x,int y){  
    	if( size >= elements.length){
    		int temp[][] = new int[elements.length*2][RAW];
    		System.arraycopy(elements, 0, temp, 0, elements.length);
    		elements = temp;
    	}
    	elements[size++][0] = x;
    	elements[size++][RAW] = y;
    }
    //����ջ�����Ǹ����x,y�������ɾ����
    public int[][] peek(){
    	int temp[][] = new int[1][1];
    	System.arraycopy(elements, elements.length-1, temp, 0, elements.length);
    	return temp;
    }
   //����ջ�����Ǹ����x,y���겢ɾ����
    public int[][] pop(){
    	int temp1[][] = new int[1][RAW];
    	int temp2[][] = new int[elements.length-1][RAW];
    	System.arraycopy(elements, elements.length-1, temp1, 0, elements.length);
    	System.arraycopy(elements, 0, temp2, 0, elements.length-1);
    	elements = temp2;
    	return temp1;
    }
    //��ջΪ��,�򷵻�ture
    public boolean empty(){
    	return size == 0;
    }
    //����ջ��Ԫ�صĸ���
    public int getSize(){
    	return size;
    }
}
