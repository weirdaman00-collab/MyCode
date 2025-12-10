abstract class shape{
    int a,b;
    abstract void area();
}

class Rectangle extends shape{
    void area(){
        a=8;
        b=99;
        int area = a*b;
        System.out.println("Area of Rectangle: "+area);
    }
}
class Circle extends shape{
    void area(){
        a=5;
        double area = 3.14*a*a;
        System.out.println("Area of Circle: "+ area);
    }
}
class Triangle extends shape{
    void area(){
        a=6;
        b =8;
        double area = 0.5*a*b;
        System.out.println("Area of Triangle: "+area);
    }
}
public class jjjjjjj{
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        rec.area();
        Circle cir = new Circle();
        cir.area();
        Triangle tri = new Triangle();
        tri.area();
    }
}
