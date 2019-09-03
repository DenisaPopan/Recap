package P3;

public class CarTester {

    public double testCar(){
        Car whiteCar = new Car(0, 10);
        double milesToDrive = 10;
        while(true){
            if(whiteCar.turnOnAndDrive(milesToDrive)){
                milesToDrive += 10;
            }
            else if(!whiteCar.isBrokenDown()){
                whiteCar.fillGas(10);
            }
            else {
                return whiteCar.getMileage();
            }
        }
    }
}
