import java.util.Scanner;
class Exercise2_1{
    public static void main(String[] args) {
        double temperature;
        Scanner input =new Scanner(System.in);
        System.out.println("请输入摄氏温度：");
        temperature = input.nextDouble();
        System.out.println((9.0/5)*temperature+32);
    }
}
class Exercise2_2 {
    public static void main(String[] args) {
        double radius,high;
        double volume;
      Scanner input =new Scanner(System.in);
       System.out.println("请输入半径：");
       radius = input.nextDouble();
        System.out.println("请输入高：");
        high = input.nextDouble();
        volume = (radius*radius*3.1415926)*high;
        System.out.println("该圆柱的体积是："+volume);
    }
}
class Exercise2_3 {
     public static void main(String[] args) {
         float mile;
         Scanner input =new Scanner(System.in);
         System.out.println("请输入英里数：");
         mile = input.nextFloat();
         System.out.println(mile+" feet is "+mile*0.305f+" meters");
     }
    
}
class Exercise2_4 {
     public static void main(String[] args) {
         float pounds;
         Scanner input =new Scanner(System.in);
         System.out.println("请输入英磅数：");
         pounds = input.nextFloat();
         System.out.println(pounds+" pounds is "+pounds*0.454f+" kilograms");
     }
}
class Exercise2_5 {
   public static void main(String[] args) {
       float money,moneyrate;
       Scanner input =new Scanner(System.in);
       System.out.println("请输入费用和酬金率：");
       money = input.nextFloat();
       moneyrate = input.nextFloat();
       System.out.println("酬金为 "+money*(moneyrate/100)+" 总费用为 " +money*(1+moneyrate/100));
   }
}
class Exercise2_6 {
     public static void main(String[] args) {
         int num,a,b,c;
         Scanner input =new Scanner(System.in);
         System.out.println("请输入一个三位的整数：");
         num = input.nextInt();
         a=(int)(num/100);
         b=(int)((num/10)%10);
         c=(int)(num%10);
         System.out.println(a+b+c);
     }
}
class Exercise2_7 {
    public static void main(String[] args) {
        long time;
        int year,day;
        Scanner input =new Scanner(System.in);
        System.out.println("请输入分钟数：");
        time = input.nextLong();
        year = (int)time/(365*60*24);
        day =(int)(time/1440-(year*365));
        System.out.println(year+"  "+day);
    }
}
class Exercise2_8 {
     public static void main(String[] args) {
         long totalMilliseconds = System.currentTimeMillis();
         long totalSeconds = totalMilliseconds/1000;
         long currentSecond = totalSeconds%60;
         long totalMinutes = totalSeconds/60;
         long currentMinute = totalMinutes%60;
         long totalHours = totalMinutes/60;
         long currentHour = totalHours%24;
          System.out.println("当前的格林尼治时间为： "+currentHour+":"+currentMinute+":"+currentSecond);
         int shift;
         Scanner input =new Scanner(System.in);
         System.out.println("请输入时间的偏移量（整数）：");
         shift = input.nextInt();
        System.out.println("当前的转换时间为： "+(currentHour+shift)+":"+currentMinute+":"+currentSecond);
     }
}
class Exercise2_9{
     public static void main(String[] args) {
         float v0,v1,time;
         Scanner input =new Scanner(System.in);
         System.out.println("请分别输入初速度、末速度以及时间：");
         v0 = input.nextFloat();
         v1 = input.nextFloat();
         time = input.nextFloat();
         System.out.println("平均加速度为 "+(float)((v1-v0)/time));
     }
}
class Exercise2_10 {
    public static void main(String[] args) {
    float kilograms;
    float initial;
    float last;
    Scanner input =new Scanner(System.in);
    System.out.println("请分别输入水的重量、初始温度以及末温度：");
    kilograms = input.nextFloat();
    initial =input.nextFloat();
    last = input.nextFloat();
    System.out.println("所需的能量为 "+(kilograms*4184*(last-initial)));
    }
}
class Exercise2_12 {
    public static void main(String[] args) {
       float speed,accleration;
       Scanner input = new Scanner(System.in);
       System.out.println("请输入起飞速度和起飞加速度：");
       speed = input.nextFloat();
       accleration = input.nextFloat();
       System.out.println(" 起飞的最短距离为： "+ (speed*speed/(2*accleration))+"米");
    }
}
class Exercise2_13 {
    public static void main(String[] args) {
        double money,profit,month;
        double lastmoey = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入钱的初始值、利率以及需要计算的月份：");
        money = input.nextDouble();
        profit = input.nextDouble();
        month = input.nextDouble();
        for(int i=1;i<=month;i++) {
            lastmoey=(lastmoey+money)*(1+profit/1200.0);
        }
        System.out.printf("%.2f",lastmoey);
    }
}
class Exercise2_14 {
    public static void main(String[] args) {
       float pounds,inches,BMI;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你的身高（米）和体重（千克）：");
        inches = input.nextFloat();
        pounds = input.nextFloat();
        BMI = pounds/(inches*inches);
        System.out.printf("你的BMI指数是：%.2f",BMI);
    }
}
class Exercise2_15 {
     public static void main(String[] args) {
         float x1,x2,y1,y2,instance;
         Scanner input = new Scanner(System.in);
         System.out.println("请输入x1,y1,x2,y2：");
         x1 = input.nextFloat();
         y1 = input.nextFloat();
         x2 = input.nextFloat();
         y2 = input.nextFloat();
         instance = (float)Math.pow(((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)),0.5);
         System.out.println("这两个点的距离是" +instance);
     }
}
class Exercise2_16 {
    public static void main(String[] args) {
        
    }
}