package io.github.xieyezi;

public class Queue {
      private int[] elements;
      private int size;
      Queue(){
    	  elements = new int[8];
      }
      public void enqueue(int v){
    	  if(size >= elements.length){
    		  int[] temp = new int[elements.length*2];
    		  System.arraycopy(elements, 0,temp,0,elements.length);
    		  elements = temp;
    	  }
    	  elements[size++] = v;
      }
      public int dequeue(){
    	  return elements[--size];
      }
      public boolean empty(){
    	  return size == 0;
      }
      public int getSize(){
    	  return size;
      }
      public static void main(String[] args) {
		Queue queue = new Queue();
		for(int i = 0;i<21;i++){
			queue.enqueue(i);
		}
		while(!queue.empty()){
			System.out.println(queue.dequeue()+" ");
		}
	}
}
