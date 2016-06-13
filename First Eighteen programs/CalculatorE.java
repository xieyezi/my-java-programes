package io.github.xieyezi;

import java.math.BigDecimal;

public class CalculatorE{
	public static void main(String[] args) {
		BigDecimal e = new BigDecimal(1.0);
		BigDecimal item = new BigDecimal(1.0);
		for(int i = 1;i<=1000;i++){
			e=e.add(item = item.divide(BigDecimal.valueOf(i), 25,BigDecimal.ROUND_UP));
			if(i%100 == 0){
				System.out.println(e.toPlainString());
			}
		}
		
	}
}


