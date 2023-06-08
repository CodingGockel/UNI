package Excercise3;
import java.util.Arrays;
class DIAarray extends DynIntArray
{
    int[] listArray;
    public DIAarray(){
        this.listArray = new int[0];
    }
    public void add(int e) {
        if(this.listArray.length == 0){
            int[] newArray = new int[1];
            newArray[0] = e;
            this.listArray = newArray;
        }else{
            int[] newArray = new int[this.listArray.length +1];
            for(int i = 0; i < this.listArray.length; i++){
                newArray[i] = this.listArray[i];
            }
            newArray[this.listArray.length] = e;
            this.listArray = newArray;
        }
    }
    public void setElementAt(int i, int e) {
        if(i < this.listArray.length){
            if(this.listArray.length == 0){
                this.listArray = new int[1];
            }
            this.listArray[i] = e;
        }
    }
    public int getElementAt(int i) {
        if(i < this.listArray.length){
            return this.listArray[i];
        }
        return 0;
    }
    public int getElementCount() {
        return this.listArray.length;
    }
    public void print() {
        System.out.println(Arrays.toString(this.listArray));
    }
}
class DynIntArray
{
    void add(int e) {

    }
    void setElementAt(int i, int e) {

    }
    int getElementAt(int i) {
        return 0;
    }
    int getElementCount() {
        return 0;
    }
    void print() {

    }
    public static void main(String args[]) {
        for (int i = 0; i < 2; i++) {
            DynIntArray da = null;
            if (i == 0) { da = new DIAarray(); }
            else if (i == 1) { da = new DIAlist(); }
            da.add(4); da.add(8); da.add(10); da.add(1); da.print();
            da.setElementAt(0, 0); da.add(5);
            da.setElementAt(2, da.getElementAt(2) + 10); da.print();
            System.out.println("DIA: elements=" + da.getElementCount() +
                    " da[4]=" + da.getElementAt(4) +
                    " da[9]=" + da.getElementAt(9));
        }
    }
}
class DIAlist extends DynIntArray
{
    ListElement firstElement;
    public DIAlist(){
        this.firstElement = null;
    }
    public DIAlist(int e){
        this.firstElement = new ListElement(e);
    }
    public void add(int e){
        if(this.firstElement == null){
            this.firstElement = new ListElement(e);
        }else{
            ListElement lastElement = this.getLast();
            lastElement.setNextElement(new ListElement(e));
        }
    }
    public void setElementAt(int i, int e){
        if(this.firstElement == null && i == 0){
            this.firstElement = new ListElement(e);
        }
        else if(!(i > this.getElementCount() -1)){
            ListElement le = this.firstElement;
            for(int j = 0; j <= i; j++){
                if(j == i){
                    le.setValue(e);
                    break;
                }
                le = le.getNextElement();
            }
        }
    }
    public int getElementAt(int i){
        if(this.firstElement == null){
            return 0;
        }
        if(!(i > this.getElementCount()-1)){
            ListElement le = this.firstElement;
            for(int j = 0; j <= i; j++){
                if(j == i){
                    return le.getValue();
                }
                le = le.getNextElement();
            }
        }
        return 0;
    }
    public void print(){
        int[] printArray = new int[getElementCount()];
        ListElement le = this.firstElement;
        int i = 0;
        while(le.getNextElement() != null){
            printArray[i] = le.getValue();
            le = le.getNextElement();
            i++;
        }
        printArray[i] = le.getValue();
        System.out.println(Arrays.toString(printArray));
    }
    public int getElementCount(){
        if(this.firstElement == null){
            return 0;
        }
        int count = 1;
        ListElement le = this.firstElement;
        while(le.getNextElement() != null){
            le = le.getNextElement();
            count++;
        }
        return count;
    }
    public ListElement getLast(){
        ListElement le = this.firstElement;
        while(le.getNextElement() != null){
            le = le.getNextElement();
        }
        return le;
    }
}
class ListElement{
    int value;
    ListElement nextElement;

    public ListElement(int val){
        this.value = val;
        this.nextElement = null;
    }

    public void setNextElement(ListElement nextElement){
        this.nextElement = nextElement;
    }

    public int getValue(){
        return this.value;
    }

    public ListElement getNextElement(){
        return this.nextElement;
    }

    public void setValue(int v){
        this.value = v;
    }
}
