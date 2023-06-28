package Excercise7;

import java.awt.geom.Arc2D;

class Node{
    Object data;
    Node next;

    Node (Object data, Node next){
        this.data = data;
        this.next = next;
    }
}
interface ActionObject{
    public void action(Node n);
}
class ContainsZero implements ActionObject{
    boolean containsZero = false;
    @Override
    public void action(Node n) {
        Node active = n;
        while(active != null) {
            if(active.data instanceof Integer){
                if((int)active.data == 0){
                    this.containsZero = true;
                }
            }
            active = active.next;
        }
    }
}

class SumPositiveInteger implements ActionObject{
    int sum = 0;
    @Override
    public void action(Node n) {
        Node active = n;
        while(active != null) {
            if(active.data instanceof Integer){
                if((int)active.data > 0){
                    this.sum += (int) active.data;
                }
            }
            active = active.next;
        }
    }
}

class SquareOfNumber implements ActionObject{
    @Override
    public void action(Node n) {
        Node active = n;
        while(active != null) {
            if(active.data instanceof Number){
                if(active.data instanceof Integer){
                    active.data = (int)active.data * (int) active.data;
                } else if (active.data instanceof Float) {
                    active.data = (float)active.data * (float) active.data;
                } else if (active.data instanceof Double) {
                    active.data = (double)active.data * (double) active.data;
                }
            }
            active = active.next;
        }
    }
}



class List{
    Node head;
    List(Node head){
        this.head = head;
    }

    void print(){
        for(Node cursor = head; cursor != null; cursor = cursor.next){
            System.out.print(cursor.data.toString() + ",");
        }
        System.out.println();
    }
}

public class A2 {
    public static void showContainsZero(List list) {
        ContainsZero a = new ContainsZero();
        a.action(list.head);
    }
    public static void showPosSum(List list) {
        SumPositiveInteger a = new SumPositiveInteger();
        a.action(list.head);
    }
    public static void square(List list) {
        SquareOfNumber a = new SquareOfNumber();
        a.action(list.head);
    }
    public static void main(String args[]){
        Node node = new Node(1, new Node(4.0, new Node(3.0f, new Node(4, new Node(5.0,null)))));
        List l = new List(node);
        l.print();
        showContainsZero(l);
        l.print();
        showPosSum(l);
        l.print();
        square(l);
        l.print();

    }
}