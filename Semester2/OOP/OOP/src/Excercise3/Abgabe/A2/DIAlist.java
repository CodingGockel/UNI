import java.util.Arrays;
public class DIAlist extends DynIntArray
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
