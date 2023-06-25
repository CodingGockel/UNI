package Excercise9;

import java.util.*;
class WSchlange{
    protected List<Object> stack;
    public WSchlange(){
        this.stack = new ArrayList<Object>();
    }
    public void add(Object o){
        this.stack.add(o);
    }
    public void remove(){
        if(this.stack != null) {
            this.stack.remove(0);
        }
    }
}

class Schlange<T>{
    protected List<T> stack;
    public Schlange(){
        this.stack = new ArrayList<>();
    }
    public void add(T o){
        this.stack.add(o);
    }
    public void remove(){
        if(this.stack != null) {
            this.stack.remove(0);
        }
    }
}
public class A1 {
    public static void main(String[] args){
        Schlange<String> stringSchlange = new Schlange<>();
        Schlange<Integer> integerSchlange = new Schlange<>();
        WSchlange wSchlange = new WSchlange();
        stringSchlange.add("Hallo");
        stringSchlange.add("Test");
        integerSchlange.add(4);
        integerSchlange.add(100);
        wSchlange.add("hallo");
        wSchlange.add(2);
    }
}
