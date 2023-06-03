package Excercise7;

interface PrintEqual{
    abstract boolean isEqual(PrintEqual o);
    abstract void print();
}

class IFloat implements PrintEqual{

    @Override
    public boolean isEqual(PrintEqual o) {
        if(o == this){return true;};
        return false;
    }

    @Override
    public void print() {
        System.out.print(this);
    }
}

class IName implements PrintEqual{
    @Override
    public boolean isEqual(PrintEqual o) {
        if(o == this){return true;};
        return false;
    }

    @Override
    public void print() {
        System.out.print(this);
    }
}

public class A1 {
    static void printEqual4Array(PrintEqual[] a, PrintEqual o){
        for(PrintEqual e: a){
            if(e.isEqual(o)){
                e.print();
            }
        }
    }
}
