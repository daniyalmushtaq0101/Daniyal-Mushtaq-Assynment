public class Calculator {
    // Public field
    public double result;

    // Constructor
    public Calculator() {
        this.result = 0.0;
    }

    // Getter
    public double getResult() {
        return result;
    }

    // Behavior methods
    public double add(double a, double b) {
        result = a + b;
        return result;
    }

    public double subtract(double a, double b) {
        result = a - b;
        return result;
    }

    public double multiply(double a, double b) {
        result = a * b;
        return result;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero");
            return 0;
        }
        result = a / b;
        return result;
    }

    public void displayResult(String operation) {
        System.out.println(operation + " = " + result);
    }

    // Main method
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        double sum = calc.add(15, 5);
        calc.displayResult("15 + 5");

        double diff = calc.subtract(15, 5);
        calc.displayResult("15 - 5");

        double product = calc.multiply(15, 5);
        calc.displayResult("15 * 5");

        double quotient = calc.divide(15, 5);
        calc.displayResult("15 / 5");

        // Divide by zero example
        calc.divide(10, 0);
    }
}
