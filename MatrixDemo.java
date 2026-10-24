import java.util.Arrays;
class Matrix implements Cloneable{
    private int rows;
    private int coloums;
    private int[] data;
    public Matrix(int rows,int coloums,int[] source){
        this.rows=rows;
        this.coloums=coloums;
        this.data=source;
    }
    public int get(int r,int c){
        return this.data[r*coloums+c];
    }
    public void set(int row,int colm,int value){
        this.data[row*coloums+colm]=value;
    }
    public Matrix clone() throws CloneNotSupportedException{
        return (Matrix) super.clone();
    }
    public Matrix deepCopy() throws CloneNotSupportedException{
        Matrix copy= (Matrix) super.clone();
        copy.data= Arrays.copyOf(this.data,this.data.length);
        return copy;
    }
    // public String toString(){
    //     return Arrays.toString(data);
    // }(
    public String toString(){
        String st="";
        for(int i=0;i<rows;i++){
            for(int j=0;j<coloums;j++){
                st+=data[i*coloums+j]+" ";
            }
            st+="\n";
        }
        return st;
    }
}
public class MatrixDemo {
    public static void main(String[] args) throws CloneNotSupportedException {

        int[] values = {
            1, 2, 3,
            4, 5, 6
        };

        Matrix original = new Matrix(2, 3, values);

        System.out.println("Original Matrix:");
        System.out.println(original);

        // Shallow copy
        Matrix shallow = original.clone();

        // Deep copy
        Matrix deep = original.deepCopy();

        System.out.println("\nShallow Copy:");
        System.out.println(shallow);

        System.out.println("\nDeep Copy:");
        System.out.println(deep);

        // Change original
        original.set(0, 0, 100);

        System.out.println("\nAfter changing original:");

        System.out.println("Original: " + original);
        System.out.println("Shallow:  " + shallow);
        System.out.println("Deep:     " + deep);
    }
}
