package P2;

public class ParkingLot{

    private boolean[] parkingSpots = new boolean[101];

    public ParkingLot(){
        for(int i = 1; i<=100; i++){
            parkingSpots[i] = true;
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(vehicle.isParked())throw new IllegalArgumentException("This vehicle is already parked!!");

        int parkingSpot = getParkingPlaceAvailable(vehicle);
        if(parkingSpot == -1){
            return false;
        }
        if(vehicle instanceof Bus){
            for(int i=parkingSpot; i<=parkingSpot+4; i++){
                parkingSpots[i] = false;
            }
        }
        else{
            parkingSpots[parkingSpot] = false;
        }
        vehicle.setParked(true);
        vehicle.setParkingSlotNumber(parkingSpot);
        return true;
    }


    private int getParkingPlaceAvailable(Vehicle vehicle) {
        if(vehicle instanceof Car){
            return getParkingSpotForCar();
        }
        else {
            return getParkingSpotForBus();
        }
    }


    private int getParkingSpotForCar(){
        int spot = 1;
        while (spot <= 100){
            if(parkingSpots[spot]) return spot;
            spot++;
        }
        return -1;
    }

    private int getParkingSpotForBus(){
        int spot;
        for(int i = 1; i<=91; i = i+10){
            spot = getParkingSpotIfAnyAvailableBetween(i, i+9);
            if(spot != -1) return spot;
        }
        return -1;
    }

    private int getParkingSpotIfAnyAvailableBetween(int startSpot, int endSpot){
        int beginSpot = -1, consecutiveEmptySpots = 0;

        while(startSpot<=endSpot){
            if(parkingSpots[startSpot]){
                consecutiveEmptySpots++;
                if(consecutiveEmptySpots == 5){
                    beginSpot = startSpot - 4;
                    break;
                }
            }
            else{
                consecutiveEmptySpots = 0;
            }
            startSpot++;
        }
        return beginSpot;
    }
}
