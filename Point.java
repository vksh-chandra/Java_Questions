import java.util.*;
class P{
    double x;
    double y;
    P(double x, double y){
        this.x =x;
        this.y =y;
    }
}

public class Point {

    public static void display(P p1, P p2){

        double radius = Math.sqrt((p2.x -p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y));
        System.out.println(radius);
    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        double x1 = src.nextDouble();
        double y1 = src.nextDouble();
        P point1 = new P(x1, y1);
        double x2 = src.nextDouble();
        double y2 = src.nextDouble();
        P point2 = new P(x2, y2);

        display(point1, point2);
        src.close();
    }
}
