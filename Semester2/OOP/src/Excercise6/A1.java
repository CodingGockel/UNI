package Excercise6;
interface ResizeableGO{
    public void resize(float x);
}

interface MoveableGO{
    public void move(float x, float y);
}

interface GraphObj extends ResizeableGO, MoveableGO{
    public void setColor(int x);
    public void show();
    public void hide();
}

class Rectangle implements GraphObj{
    int color, size;
    float x,y;
    boolean isVisible;

    public Rectangle(int color, int size, float x, float y, boolean isVisible){
        this.color = color;
        this.size = size;
        this.x = x;
        this.y = y;
        this.isVisible = isVisible;
    }
    @Override
    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void resize(float x) {
        this.size *= x;
    }

    @Override
    public void setColor(int x) {
        this.color = color;
    }

    @Override
    public void show() {
        this.isVisible = true;
    }

    @Override
    public void hide() {
        this.isVisible = false;
    }

    public void status(){
        System.out.println("Koordinaten: " + x + "/" + y + "\t\t\t" + "Color: " + this.color + "\t\t\t" + "Size: " + this.size + "\t\t\t" + "Visible: " + this.isVisible);
    }
}

public class A1{

    public static void resizeAll(float r, ResizeableGO rgo[]) {
        for (ResizeableGO g : rgo){
            g.resize(r);
        }
    }

    public static void moveAll(float dx, float dy, MoveableGO mgo[]) {
        for (MoveableGO m : mgo){
            m.move(dx, dy);
        }
    }

    public static void getStatusAll(Rectangle rects[]) {
        for (Rectangle r : rects){
            r.status();
        }
    }

    public static void main(String args[]){
        Rectangle rects[] = {new Rectangle(255,5,3,4,true),new Rectangle(200,10,8,-5,true),new Rectangle(123,1,1,1,false),new Rectangle(1,8,111,-50,true)};
        System.out.println("Before: ");
        getStatusAll(rects);
        moveAll(4.0f,3.0f,rects);
        resizeAll(3,rects);
        System.out.println("After: ");
        getStatusAll(rects);
    }
}