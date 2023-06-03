public class Test
{
    public static void main(String args[]){
        A a = new A(); B b = new B(); C c = new C();
        Print1 p1 = new Print1();
        Print2 p2 = new Print2();
        p1 = p2;
        System.out.println(p1.x); // Aufruf 1
        p1.print(c); // Aufruf 2
        ((Print2)p1).print(c); // Aufruf 3
        ((Print1)p2).print(b); // Aufruf 4
        ((Print1)p2).print(c); // Aufruf 5
        p2.print(c); // Aufruf 6
        p1 = new Print1();
        //((Print2)p1).print(a); // Aufruf 7
    }
}
class A{
    
}
class B extends A{
    
}
class C extends B{
    
}
class Print1 {
    int x = 1;
    public void print(A a) { System.out.println(x); }
    public void print(B b) { System.out.println(x+1); }
}
class Print2 extends Print1 {
    int x = 3;
    public void print(A a) { System.out.println(x); }
    public void print(B b) { System.out.println(x+1); }
    public void print(C c) { System.out.println(x+2); }
}