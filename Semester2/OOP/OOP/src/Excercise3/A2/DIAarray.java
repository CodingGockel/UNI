import java.util.Arrays;
public class DIAarray extends DynIntArray
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
