import java.util.Random;
import java.util.Objects;
import java.util.Arrays;
class Point {
    private int x;
    private int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Point(Point obj){
        this.x=obj.x;
        this.y=obj.y;
    }
    public int getx(){
        return this.x;
    }
    public int gety(){
        return this.y;
    }
    public void setx(int x){
        this.x=x;
    }
    public void sety(int y){
        this.y=y;
    }
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Point)){
            return false;
        }
        Point other=(Point) obj;
        return this.x==other.x&&this.y==other.y;
    }
    public int hashCode(){
        return Objects.hash(this.x,this.y);
    }
    public String toString(){
        return "x=="+this.x+" ,y=="+this.y;
    }
}
class PointArray implements Cloneable{
    private Point[] points;
    public PointArray(Point[] points){
        this.points=points;
    }
    public Point getPoint(int  n){
        return this.points[n];
    }
    //clone shallow
    public PointArray clone() throws CloneNotSupportedException {
        return (PointArray) super.clone();
    }
    //deep copy
    public PointArray deepcopy() throws CloneNotSupportedException{
        Point[] dc=new Point[this.points.length];
        for(int i=0;i<dc.length;i++){
           dc[i]=new Point(this.points[i]); 
        }
        return new PointArray(dc);
    }
    public String toString(){
        return Arrays.toString(points);
    }
}
public class PointArrayDemo
{
	public static void main(String[] args) throws CloneNotSupportedException{
		System.out.println("Hello World");
		Random r=new Random();
		Point[] data =new Point[100];
		for(int i=0;i<data.length;i++){
		    int x=r.nextInt(1,101);
		    int y=r.nextInt(1,101);
		    data[i]=new Point(x,y);}
		    PointArray original=new PointArray(data);
		    PointArray shallow=original.clone();
		    PointArray deep=original.deepcopy();
		    shallow.getPoint(0).setx(999);
		    deep.getPoint(1).sety(125);
		    System.out.println("shollow=="+shallow.getPoint(0).getx());
		    System.out.println("deep copy=="+deep.getPoint(1).gety());
		    Point p=new Point(4,4);
		    Point q=new Point(4,4);
		    p.equals(q);
		    System.out.println("original=="+original);
		    System.out.println("shallow=="+shallow);
		    System.out.println("deep=="+deep);
		
	}
}
