package io.github.xieyezi;

public class Stock {
      String symbol;
      String name;
      double previousClosingPrice;
      double currentPrice;
      public Stock(String specialsymbol,String name) {
    	  this.symbol = specialsymbol;
    	  this.name = name;
      }
      public double getChangePercent() {
    	 return (currentPrice-previousClosingPrice)/previousClosingPrice*100;
      }
      public static void main(String[] args) {
		Stock stock = new Stock("ORCL","Oracle Corporation");
		stock.previousClosingPrice = 34.5;
		stock.currentPrice = 34.35;
		System.out.println("市值变化率为："+stock.getChangePercent()+"%");
	}
}
