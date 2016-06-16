package io.xieyezi.github;

public class Test12_1_1 {  //不用异常处理器来处理非数值操作数
    public static void main(String[] args) {
		if(args.length != 3){
			System.out.println("Usage:java Calcular operand1 operand operand2");
			System.exit(0);
		}
		if((args[0].charAt(0)<'0'||args[0].charAt(0)>'9') || (args[2].charAt(0)<'0'||args[2].charAt(0)>'9')){
			System.out.println("Wrong Input "+args[0].charAt(0));
			System.exit(0);
		}
		int result = 0;
		switch(args[1].charAt(0)){
		case '+':result  = Integer.parseInt(args[0])+Integer.parseInt(args[2]);break;
		case '-':result  = Integer.parseInt(args[0])-Integer.parseInt(args[2]);break;
		case '.':result  = Integer.parseInt(args[0])*Integer.parseInt(args[2]);break;
		case '/':result  = Integer.parseInt(args[0])/Integer.parseInt(args[2]);break;
		}
		System.out.println(args[0]+' '+args[1]+' '+args[2]+" = "+result);
	}
}
