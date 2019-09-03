package P2;

public class Vehicle {
    private boolean isParked;
    private String color;
    private int parkingSlotNumber;

    public Vehicle(String color){
        this.color = color;
        this.isParked = false;
        this.parkingSlotNumber = -1;
    }

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean parked) {
        isParked = parked;
    }

    public int getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public void setParkingSlotNumber(int parkingSlotNumber) {
        this.parkingSlotNumber = parkingSlotNumber;
    }
}
