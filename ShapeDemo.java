abstract class Shape {
    int a, b;
    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }
    void printArea() {
        System.out.println("Rectangle Area: " + (a * b));
    }
}

class Triangle extends Shape {
    Triangle(int a, int b) {
        this.a = a;
        this.b = b;
    }
    void printArea() {
        System.out.println("Triangle Area: " + (0.5 * a * b));
    }
}

class Circle extends Shape {
    Circle(int r) {
        this.a = r; 
    }
    void printArea() {
        System.out.println("Circle Area: " + (3.14 * a * a));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape s;

        s = new Rectangle(10, 20);
        s.printArea();

        s = new Triangle(10, 15);
        s.printArea();

        s = new Circle(7);
        s.printArea();
    }
}
