package P3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    private Car blackCar;

    @Before
    public void createCar(){
        blackCar = new Car(100, 2);
    }

    @Test
    public void testAllMilesAreDriven(){
        boolean carTurnedOnAndDrived = blackCar.turnOnAndDrive(25);
        boolean carBrokedDown = blackCar.isBrokenDown();
        assertEquals(!carBrokedDown, carTurnedOnAndDrived);
    }

    @Test
    public void testOnlySomeMilesAreDriven(){
        assertFalse(blackCar.turnOnAndDrive(100));
    }

    @Test
    public void testNumberOfMiles(){
        assertEquals(100,blackCar.getMileage(),0.01);
    }

    @Test
    public void testNumberOfGallons(){
        blackCar.fillGas(5);
        assertEquals(7,blackCar.getGasGallons(),0.01);
    }

    @Test
    public void testRepairCar(){
        blackCar.repair();
        assertFalse(blackCar.isBrokenDown());
    }

}