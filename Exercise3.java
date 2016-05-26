import java.util.Scanner;
class Exercise3_1 {
    public static void main(String[] args) {
        float a,b,c,d;
        Scanner input =new Scanner(System.in);
        System.out.println("请输入a,b,c:");
        a = input.nextFloat();
        b = input.nextFloat();
        c = input.nextFloat();
        d = b*b-4*a*c;
        if(d<0)
        System.out.println("方程无实根！");
        else if(d == 0) {
            System.out.println("方程有两个相等实根，x1=x2="+((-b)+Math.pow(d,0.5))/2*a);
        }
        else
        System.out.println("方程有两不等实根，x1="+((-b)+Math.pow(d,0.5))/2*a+" x2="+((-b)-Math.pow(d,0.5))/2*a);
    }
}
class Exercise3_2 {
    public static void main(String[] args) {
        int a,b,c;
         Scanner input =new Scanner(System.in);
         System.out.println("请输入两个三位的整数a,b：");
         a = input.nextInt();
         b = input.nextInt();
         System.out.println("a+b=?");
         c = input.nextInt();
         if(c == (a+b))
            System.out.println("你好聪明哟，正确啦！");
         else
            System.out.println("你是笨蛋吗？正确的答案是"+(a+b));  
    }
}
class Exercise3_3 {
    public static void main(String[] args) {
        //i是随机产生的月份数//
       int i;
        for(int j = 1;j<=12;j++) {
            i =(int)( Math.random()*13);
            switch(i) {
                case 1:System.out.println(i+"--Januery");break;
                case 2:System.out.println(i+"--February");break;
                case 3:System.out.println(i+"--March");break;
                case 4:System.out.println(i+"--April");break;
                case 5:System.out.println(i+"--May");break;
                case 6:System.out.println(i+"--June");break;
                case 7:System.out.println(i+"--July");break;
                case 8:System.out.println(i+"--August");break;
                case 9:System.out.println(i+"--September");break;
                case 10:System.out.println(i+"--October");break;
                case 11:System.out.println(i+"--November");break;
                case 12:System.out.println(i+"--December");break;
                default:System.out.println("没有正常产生随机数！");
            }
        }
    }
}
class Exercise3_9 {
    public static void main(String[] args) {
       int num ;
       int d10 = 0;
        int j;
       Scanner input =new Scanner(System.in);
       System.out.println("请输入九位验证码：");
       num = input.nextInt();
       for (int i = 1;i<=9;i++) {
           j=num%10;
           d10+=j*(10-i);
           j=num/10;
       }
       if(d10 == 10) {
        System.out.printf("%dX",num);
       }
       else
       System.out.printf("%d%d",num,d10);
    }
}
class Exercise3_10 {
    public static void main(String[] args) {
        int a,b,c;
        Scanner input =new Scanner(System.in);
        a = (int)( Math.random()*101);
        b = (int)( Math.random()*13);
        System.out.printf("%d+%d=?\n",a,b);
        c = input.nextInt();
        if(c == (a+b))
        System.out.println("你好聪明哟，正确啦！");
        else
        System.out.println("你是笨蛋吗？正确的答案是"+(a+b));  
    }
}
class Exercise3_11 {
     public static void main(String[] args) {
        int year,month;
        boolean flag = true;
        Scanner input =new Scanner(System.in);
        System.out.println("请输入想知道的 年份和月份：");
        year = input.nextInt();
        month = input.nextInt();
        flag = ((year%4 == 0 && year%100 != 0)||(year%400 == 0));
        switch(month) {
            case 1: System.out.println(year+"年"+month+"月有31天");break;
            case 2:{
                if(flag) {
                System.out.println(year+"年"+month+"月有29天");break;
                }
                else {
                 System.out.println(year+"年"+month+"月有28天");break;
                }
            }
            case 3:System.out.println(year+"年"+month+"月有31天");break;
            case 4:System.out.println(year+"年"+month+"月有30天");break;
            case 5:System.out.println(year+"年"+month+"月有31天");break;
            case 6:System.out.println(year+"年"+month+"月有30天");break;
            case 7:System.out.println(year+"年"+month+"月有31天");break;
            case 8:System.out.println(year+"年"+month+"月有31天");break;
            case 9:System.out.println(year+"年"+month+"月有30天");break;
            case 10:System.out.println(year+"年"+month+"月有30天");break;
            case 11:System.out.println(year+"年"+month+"月有30天");break;
            case 12:System.out.println(year+"年"+month+"月有31天");break;
            default:System.out.println("输入错误！");break;
        }
    }
}
class Exercise3_12 {
    public static void main(String[] args) {
        int num,a,b;
        Scanner input =new Scanner(System.in);
        System.out.println("请输入一个三位整数：");
        num = input.nextInt();
        a = num/100;
        b = num%10;
        if(a == b) {
            System.out.println("这个数是回文数！");
        }
        else
        System.out.println("这个数不是回文数！");
    }
}
class Exercise3_14 {
     public static void main(String[] args) {
         int a,b;
         char c;
         Scanner input =new Scanner(System.in);
         System.out.println("猜一猜硬币是正还是反（0代表反，1代表正）：");
         b = (int)(Math.random()*2);
         if(b == 1) {
             c = '正';
         }
         else {
             c = '反';
         }
         a = input.nextInt();
         if (a == b){
              System.out.println("硬币为"+c+"面");
              System.out.println("运气真好，居然猜对了！");
         }
         else {
              System.out.println("硬币为"+c+"面");
             System.out.println("你真的超倒霉额，你个霉比！");
         }
     }
}
class Exercise3_15  {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int lottery = (int) (Math.random()*1000);
        System.out.println("请输入你的彩票号(三位数):");
        int guess = input.nextInt();
        int lotteryDigit1 = lottery%10;
        int lotteryDigit2 = (lottery/10)%10;
        int lotteryDigit3 = lottery/100;
        int guessDigit1 = guess%10;
        int guessDigit2 = (guess/10)%10;
        int guessDigit3 = guess/100;
        System.out.println("正确的彩票号是"+lottery);
        if (lottery == guess)
           System.out.println("运气超好哟,完全猜对啦,你将得到10000美元!");
        else if (  (lotteryDigit1 == guessDigit2
                    && lotteryDigit2 == guessDigit3
                    && lotteryDigit3 == guessDigit1)||
                  (
                    lotteryDigit1 == guessDigit3
                    && lotteryDigit2 == guessDigit1
                    && lotteryDigit3 == guessDigit2)
                )
                  System.out.println("运气也不错嘛,数字全猜对啦,你将得到3000美元!");   
         else if (  lotteryDigit1 == guessDigit2
                 || lotteryDigit1 == guessDigit3
                 || lotteryDigit1 == guessDigit1
                 || lotteryDigit2 == guessDigit3
                 )
                  System.out.println("还是有点运气哦,猜中了一个数字,你将得到1000美元!");
         else
          System.out.println("你真的超倒霉额，啥都没中!");
    }
}
class Exercise3_16 {
    public static void main(String[] args) {
        int x,y;
        x = (int)(Math.random()*101);
        y = (int)(Math.random()*201);
        System.out.println("产生的随机点是:("+x+","+y+")");
    }
}
//3_17有点问题,有待修改//
class Exercise3_17 {
    public static void main(String[] args) {
        int computer,people;
        String a,b;
        computer = (int)(Math.random()*3);
        Scanner input =new Scanner(System.in);
        if (computer == 0)
             a = "石头";
        else if(computer == 1)
             a = "剪刀";
        else
             a = "布";
        System.out.println("石头(0),剪刀(1),布(2)");
        people = input.nextInt();
        if (computer == 0)
             b = "石头";
        else if(computer == 1)
             b = "剪刀";
        else
             b = "布";
             
         if(a == "石头" && b == "石头" )
           System.out.println("你们都出的是石头,打平啦!");
            else if(a == "石头" && b == "剪刀")
            System.out.println("电脑出的是石头,你出的是剪刀,你输啦!");
            else if(a == "石头" && b == "布")
            System.out.println("电脑出的是石头,你出的是布,你赢啦!");
            else if(a == "剪刀" && b == "石头" )
            System.out.println("电脑出的是剪刀,你出的是石头,你赢啦!");
            else if(a == "剪刀" && b == "剪刀")
            System.out.println("电脑出的是剪刀,你出的是剪刀,打平啦!");
            else if(a == "剪刀" && b == "布")
            System.out.println("电脑出的是剪刀,你出的是布,你输啦!");
            else if(a == "布" && b == "石头")
            System.out.println("电脑出的是布,你出的是石头,你输啦!");
            else if(a == "布" && b == "剪刀")
            System.out.println("电脑出的是布,你出的是剪刀,你赢啦!");
         else
            System.out.println("电脑出的是布,你出的是布,打平啦!");
    }
}
class Exercise3_18 {
     public static void main(String[] args) {
         float weight;
         Scanner input =new Scanner(System.in);
         System.out.println("请输入包裹重量:");
         weight = input.nextFloat();
         if(weight>0 && weight<=1)
         System.out.println("运输成本为3.5元!");
         else if(weight>1 && weight<=3)
         System.out.println("运输成本为5.5元!");
         else if(weight>3 && weight<=10)
         System.out.println("运输成本为8.5元!");
         else if (weight>10 && weight<=20)
         System.out.println("运输成本为10.5元!");
         else if(weight>20)
         System.out.println("包裹超重啦!");
     }
}
class Exercise3_19 {
    public static void main(String[] args) {
        float a,b,c;
        Scanner input =new Scanner(System.in);
         System.out.println("请输入三角形三边:");
         a = input.nextFloat();
         b = input.nextFloat();
         c = input.nextFloat();
         if( ((a+b)>c) &&((a+c)>b) && ((b+c)>a))
         System.out.println("三角形的周长是:"+(a+b+c));
         else
         System.out.println("你输入的三条边不能构成三角形!");
    }
}
class Exercise3_21 {
     public static void main(String[] args) {
         int year,month,day,h;
         Scanner input =new Scanner(System.in);
         System.out.println("请输入年,月,以及这个月的第几天:");
         year = input.nextInt();
         month = input.nextInt();
         if(month == 1)
           month =13;
         else if(month == 2)
         month = 14;
         day = input.nextInt();
         String[] monthnumber ={"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday",};
         h = ((day+(26*(month+1)/10)+year%100+(year%100)/4+year/100/4+5*(year/100)))%7;
         System.out.println("这一天是"+monthnumber[h-1]);
     }
}
class Exercise3_22 {
    public static void main(String[] args) {
        double x,y;
        Scanner input =new Scanner(System.in);
        x = input.nextDouble();
        y = input.nextDouble();
        System.out.println("请输入一个点的坐标:");
        double instance = Math.pow((x*x+y*y),0.5);
        if(instance<=10)
        System.out.println("该点在园内!");
        else
        System.out.println("该点在圆外!");
    }
}
class Exercise3_23 {
    public static void main(String[] args) {
        double x,y;
        Scanner input =new Scanner(System.in);
        System.out.println("请输入一个点的坐标:");
         x = input.nextDouble();
         y = input.nextDouble();
        if(Math.abs(x)<=5.0 && Math.abs(y)<=2.5)
        System.out.println("该点在矩形内!");
        else
        System.out.println("该点在矩形外!");
    }
}
class Exercise3_24 {
    public static void main(String[] args) {
        int a,b;
        a = (int)(Math.random()*13);
        b = (int)(Math.random()*4);
        String arr1[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String arr2[] = {"黑梅花","红方块","红心","黑桃"};
        System.out.println("你抽到的牌为"+arr2[b]+arr1[a]);
    }
}
class Exercise3_25 {
    public static void main(String[] args) {
        System.out.println("Enter x1,y1,x2,y2,x3,y3,x4,y4 :");
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        double x4 = input.nextDouble();
        double y4 = input.nextDouble();
        double x,y;
        double a,b,c,d,e,f;
        a = y1-y2;
        b = x2-x1;
        c = y3-y4;
        d = x4-x3;
        e = (y1-y2)*x1-(x1-x2)*y1;
        f = (y3-y4)*x3-(x3-x4)*y3;
        if((y2-y1)/(x2-x1) != (y4-y3)/(x4-x3)) {
            x = (e*d-b*f)/(a*d-b*c);
            y = (a*f-e*c)/(a*d-b*c);
            System.out.println("x=" + x + "," + "y="+y);
        }
        else
        System.out.println("两条直线平行,没有交点!");
    }
}
class Exercise3_26 {
   public static void main(String[] args) {
       int num;
       Scanner input = new Scanner(System.in);
       num = input.nextInt();
       if(num%5 == 0 && num%6 == 0)
           System.out.println("该数能被5和6整除!");
       else if(num%5 == 0 || num%6 == 0)
           System.out.println("该数能被5或6整除!");
       else if ((num%5 == 0 || num%6 == 0) && (num%5 == 0 && num%6 == 0))
       System.out.println("该数能被5或6整除,但不能被他们同时整除!");     
   }
}
class Exercise3_27 {
    public static void main(String[] args) {
        System.out.println("请输入 (x,y) :");
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        double y = input.nextDouble();
        if(x>0 && x<200) {
        
            if(y>0 && y<100) {
            
                if(2*y+x-200<0)
                   System.out.println("该点在三角形内!");
                else
                    System.out.println("该点不在三角形内!");
               }
            else
                System.out.println("该点不在三角形内!");
        }
      else
           System.out.println("该点不在三角形内!"); 
    }
}
class Exercise3_28 {
    public static void main(String[] args) {
        System.out.println("输入第一个矩形中点的x和y :");
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double w1 = input.nextDouble();
        double h1= input.nextDouble(); 
        System.out.println("输入第二个矩形中点的x和y :");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double w2 = input.nextDouble();
        double h2= input.nextDouble();
        double p = Math.pow(Math.pow(y2-y1,2),0.5);
        double q = Math.pow(Math.pow(x2-x1,2),0.5);
        if(q<(w1-w2)/2 && p<(h1-h2)/2) {
            System.out.println(" 第二个矩形在第一个内! ");
        } 
        else if(q>(w1-w2)/2&&q<(w1+w2)/2&&p>(h1-h2)/2&&p<(h1+h2)/2){
            System.out.println("两矩形重叠! ");
        }
        else{
            System.out.println("两矩形不重叠! ");
        }
    }
}
class Exercise3_29 {
    public static void main(String[] args){
        System.out.println("请输入第一个圆的圆心坐标和半径 :");
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double r1 = input.nextDouble();
        System.out.println("请输入第二个圆的圆心坐标和半径 :");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double r2 = input.nextDouble();
        double s = Math.pow(Math.pow(x2-x1,2)+Math.pow(y2-y1,2),0.5);
        if(s<Math.pow(Math.pow(r2-r1,2),0.5)){
            System.out.println("第二个圆在第一个圆内!");
        }
        else if(s<r1+r2){
            System.out.println("两个圆重叠!");
        }
        else
            System.out.println("两个圆不重叠!");
    }
}
class Exercise3_31 {
    public static void main(String[] args){
        System.out.println("Enter the exchange rate from dollars to RMB : ");
        Scanner input = new Scanner(System.in);
        double t = input.nextDouble();
        System.out.println("Enter 0 to convert dollars to RMB and 1 vice versa : ");
        int num = input.nextInt();
        System.out.println("Enter the dollars amount : ");
        double dollars = input.nextDouble();
        double s;
        if(num == 1){
            s = dollars*t;
            System.out.println("$" + dollars + " is " + s + " yuan");
        }
        else if(num ==0){
            s = dollars/t;
            System.out.println( dollars + " yuan" + " is " + "$" + s );
        }
        else
            System.out.println( "Incorrect input");
    }
}

