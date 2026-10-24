import java.util.Random;
class Dice {
    private int sides;
    private int value;
    private static final Random r=new Random();
    public Dice(int sides){
        this.sides=sides;
    }
    public int roll(){
        if(this.sides<3){
            throw new IllegalArgumentException("invalid sides!!!");
        }
        value=r.nextInt(1,this.sides+1);
        return value;
    }
    public int getSides(){
        return this.sides;
    }
    public int getValue(){
        return this.value;
    }
    public String toString(){
        return "sides=="+this.sides+",value=="+value;
    }
}
class Player{
    private String name;
    private Dice[] dice;
    private int total=0;
    public Player(String name,int count, int sides){
        if(count<=0){
            throw new IllegalArgumentException("count not valid!!");
        }
        this.dice=new Dice[count];
        this.name=name;
        for(int i=0;i<this.dice.length;i++){
            this.dice[i]=new Dice(sides);
        }
    }
    public void roll(){
        for(int i=0;i<this.dice.length;i++){
            int value=this.dice[i].roll();
            total+=value;
        }
    }
    public int retTotal(){
        return this.total;
    }
    public void rollAgain(int index){
        this.total-=this.dice[index].getValue();
        int newValue=this.dice[index].roll();
        this.total+=newValue;
    }
    public String toString(){
        return "dice 1=="+this.dice[0].getValue()+",dice 2=="+this.dice[1].getValue()+",total=="+this.total+",name=="+this.name;
    }
}
public class DicePlayerDemo
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Player p=new Player("dani",2,6);
		p.roll();
		System.out.println(p);
		p.rollAgain(1);
		System.out.println(p);
	}
}
