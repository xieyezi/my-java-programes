package io.xieyezi.github;

public class Test12_1_2 {
	public static void main(String args[]){
		if(args.length !=3 ){
			System.out.println("Usage: java Calculator operandl operator operand2");
		System.exit(0);
		}
		int result = 0;
		try{
			NumberWithException.numberwithexception(args[0]);
			NumberWithException.numberwithexception(args[2]);
		switch(args[1].charAt(0)){
		case '+':result = Integer.parseInt(args[0])+
							Integer.parseInt(args[2]);
						break;
		case '-':result = Integer.parseInt(args[0])-
							Integer.parseInt(args[2]);
						break; 
		case '.':result =  Integer.parseInt(args[0])*
							Integer.parseInt(args[2]);
						break;
		case '/':result =  Integer.parseInt(args[0])/
							Integer.parseInt(args[2]);
						break;
		}
		System.out.println(args[0]+' '+args[1]+ ' '+args[2]+ " = "+result);
		}
		catch(NumberFormatException ex){
			System.out.println(ex.toString());
		}
	}
}
class NumberWithException{
	public static void numberwithexception(String a){
		if(a.compareTo("0")<0 || a.compareTo("9")>0){
			throw new NumberFormatException("not 0-9 int number");
		}
	}
}
