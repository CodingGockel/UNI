package Excercise9;

import java.util.ArrayList;
import java.util.List;
abstract class Shape {
    public abstract void draw();
}
class Circle extends Shape {
    private int x, y, radius;
    public void draw() {
        System.out.println("Circle");
    }
}
class Rectangle extends Shape {
    private int x, y, width, height;
    public void draw() {
        System.out.println("Rectangle");
    }
}
public class A3 {
    public static void main(String args[]){
        List<Rectangle> list1 = new ArrayList<Rectangle>();
        list1.add(new Rectangle());
        list1.add(new Rectangle());
        drawAll(list1);
        List<Circle> list2 = new ArrayList<Circle>();
        list2.add(new Circle());
        list2.add(new Circle());
        drawAll(list2);
        List<Object> list3 = new ArrayList<>();
        addNumbers(list3);
        List<Number> list4 = new ArrayList<>();
        addNumbers(list4);
        List<Integer> list5 = new ArrayList<>();
        addNumbers(list5);
    }
    public static void drawAll(List<? extends Shape> shapes) {
        for (Shape s: shapes) {
            s.draw();
        }
    }
    public static void addNumbers(List<? super  Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}
