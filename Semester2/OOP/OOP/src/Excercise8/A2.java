package Excercise8;
import java.util.*;
class Relation <T>{
    private LinkedList<T> menge;
    private HashMap<int[],T[]> relation;
    public Relation(){
        menge = new LinkedList<T>();
        relation = new HashMap<int[],T[]>();
    }
    public int longestElementInMenge(){
        int max = 0;
        for(T e:this.menge){
            if(e.toString().length() > max){
                max=e.toString().length();
            }
        }
        return max;
    }
    public String fixedLengthString(String string) {
        int length = (this.longestElementInMenge()*2)+4;
        return String.format("%"+length+"s", string).replace(" "," ");
    }
    public boolean addElementToSet(T i){
        if(this.menge != null){
            for(T e:this.menge){
                if((e.getClass() == i.getClass()) && (e==i)){
                   return false;
                }
            }
            this.menge.add(i);
            return true;
        }
        return false;
    }
    public boolean addElementToRelation(T[] r){
        if(this.relation != null){
            if(r.length ==2){
                int i1 = 0;
                int i2 = 0;
                for(int i = 0; i < this.menge.size(); i++){
                    if(this.menge.get(i) == r[0]){
                        i1 = i+1;
                    }
                    if(this.menge.get(i) == r[1]){
                        i2 = i+1;
                    }
                }
                if(i1 != 0 && i2 != 0){
                    int[] test = {i1,i2};
                    for(int[] key:this.relation.keySet()) {
                        if (key[0]==test[0] && key[1]==test[1]) {
                            return false;
                        }
                    }
                    this.relation.put(test, r);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
    public boolean isReflexiv(){
        int count = 0;
        for(int i = 0; i < menge.size();i++){
            for(int[] key:this.relation.keySet()) {
                if (key[0]==i+1 && key[1]==i+1) {
                    count ++;
                }
            }
        }
        if(count == this.menge.size()){
            return true;
        }
        return false;
    }
    public boolean isSymetrisch(){
        int count = 0;
        for(int[] key1:this.relation.keySet()) {
            if(key1[0] != key1[1]){
                for(int[] key2:this.relation.keySet()) {
                    if (!(key1[0] == key2[0] && key1[1] == key2[1])) {
                        if (key1[0] == key2[1] && key1[1] == key2[0]) {
                            count++;
                        }
                    }
                }
            }else{
                count++;
            }
        }
        if(this.relation.size() == count){
            return true;
        }
        return false;
    }
    public boolean contains(int[] pair){
        for(int[] key:this.relation.keySet()){
           if((pair[0] == key[0]) && (pair[1] == key[1])){
               return true;
           }
        }
        return false;
    }
    public T[] getValueByKey(int[] pair){
        for(Map.Entry<int[], T[]> entry : this.relation.entrySet()) {
            int[] key = entry.getKey();
            T[] value = entry.getValue();
            if((pair[0] == key[0]) && (pair[1] == key[1])){
                return value;
            }
        }
        return null;
    }
    public boolean isTransitiv(){
        for(int[] key1:this.relation.keySet()) {
            if(key1[0] != key1[1]) {
                for (int[] key2 : this.relation.keySet()) {
                    if(key2[0] != key2[1]){
                        if(key1[1] == key2[0]){
                            if(!this.contains(new int[]{key1[0],key2[1]})){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isÄquivalenzRelation(){
        if(this.isReflexiv() && this.isSymetrisch() && this.isTransitiv()){
            return true;
        }
        return false;
    }
    public void print(){
        for(int i = 1; i <= this.menge.size(); i++){
            for(int j = 1; j <= this.menge.size(); j++){
                if(this.contains(new int[]{i,j})){
                    if(j==this.menge.size()){
                        System.out.print(fixedLengthString("("+this.getValueByKey(new int[]{i,j})[0]+","+this.getValueByKey(new int[]{i,j})[1]+")"));
                    }else{
                        System.out.print(fixedLengthString("("+this.getValueByKey(new int[]{i,j})[0]+","+this.getValueByKey(new int[]{i,j})[1]+")|"));
                    }
                }else{
                    if(j==this.menge.size()){
                        System.out.print(fixedLengthString("()"));
                    }else{
                        System.out.print(fixedLengthString("()|"));
                    }
                }
            }
            System.out.print("\n");
        }
    }
}
public class A2 {
    public static void main(String args[]){
        Relation<String> r = new Relation<>();
        r.addElementToSet("A");
        r.addElementToSet("B");
        r.addElementToSet("C");
        r.addElementToSet("D");
        r.addElementToRelation(new String[]{"A","B"});
        r.addElementToRelation(new String[]{"B","C"});
        r.addElementToRelation(new String[]{"A","C"});
        r.addElementToRelation(new String[]{"C","C"});
        r.addElementToRelation(new String[]{"A","A"});
        r.addElementToRelation(new String[]{"B","B"});
        r.addElementToRelation(new String[]{"A","D"});
        r.addElementToRelation(new String[]{"B","D"});
        r.addElementToRelation(new String[]{"C","D"});
        r.print();
        System.out.println("Relation ist Reflexiv: "+r.isReflexiv());
        System.out.println("Relation is Symetrisch: "+r.isSymetrisch());
        System.out.println("Relation ist Transitiv: "+r.isTransitiv());
        System.out.println("ist äquivalent Relation: "+r.isÄquivalenzRelation());
    }
}




