package io.github.xieyezi;
import java.math.*;
	public class E {
		public static void main(String[] args) {
			for(int i=100;i<=1000;)
			{
				   E a=new E(i);
				   BigDecimal b= new  BigDecimal(0);
				   b=a.getE();
				   System.out.println(b);
				   i+=100;
			}
		}
		    private int   integer ;
			public E(int integer)
			{
				this.integer = integer;
			}
			public E() 
			{
				
			}
			public int getInteger()
			{
				return integer;
			}
			public void setIntrger(int integer) 
			{
				this.integer = integer;
			}
		    BigDecimal getE()
		    {
			    	BigDecimal e=new BigDecimal(1);
			    	BigDecimal item=new BigDecimal(1);
		    	for(int i=2;i<=integer;i++)
		    	{
		    	 	 e=e.add(item);
		    	 	 item=item.divide(new BigDecimal(i),25, BigDecimal.ROUND_HALF_DOWN   );
		    	 	 
		    	}
		    	return e;
		    }
		}


