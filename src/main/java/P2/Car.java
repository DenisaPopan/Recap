package P2;

public class Car extends Vehicle {

    private String licensePlate;

    public Car(String color, String licensePlate) {
        super(color);
        this.licensePlate = licensePlate;
    }
}
