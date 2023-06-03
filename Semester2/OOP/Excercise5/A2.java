package org.example;

import java.util.*;

interface StringMenge{
    public void add(String s);
    public void removeString(String s);
    public boolean contains(String s);
    public boolean isEmpty();
    public int getSize();
    public String[] getElements();
    public int getCharCount();
    public void print();
}

abstract class AbstrakteStringMenge implements StringMenge{
    public LinkedList<String> strings;

    public AbstrakteStringMenge(){
        this.strings = null;
    }
    @Override
    public void add(String s){
        if(this.strings == null) {
            this.strings = new LinkedList<String>();
        }
        this.strings.add(s);
    }
    @Override
    public void removeString(String s){
        this.strings.remove(s);
    }
    @Override
    public boolean contains(String s){
        if(this.strings != null){
            if(this.strings.contains(s)){
                return true;
            }
        }
        return false;
    }
    @Override
    public int getSize(){
        if(this.strings != null){
            return this.strings.size();
        }
        return 0;
    }
    @Override
    public String[] getElements(){
        String[] ret = new String[this.strings.size()];
        if(this.strings != null){
            for(int i = 0; i < this.strings.size(); i++){
                ret[i] = this.strings.get(i);
            }
        }
        return ret;
    }
    @Override
    abstract public boolean isEmpty();
    @Override
    abstract public int getCharCount();
    @Override
    abstract public void print();
}

class StringMengeImpl extends AbstrakteStringMenge{

    @Override
    public boolean isEmpty(){
        if(this.strings == null){
            return true;
        }
        return false;
    }
    @Override
    public int getCharCount(){
        int ret = 0;
        if(this.strings != null){
            for(int i = 0; i < this.strings.size(); i++){
                ret += this.strings.get(i).length();
            }
        }
        return ret;
    }
    @Override
    public void print(){
        if(this.strings != null){
            for(String s:this.strings){
                System.out.println(s);
            }
        }
    }
}

public class A2{
    public static void main(String args[]) {
        Random rand = new Random();
        StringMenge sm = new StringMengeImpl();
        while (sm.getSize() < 5) {
            String r = "Eingabe"+String.valueOf(rand.nextInt(5));
            boolean c = sm.contains(r);
            sm.add(r);
            System.out.printf("Element %3s ist %15s, Mengen-Groeße ist %2d, " +
                    "mit: ", r, ((c ? "" : "nicht ") + "vorhanden"), sm.getSize());
            sm.print();
            System.out.print(" Zeichenanzahl= "+sm.getCharCount());
            System.out.println();
        }
    }
}
