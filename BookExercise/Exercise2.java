import java.util.Scanner;
class Exercise2_1{
    public static void main(String[] args) {
        double temperature;
        Scanner input =new Scanner(System.in);
        System.out.println("�����������¶ȣ�");
        temperature = input.nextDouble();
        System.out.println((9.0/5)*temperature+32);
    }
}
class Exercise2_2 {
    public static void main(String[] args) {
        double radius,high;
        double volume;
      Scanner input =new Scanner(System.in);
       System.out.println("������뾶��");
       radius = input.nextDouble();
        System.out.println("������ߣ�");
        high = input.nextDouble();
        volume = (radius*radius*3.1415926)*high;
        System.out.println("��Բ��������ǣ�"+volume);
    }
}
class Exercise2_3 {
     public static void main(String[] args) {
         float mile;
         Scanner input =new Scanner(System.in);
         System.out.println("������Ӣ������");
         mile = input.nextFloat();
         System.out.println(mile+" feet is "+mile*0.305f+" meters");
     }
    
}
class Exercise2_4 {
     public static void main(String[] args) {
         float pounds;
         Scanner input =new Scanner(System.in);
         System.out.println("������Ӣ������");
         pounds = input.nextFloat();
         System.out.println(pounds+" pounds is "+pounds*0.454f+" kilograms");
     }
}
class Exercise2_5 {
   public static void main(String[] args) {
       float money,moneyrate;
       Scanner input =new Scanner(System.in);
       System.out.println("��������úͳ���ʣ�");
       money = input.nextFloat();
       moneyrate = input.nextFloat();
       System.out.println("���Ϊ "+money*(moneyrate/100)+" �ܷ���Ϊ " +money*(1+moneyrate/100));
   }
}
class Exercise2_6 {
     public static void main(String[] args) {
         int num,a,b,c;
         Scanner input =new Scanner(System.in);
         System.out.println("������һ����λ��������");
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
        System.out.println("�������������");
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
          System.out.println("��ǰ�ĸ�������ʱ��Ϊ�� "+currentHour+":"+currentMinute+":"+currentSecond);
         int shift;
         Scanner input =new Scanner(System.in);
         System.out.println("������ʱ���ƫ��������������");
         shift = input.nextInt();
        System.out.println("��ǰ��ת��ʱ��Ϊ�� "+(currentHour+shift)+":"+currentMinute+":"+currentSecond);
     }
}
class Exercise2_9{
     public static void main(String[] args) {
         float v0,v1,time;
         Scanner input =new Scanner(System.in);
         System.out.println("��ֱ�������ٶȡ�ĩ�ٶ��Լ�ʱ�䣺");
         v0 = input.nextFloat();
         v1 = input.nextFloat();
         time = input.nextFloat();
         System.out.println("ƽ�����ٶ�Ϊ "+(float)((v1-v0)/time));
     }
}
class Exercise2_10 {
    public static void main(String[] args) {
    float kilograms;
    float initial;
    float last;
    Scanner input =new Scanner(System.in);
    System.out.println("��ֱ�����ˮ����������ʼ�¶��Լ�ĩ�¶ȣ�");
    kilograms = input.nextFloat();
    initial =input.nextFloat();
    last = input.nextFloat();
    System.out.println("���������Ϊ "+(kilograms*4184*(last-initial)));
    }
}
class Exercise2_12 {
    public static void main(String[] args) {
       float speed,accleration;
       Scanner input = new Scanner(System.in);
       System.out.println("����������ٶȺ���ɼ��ٶȣ�");
       speed = input.nextFloat();
       accleration = input.nextFloat();
       System.out.println(" ��ɵ���̾���Ϊ�� "+ (speed*speed/(2*accleration))+"��");
    }
}
class Exercise2_13 {
    public static void main(String[] args) {
        double money,profit,month;
        double lastmoey = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("������Ǯ�ĳ�ʼֵ�������Լ���Ҫ������·ݣ�");
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
        System.out.println("������������ߣ��ף������أ�ǧ�ˣ���");
        inches = input.nextFloat();
        pounds = input.nextFloat();
        BMI = pounds/(inches*inches);
        System.out.printf("���BMIָ���ǣ�%.2f",BMI);
    }
}
class Exercise2_15 {
     public static void main(String[] args) {
         float x1,x2,y1,y2,instance;
         Scanner input = new Scanner(System.in);
         System.out.println("������x1,y1,x2,y2��");
         x1 = input.nextFloat();
         y1 = input.nextFloat();
         x2 = input.nextFloat();
         y2 = input.nextFloat();
         instance = (float)Math.pow(((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)),0.5);
         System.out.println("��������ľ�����" +instance);
     }
}
class Exercise2_16 {
        public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("�����������εı߳���" );
        double s = input.nextDouble();
        double p = 1.5*(Math.pow(3,0.5))*s*s;
        System.out.println("�����ε����Ϊ�� " + p);
    }
}
class Exercise2_17 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("������-58����41��֮��Ķ����Լ�����:");
        double t = input.nextDouble();
        double v = input.nextDouble();
        double T = 35.74 + 0.6215*t -35.75*Math.pow(v,0.16) + 0.4275*t*Math.pow(v,0.16);
        System.out.println("�纮�¶�Ϊ: " + T);
    }
}
class Exercise2_18 {
     public static void main(String[] args)
    {
        int k =0;
        for(float i=1;i<=5;i++)
        {
            System.out.printf("%-3d %-3d %-3d",(int)i,(int)(i+1),(int)Math.pow(i,i+1));
            if(k%3==0)
            {
                System.out.println();
            }
        }
    }
}
class Exercise2_19 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
         System.out.println("�����������ε�������:");
        double x1 =input.nextDouble();
        double y1 =input.nextDouble();
        double x2 =input.nextDouble();
        double y2 =input.nextDouble();
        double x3 =input.nextDouble();
        double y3 =input.nextDouble();
        double s,a1,b1,c1,p ;
        a1 = Math.pow(Math.pow(x2-x1,2)+Math.pow(y2-y1,2),0.5);
        b1 = Math.pow(Math.pow(x3-x1,2)+Math.pow(y3-y1,2),0.5);
        c1 = Math.pow(Math.pow(x2-x3,2)+Math.pow(y2-y3,2),0.5);
        s = (a1+b1+c1)/2;
        p = Math.pow(s*(s-a1)*(s-b1)*(s-c1),0.5);
        System.out.println("�������ε����Ϊ:"+p);
    }
}
class Exercise2_20 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("��������֧����������: " );
        double a = input.nextDouble();
        double b = input.nextDouble();
        double s;
        s = a * (b/1200);
        System.out.println("������ϢΪ: " + s);
    }
}
class Exercise2_21 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("������Ͷ�ʽ��,�������Լ�����:");
        double a = input.nextDouble(); 
        double b = input.nextDouble();
        int year = input.nextInt();
        double s = a*Math.pow(1+b/(100*12),year*12);
        System.out.println("δ����Ͷ�ʽ����:" + s);
    }
}
class Exercise2_23 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
         System.out.println("�������ʻ����,����ÿ���ض���Ӣ���Լ�ÿ���صļ۸�:");
        double distance = input.nextDouble();
        double out = input.nextDouble();
        double price = input.nextDouble();
        double s = distance/out*price;
        System.out.println("�ó̵ķ���Ϊ:"+s);
    }
}