public class Car {
    public String brand;
    public String model;
    public int year;
    public double speed;
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = 0.0;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public double getSpeed() {
        return speed;
    }
    public void accelerate(double amount) {
        if (amount > 0) {
            speed += amount;
            System.out.println(brand + " " + model + " accelerated to " + speed + " km/h");
        }
    }
    public void brake(double amount) {
        speed -= amount;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println(brand + " " + model + " slowed down to " + speed + " km/h");
    }
    public void displayInfo() {
        System.out.println("Car: " + year + " " + brand + " " + model);
        System.out.println("Current Speed: " + speed + " km/h");
    }
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2022);
        Car car2 = new Car("Honda", "Civic", 2023);
        car1.displayInfo();
        car1.accelerate(40);
        car1.accelerate(20);
        car1.brake(15);
        car1.displayInfo();
        System.out.println();
        car2.displayInfo();
        car2.accelerate(60);
        car2.brake(70);
        car2.displayInfo();
    }
}
