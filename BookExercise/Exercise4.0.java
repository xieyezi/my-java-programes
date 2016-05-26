import  java.util.Scanner;
class Exercise4_1 {
    public static void main(String[] args) {
        double r;
        System.out.println("请输入五边形中心到顶点的距离:");
        Scanner input = new Scanner(System.in);
        r = input.nextDouble();
        double s = 2*r*Math.sin(Math.PI/5);
        double area = (5*s*s)/(4*Math.tan(Math.PI/5));
        System.out.printf("这个五边形的面积是:%.2f",area);
    }
}
class Exercise4_2 {
     public static void main(String[] args) {
         double x1,y1,x2,y2;
        System.out.println("请输入两点的经纬度坐标(x1,y1),(x2,y2):");
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
        System.out.println("两点的最大圆距离为:"+Math.abs(d));
     }
}
class Exercise4_4 {
    public static void main(String[] args){
        double s;
        System.out.println("请输入六边形的边长:");
        Scanner input = new Scanner(System.in);
        s = input.nextDouble();
        double area = (6*s*s)/(4*Math.tan(Math.PI/6));
        System.out.printf("这个六边形的面积是:%.2f",area);
    }
}
class Exercise4_5 {
    public static void main(String[] args) {
          int n;
          double r;
          Scanner input = new Scanner(System.in);
          System.out.println("请输入多边形的边数:");
          n = input.nextInt();
          System.out.println("请输入多边形的边长:");
          r = input.nextDouble();
          double s = (6*r*r)/(4*Math.tan(Math.PI/n));
          System.out.printf("这个多边形的面积是:%.2f",s;
    }
}
class Exercise4_6 {
    public static void main(String[] args) {
        
    }
}