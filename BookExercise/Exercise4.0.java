import  java.util.Scanner;
class Exercise4_1 {
    public static void main(String[] args) {
        double r;
        System.out.println("��������������ĵ�����ľ���:");
        Scanner input = new Scanner(System.in);
        r = input.nextDouble();
        double s = 2*r*Math.sin(Math.PI/5);
        double area = (5*s*s)/(4*Math.tan(Math.PI/5));
        System.out.printf("�������ε������:%.2f",area);
    }
}
class Exercise4_2 {
     public static void main(String[] args) {
         double x1,y1,x2,y2;
        System.out.println("����������ľ�γ������(x1,y1),(x2,y2):");
        Scanner input = new Scanner(System.in);
        x1 = input.nextDouble();
        y1 = input.nextDouble();
        x2 = input.nextDouble();
        y2 = input.nextDouble();
        double  a1 = Math.toRadians(Math.abs(x1));
        double  b1 = Math.toRadians(Math.abs(y1));
        double a2 = Math.toRadians(Math.abs(x2));
        double b2 = Math.toRadians(Math.abs(y2));
        double d = 6371.01*Math.acos(a1)*Math.sin(a2)+Math.cos(b1)*Math.cos(b2)*Math.cos(b2-b1);
        System.out.println("��������Բ����Ϊ:"+Math.abs(d));
     }
}
class Exercise4_4 {
    public static void main(String[] args){
        double s;
        System.out.println("�����������εı߳�:");
        Scanner input = new Scanner(System.in);
        s = input.nextDouble();
        double area = (6*s*s)/(4*Math.tan(Math.PI/6));
        System.out.printf("��������ε������:%.2f",area);
    }
}
class Exercise4_5 {
    public static void main(String[] args) {
          int n;
          double r;
          Scanner input = new Scanner(System.in);
          System.out.println("���������εı���:");
          n = input.nextInt();
          System.out.println("���������εı߳�:");
          r = input.nextDouble();
          double s = (6*r*r)/(4*Math.tan(Math.PI/n));
          System.out.printf("�������ε������:%.2f",s;
    }
}
class Exercise4_6 {
    public static void main(String[] args) {
        
    }
}