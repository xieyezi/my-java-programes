import java.util.Scanner;
class Exercise1_1 {
    public static void main(String[] args){
        System.out.println("Welcome to java!");
        System.out.println("Welcome to Computer Science!");
        System.out.println("Programming!");
    }
}

class Exercise1_2 {
    public static void main(String[] args){
        for(int i=0;i<5;i++) {
           System.out.println("Welcome to java!");
        }
    }
}
class Exercise1_3 {
    public static void main(String[] args){
        System.out.println("    J        A          V     V             A             ");
        System.out.println("    J       A A          V   V             A A            ");
        System.out.println("J   J      AA AA          V V             AA AA           ");
        System.out.println(" J J      A     A          V             A     A          ");
       
    }
} 
class Exercise1_4 {
    public static void main(String[] args){
        System.out.println("a   a^2     a^3");
        for(int i=1;i<=4;i++){
        System.out.println(i+"      "+i*i+"     "+i*i*i);
        }
    }
}

class Exercise1_5 {
    public static void main(String[] args){
        System.out.println((9.5*4.5-2.5*3)/(45.5-3.5));
        
    }
}

class Exercise1_6 {
    public static void main(String[] args){
        int sum=0;
      for(int i=1;i<10;i++) {
          sum=sum+i;
      }
      System.out.println(sum);
    }
}
class Exercise1_7 {
    public static void main(String[] args) {
        double PI=0;
        for(int i=0;i<13;i++) {
            PI=PI+ 4*Math.pow(-1,i)/(2*i+1);
        }
        System.out.println(PI);
    }
}
class Exercise1_8 {
    public static void main(String[] args) {
        double  zhouchang;
        double  mianji;
        zhouchang=2*5.5*3.1415926;
        mianji=5.5*5.5*3.1415926;
        System.out.println("该圆的周长是"+zhouchang+"  面积是"+mianji);
    }
}
class Exercise1_9 {
    public static void main(String[] args) {
        float wide;
        float high;
        float mianji=0;
        System.out.println("请输入宽：");
        Scanner input=new Scanner(System.in);
        wide=input.nextFloat();
        System.out.println("请输入长：");
         high=input.nextFloat();
        mianji=wide*high;
        System.out.println(mianji);
    }
}
/* 计算1-1234的素数的个数
class Text {  
    public static void main(String[] args) {
        int num = 0;
        for(int i = 2;i<=1234;i++) {
            if(isPrime(i) == true) {
            System.out.println(i);
            num++;
            }
        }
        System.out.println(num);
    }

    public static boolean isPrime(int num) {
        boolean flag =true;
        for(int j=2;j<num;j++){
            if(num%j == 0) {
            flag = false;
            break;
            }
        }
        return flag;
    }
}
*/

class Exercise1_10 {
    public static void main(String[] args) {
      double time;
      double mile;
      time=45.5/60.0;
      mile=14/1.60;
      System.out.println(mile/time);
    }
}
class Exercise1_11 {
    public static void main(String[] args) {
       int time=365*24*3600;
       int peopelenumber = 312032486;
        for(int i=1;i<=5;i++) {
            peopelenumber=(int)(peopelenumber+time/7+time/45-time/13);
    }
     System.out.println(peopelenumber);
  }
}
class Exercise1_12 {
    public static void main(String[] args) {
      double time;
      double mile;
      time=2435/3600;
      mile=24*1.6;
      System.out.println(mile/time);
    }
}
class Exercise1_13 {
    public static void main(String[] args){
    float e=44.5f;
    float f=5.9f;
    float x,y;
    System.out.println("请输入a:");
    Scanner input1=new Scanner(System.in);
    float a=input1.nextFloat();
    System.out.println("请输入b:");
    Scanner input2=new Scanner(System.in);
    float  b=input2.nextFloat();
    System.out.println("请输入c:");
    Scanner input3=new Scanner(System.in);
    float c=input3.nextFloat();
    System.out.println("请输入d:");
    Scanner input4=new Scanner(System.in);
    float  d=input4.nextFloat();
    x = (e*d-b*f)/(a*d-b*c);
    y = (a*f-e*c)/(a*d-b*c);
    System.out.println("x="+x+"\ty="+y);
    }
}