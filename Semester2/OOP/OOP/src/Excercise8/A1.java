package Excercise8;

interface TreeNodeActionObject<T extends Number> {
    void action(Node<T> n);
}
class Node<T extends Number> {
    public Node<T> left, right;
    public T data;
    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class Tree<T extends Number> {
    private Node<T> root;
    public Tree(T data){
        this.root = new Node<>(data);
    }
    public Node<T> getRoot(){
        return this.root;
    }
    public Node<T> addNode(Node<T> r, T data){
        if(r == null){
            return new Node<T>(data);
        } else if (!r.data.equals(data)) {
            if(r.data.byteValue() < data.byteValue()){
                r.left = addNode(r.left,data);
            }else{
                r.right = addNode(r.right,data);
            }
        }
        return r;
    }
    public void traverseAndApply(TreeNodeActionObject<T> ao) {
        traverseAndApply(root, ao);
    }
    private void traverseAndApply(Node<T> n, TreeNodeActionObject<T> ao) {
        if (n == null) {
            return;
        }
        traverseAndApply(n.left, ao);
        ao.action(n);
        traverseAndApply(n.right, ao);
    }
}
class SumAction<T extends Number> implements TreeNodeActionObject{
    private T sum;
    public SumAction(){
        this.sum = (T) Integer.valueOf(0);
    }
    public T getSum(){
        return this.sum;
    }
    @Override
    public void action(Node n) {
        if(this.sum.getClass() == Integer.class){
            Integer h = Integer.valueOf(this.sum.intValue() + n.data.intValue());
            this.sum = (T) h;
        }
        if(this.sum.getClass() == Double.class){
            Double h = Double.valueOf(this.sum.doubleValue() + n.data.doubleValue());
            this.sum = (T) h;
        }
        if(this.sum.getClass() == Float.class){
            Float h = Float.valueOf(this.sum.floatValue() + n.data.floatValue());
            this.sum = (T) h;
        }
        if(this.sum.getClass() == Long.class){
            Long h = Long.valueOf(this.sum.longValue() + n.data.longValue());
            this.sum = (T) h;
        }

    }
}
public class A1 {
    public static void main(String[] args){
        Tree<Integer> tree = new Tree<>(0);
        for (int i = 1; i < 20; i++) {
            tree.addNode(tree.getRoot(), Integer.valueOf(i));
        }
        SumAction<Integer> sumAction = new SumAction<>();
        tree.traverseAndApply(sumAction);
        System.out.println(sumAction.getSum());
    }
}
