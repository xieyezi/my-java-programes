import java.util.Scanner;
class Exercise3_1 {
    public static void main(String[] args) {
        float a,b,c,d;
        Scanner input =new Scanner(System.in);
        System.out.println("������a,b,c:");
        a = input.nextFloat();
        b = input.nextFloat();
        c = input.nextFloat();
        d = b*b-4*a*c;
        if(d<0)
        System.out.println("������ʵ����");
        else if(d == 0) {
            System.out.println("�������������ʵ����x1=x2="+((-b)+Math.pow(d,0.5))/2*a);
        }
        else
        System.out.println("������������ʵ����x1="+((-b)+Math.pow(d,0.5))/2*a+" x2="+((-b)-Math.pow(d,0.5))/2*a);
    }
}
class Exercise3_2 {
    public static void main(String[] args) {
        int a,b,c;
         Scanner input =new Scanner(System.in);
         System.out.println("������������λ������a,b��");
         a = input.nextInt();
         b = input.nextInt();
         System.out.println("a+b=?");
         c = input.nextInt();
         if(c == (a+b))
            System.out.println("��ô���Ӵ����ȷ����");
         else
            System.out.println("���Ǳ�������ȷ�Ĵ���"+(a+b));  
    }
}
class Exercise3_3 {
    public static void main(String[] args) {
        //i������������·���//
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
                default:System.out.println("û�����������������");
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
       System.out.println("�������λ��֤�룺");
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
        System.out.println("��ô���Ӵ����ȷ����");
        else
        System.out.println("���Ǳ�������ȷ�Ĵ���"+(a+b));  
    }
}
class Exercise3_11 {
     public static void main(String[] args) {
        int year,month;
        boolean flag = true;
        Scanner input =new Scanner(System.in);
        System.out.println("��������֪���� ��ݺ��·ݣ�");
        year = input.nextInt();
        month = input.nextInt();
        flag = ((year%4 == 0 && year%100 != 0)||(year%400 == 0));
        switch(month) {
            case 1: System.out.println(year+"��"+month+"����31��");break;
            case 2:{
                if(flag) {
                System.out.println(year+"��"+month+"����29��");break;
                }
                else {
                 System.out.println(year+"��"+month+"����28��");break;
                }
            }
            case 3:System.out.println(year+"��"+month+"����31��");break;
            case 4:System.out.println(year+"��"+month+"����30��");break;
            case 5:System.out.println(year+"��"+month+"����31��");break;
            case 6:System.out.println(year+"��"+month+"����30��");break;
            case 7:System.out.println(year+"��"+month+"����31��");break;
            case 8:System.out.println(year+"��"+month+"����31��");break;
            case 9:System.out.println(year+"��"+month+"����30��");break;
            case 10:System.out.println(year+"��"+month+"����30��");break;
            case 11:System.out.println(year+"��"+month+"����30��");break;
            case 12:System.out.println(year+"��"+month+"����31��");break;
            default:System.out.println("�������");break;
        }
    }
}
class Exercise3_12 {
    public static void main(String[] args) {
        int num,a,b;
        Scanner input =new Scanner(System.in);
        System.out.println("������һ����λ������");
        num = input.nextInt();
        a = num/100;
        b = num%10;
        if(a == b) {
            System.out.println("������ǻ�������");
        }
        else
        System.out.println("��������ǻ�������");
    }
}
class Exercise3_14 {
     public static void main(String[] args) {
         int a,b;
         char c;
         Scanner input =new Scanner(System.in);
         System.out.println("��һ��Ӳ���������Ƿ���0������1����������");
         b = (int)(Math.random()*2);
         if(b == 1) {
             c = '��';
         }
         else {
             c = '��';
         }
         a = input.nextInt();
         if (a == b){
              System.out.println("Ӳ��Ϊ"+c+"��");
              System.out.println("������ã���Ȼ�¶��ˣ�");
         }
         else {
              System.out.println("Ӳ��Ϊ"+c+"��");
             System.out.println("����ĳ���ù����ù�ȣ�");
         }
     }
}
class Exercise3_15  {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int lottery = (int) (Math.random()*1000);
        System.out.println("��������Ĳ�Ʊ��(��λ��):");
        int guess = input.nextInt();
        int lotteryDigit1 = lottery%10;
        int lotteryDigit2 = (lottery/10)%10;
        int lotteryDigit3 = lottery/100;
        int guessDigit1 = guess%10;
        int guessDigit2 = (guess/10)%10;
        int guessDigit3 = guess/100;
        System.out.println("��ȷ�Ĳ�Ʊ����"+lottery);
        if (lottery == guess)
           System.out.println("��������Ӵ,��ȫ�¶���,�㽫�õ�10000��Ԫ!");
        else if (  (lotteryDigit1 == guessDigit2
                    && lotteryDigit2 == guessDigit3
                    && lotteryDigit3 == guessDigit1)||
                  (
                    lotteryDigit1 == guessDigit3
                    && lotteryDigit2 == guessDigit1
                    && lotteryDigit3 == guessDigit2)
                )
                  System.out.println("����Ҳ������,����ȫ�¶���,�㽫�õ�3000��Ԫ!");   
         else if (  lotteryDigit1 == guessDigit2
                 || lotteryDigit1 == guessDigit3
                 || lotteryDigit1 == guessDigit1
                 || lotteryDigit2 == guessDigit3
                 )
                  System.out.println("�����е�����Ŷ,������һ������,�㽫�õ�1000��Ԫ!");
         else
          System.out.println("����ĳ���ù�ɶ��û��!");
    }
}
class Exercise3_16 {
    public static void main(String[] args) {
        int x,y;
        x = (int)(Math.random()*101);
        y = (int)(Math.random()*201);
        System.out.println("�������������:("+x+","+y+")");
    }
}
//3_17�е�����,�д��޸�//
class Exercise3_17 {
    public static void main(String[] args) {
        int computer,people;
        String a,b;
        computer = (int)(Math.random()*3);
        Scanner input =new Scanner(System.in);
        if (computer == 0)
             a = "ʯͷ";
        else if(computer == 1)
             a = "����";
        else
             a = "��";
        System.out.println("ʯͷ(0),����(1),��(2)");
        people = input.nextInt();
        if (computer == 0)
             b = "ʯͷ";
        else if(computer == 1)
             b = "����";
        else
             b = "��";
             
         if(a == "ʯͷ" && b == "ʯͷ" )
           System.out.println("���Ƕ�������ʯͷ,��ƽ��!");
            else if(a == "ʯͷ" && b == "����")
            System.out.println("���Գ�����ʯͷ,������Ǽ���,������!");
            else if(a == "ʯͷ" && b == "��")
            System.out.println("���Գ�����ʯͷ,������ǲ�,��Ӯ��!");
            else if(a == "����" && b == "ʯͷ" )
            System.out.println("���Գ����Ǽ���,�������ʯͷ,��Ӯ��!");
            else if(a == "����" && b == "����")
            System.out.println("���Գ����Ǽ���,������Ǽ���,��ƽ��!");
            else if(a == "����" && b == "��")
            System.out.println("���Գ����Ǽ���,������ǲ�,������!");
            else if(a == "��" && b == "ʯͷ")
            System.out.println("���Գ����ǲ�,�������ʯͷ,������!");
            else if(a == "��" && b == "����")
            System.out.println("���Գ����ǲ�,������Ǽ���,��Ӯ��!");
         else
            System.out.println("���Գ����ǲ�,������ǲ�,��ƽ��!");
    }
}
class Exercise3_18 {
     public static void main(String[] args) {
         float weight;
         Scanner input =new Scanner(System.in);
         System.out.println("�������������:");
         weight = input.nextFloat();
         if(weight>0 && weight<=1)
         System.out.println("����ɱ�Ϊ3.5Ԫ!");
         else if(weight>1 && weight<=3)
         System.out.println("����ɱ�Ϊ5.5Ԫ!");
         else if(weight>3 && weight<=10)
         System.out.println("����ɱ�Ϊ8.5Ԫ!");
         else if (weight>10 && weight<=20)
         System.out.println("����ɱ�Ϊ10.5Ԫ!");
         else if(weight>20)
         System.out.println("����������!");
     }
}
class Exercise3_19 {
    public static void main(String[] args) {
        float a,b,c;
        Scanner input =new Scanner(System.in);
         System.out.println("����������������:");
         a = input.nextFloat();
         b = input.nextFloat();
         c = input.nextFloat();
         if( ((a+b)>c) &&((a+c)>b) && ((b+c)>a))
         System.out.println("�����ε��ܳ���:"+(a+b+c));
         else
         System.out.println("������������߲��ܹ���������!");
    }
}
class Exercise3_21 {
     public static void main(String[] args) {
         int year,month,day,h;
         Scanner input =new Scanner(System.in);
         System.out.println("��������,��,�Լ�����µĵڼ���:");
         year = input.nextInt();
         month = input.nextInt();
         if(month == 1)
           month =13;
         else if(month == 2)
         month = 14;
         day = input.nextInt();
         String[] monthnumber ={"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday",};
         h = ((day+(26*(month+1)/10)+year%100+(year%100)/4+year/100/4+5*(year/100)))%7;
         System.out.println("��һ����"+monthnumber[h-1]);
     }
}
class Exercise3_22 {
    public static void main(String[] args) {
        double x,y;
        Scanner input =new Scanner(System.in);
        x = input.nextDouble();
        y = input.nextDouble();
        System.out.println("������һ���������:");
        double instance = Math.pow((x*x+y*y),0.5);
        if(instance<=10)
        System.out.println("�õ���԰��!");
        else
        System.out.println("�õ���Բ��!");
    }
}
class Exercise3_23 {
    public static void main(String[] args) {
        double x,y;
        Scanner input =new Scanner(System.in);
        System.out.println("������һ���������:");
         x = input.nextDouble();
         y = input.nextDouble();
        if(Math.abs(x)<=5.0 && Math.abs(y)<=2.5)
        System.out.println("�õ��ھ�����!");
        else
        System.out.println("�õ��ھ�����!");
    }
}
class Exercise3_24 {
    public static void main(String[] args) {
        int a,b;
        a = (int)(Math.random()*13);
        b = (int)(Math.random()*4);
        String arr1[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String arr2[] = {"��÷��","�췽��","����","����"};
        System.out.println("��鵽����Ϊ"+arr2[b]+arr1[a]);
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
        System.out.println("����ֱ��ƽ��,û�н���!");
    }
}
class Exercise3_26 {
   public static void main(String[] args) {
       int num;
       Scanner input = new Scanner(System.in);
       num = input.nextInt();
       if(num%5 == 0 && num%6 == 0)
           System.out.println("�����ܱ�5��6����!");
       else if(num%5 == 0 || num%6 == 0)
           System.out.println("�����ܱ�5��6����!");
       else if ((num%5 == 0 || num%6 == 0) && (num%5 == 0 && num%6 == 0))
       System.out.println("�����ܱ�5��6����,�����ܱ�����ͬʱ����!");     
   }
}
class Exercise3_27 {
    public static void main(String[] args) {
        System.out.println("������ (x,y) :");
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        double y = input.nextDouble();
        if(x>0 && x<200) {
        
            if(y>0 && y<100) {
            
                if(2*y+x-200<0)
                   System.out.println("�õ�����������!");
                else
                    System.out.println("�õ㲻����������!");
               }
            else
                System.out.println("�õ㲻����������!");
        }
      else
           System.out.println("�õ㲻����������!"); 
    }
}
class Exercise3_28 {
    public static void main(String[] args) {
        System.out.println("�����һ�������е��x��y :");
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double w1 = input.nextDouble();
        double h1= input.nextDouble(); 
        System.out.println("����ڶ��������е��x��y :");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double w2 = input.nextDouble();
        double h2= input.nextDouble();
        double p = Math.pow(Math.pow(y2-y1,2),0.5);
        double q = Math.pow(Math.pow(x2-x1,2),0.5);
        if(q<(w1-w2)/2 && p<(h1-h2)/2) {
            System.out.println(" �ڶ��������ڵ�һ����! ");
        } 
        else if(q>(w1-w2)/2&&q<(w1+w2)/2&&p>(h1-h2)/2&&p<(h1+h2)/2){
            System.out.println("�������ص�! ");
        }
        else{
            System.out.println("�����β��ص�! ");
        }
    }
}
class Exercise3_29 {
    public static void main(String[] args){
        System.out.println("�������һ��Բ��Բ������Ͱ뾶 :");
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double r1 = input.nextDouble();
        System.out.println("������ڶ���Բ��Բ������Ͱ뾶 :");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double r2 = input.nextDouble();
        double s = Math.pow(Math.pow(x2-x1,2)+Math.pow(y2-y1,2),0.5);
        if(s<Math.pow(Math.pow(r2-r1,2),0.5)){
            System.out.println("�ڶ���Բ�ڵ�һ��Բ��!");
        }
        else if(s<r1+r2){
            System.out.println("����Բ�ص�!");
        }
        else
            System.out.println("����Բ���ص�!");
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

