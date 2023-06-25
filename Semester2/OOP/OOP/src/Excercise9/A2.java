package Excercise9;

 class Node<T> {
     public T value;
     public Node<T> left, right;
 }
public class A2 {
    public static <T> void printOrder(Node<T> n){
        if(n != null){
            printOrder(n.left);
            System.out.println(n.value);
            printOrder(n.right);
        }
    }
    public static <T extends Comparable> Node<T> printMax(Node<T> n1, Node<T> n2){
        if(n1 != null && n2 != null && !(n1.value.compareTo(n2.value) == 0)){
            if(n1.value.compareTo(n2.value) > 0){
                return n1;
            }
            return n2;
        }
        return null;
    }
    public static <T extends Number> double getSumOver(double over, Node<T> n){
        if(n != null && (n.value.doubleValue() > over)){
            return n.value.doubleValue() + getSumOver(over, n.left) + getSumOver(over,n.right);
        }
        return 0.f;
    }
}
