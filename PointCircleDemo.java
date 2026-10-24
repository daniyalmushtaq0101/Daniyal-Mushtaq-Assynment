import java.util.Arrays;
class Point{
    private int x;
    private int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Point (Point obj){
        this.x=obj.x;
        this.y=obj.y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
            
        }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String toString(){
        return "x=="+this.x+"  ,y=="+this.y;    }
}
class Circle implements Cloneable{
    private String label;
    private Point[] points;
    public Circle(String label,Point[] source){
        this.label=label;
        this.points=source;
    }
    public Point getPoint(int index){
        return this.points[index];
    }
    public Circle clone() throws CloneNotSupportedException{
        return (Circle) super.clone();
    }
    public Circle deepCopy() throws CloneNotSupportedException{
        Circle copy=(Circle) super.clone();
        copy.label=this.label;
        copy.points=new Point[this.points.length];
        for(int i=0;i<copy.points.length;i++){
            copy.points[i]=new Point(this.points[i]);
        }
        return copy;
    }
    public String toString(){
        return "label=="+this.label+"points=="+Arrays.toString(points);
    }
}    
public class PointCircleDemo
{
	public static void main(String[] args)throws CloneNotSupportedException {
		System.out.println("Hello World");
		Point[] source={new Point(1,2),new Point(3,4),new Point(5,6)};
		Circle currentcircle=new Circle("c1",source);
		Circle shallow=currentcircle.clone();
		Circle deep=currentcircle.deepCopy();
		System.out.println(currentcircle);
		shallow.getPoint(0).setX(99);
		deep.getPoint(1).setY(88);
		System.out.println(shallow);
		System.out.println(deep);
		System.out.println(currentcircle);
	}
}
