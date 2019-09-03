package P2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParkingLotTest {
    private static Car firstCar;
    private static Vehicle secondCar;
    private static Bus firstBus;
    private static Bus secondBus;
    private static ParkingLot parkingLot;
@BeforeClass
    public static void createVehicles(){
    firstCar = new Car("red","CJ123BLA");
    secondCar = new Car("black","CJ456BLA");
    firstBus = new Bus("purple","37");
    secondBus = new Bus("white","32B");
    parkingLot = new ParkingLot();
}

@Test
    public void parkBus(){
    Assert.assertTrue(parkingLot.parkVehicle(firstBus));
    System.out.println("First bus: " + firstBus.getParkingSlotNumber());
}

@Test(expected = IllegalArgumentException.class)
public void parkBusAlreadyParked(){
    Assert.assertTrue(parkingLot.parkVehicle(secondBus));
    System.out.println("Second bus: " + secondBus.getParkingSlotNumber());
    parkingLot.parkVehicle(secondBus);
}

@Test
    public void parkCars(){
    Assert.assertTrue(parkingLot.parkVehicle(firstCar));
    Assert.assertTrue(parkingLot.parkVehicle(secondCar));

    System.out.println("First car: " + firstCar.getParkingSlotNumber());
    System.out.println("Second car: " + secondCar.getParkingSlotNumber());
}

@Test
    public void parkBusNoSpaceLeft(){
    ParkingLot secondParkingLot = new ParkingLot();
    for(int i = 0; i< 20; i++){
        Bus bus = new Bus("blue", "gfsiuks");
        secondParkingLot.parkVehicle(bus);
    }
    Bus busThatHasNoSpace = new Bus("yellow","iHaveNoSpaceLeftInTheParkingSpot");
    Assert.assertEquals(secondParkingLot.parkVehicle(busThatHasNoSpace), false);
}

}
