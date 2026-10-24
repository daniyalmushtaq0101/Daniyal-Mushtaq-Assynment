import java.util.Objects;
import java.util.Arrays;
class Driver{
    private String name;
    private int id;
    public Driver(String name,int id){
        this.name=name;
        this.id=id;
    }
    public Driver(Driver obj){
        this.name =obj.name;
        this.id=obj.id;
    }
    public String toString(){
        return "name=="+this.name+" ,id=="+this.id;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setid(int id){
        this.id=id;
    }
    public String getname(){
        return this.name;
    }
    public int getid(){
        return this.id;
    }
}
class Car implements Cloneable{
    private String model;
    private Driver driver;
    private int[] speedHistory=new int[2];
    //speedHistory=new int[2];
    public Car(String model,String drivername,int driverid){
        this.model=model;
        this.driver=new Driver(drivername,driverid);
    }
    public void drive(){
        System.out.println("Driving!!");
        // speedHistory=new int[2];
        speedHistory[0]=0;
    }
    public void drive(int speed){
        speedHistory[1]=speed;
    }
    public void setspeed(int index,int speed){
        speedHistory[index]=speed;
    }
    public int getspeed(int index){
        return speedHistory[index];
    }
    public Car clone()throws CloneNotSupportedException{
        return (Car) super.clone();
    }
    public Car deepCopy()throws CloneNotSupportedException{
        Car copy=(Car) super.clone();
        copy.speedHistory = this.speedHistory.clone();
        copy.driver = new Driver(this.driver); // Using copy constructor
        return copy;
    }
    public String toString(){
        return "speed"+Arrays.toString(speedHistory)+" ,Model"+this.model+",Driver=="+this.driver.getname()+",Diver id =="+this.driver.getid();
    }
}
public class DiceDemo
{
	public static void main(String[] args) throws CloneNotSupportedException{
		System.out.println("Hello World");
		Car c1=new Car("Civic","Sara",101);
		c1.drive();
		c1.drive(159);
		Car c2=c1.clone();
		Car c3=c1.deepCopy();
		c2.setspeed(1,90);
		c3.setspeed(1,120);
		System.out.println("shalow copy=="+c2.getspeed(1));
		System.out.println("deep copy=="+c3.getspeed(1));
		System.out.println(c2);
		System.out.println(c3);
	}
}
