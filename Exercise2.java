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
        System.out.println("�����������ߣ��ף������أ�ǧ�ˣ���");
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
    public static void main(String[] args) {
        
    }
}