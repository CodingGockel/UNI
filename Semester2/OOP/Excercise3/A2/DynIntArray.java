public class DynIntArray
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
