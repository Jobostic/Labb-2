import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Truck{

    private final double rampDown = 35;
    private final double rampUp = 0;
    private boolean rampDwn;
    private Loader<PassengerCar> loader;


    public CarTransport(int storageCapacity){
        super(Color.blue, "Transporter", 4000, 750, 2);
        this.loader = new Loader<PassengerCar>(storageCapacity,4000);
    }

    // section for getters:

    public ArrayList<PassengerCar> getStorage(){
        return loader.getStorage();
    }

    public int getStorageCapacity(){
       return loader.getStorageCapacity();
    }

    public int getNrContainedObjects(){
        return loader.getNrContainedObjects();
    }

    public Loader<PassengerCar> getLoader(){
        return loader;
    }

    // section for setters:

    public void setStorageCapacity(int capacity){
       loader.setStorageCapacity(capacity);
    }

    // section for supporting methods:

    public void checkIfFull(ArrayList<PassengerCar> storage){
        loader.checkIfFull(storage);
    }

    public void checkWeight(PassengerCar car, double allowedWeight){
        loader.checkWeight(car, allowedWeight);
    }

    public void checkIfCloseEnough(PassengerCar c, double xAway, double yAway){
        loader.checkIfCloseEnough(c, xAway, yAway);
    }

    public void checkIfRampDown(){
        if(getTrailerAngle() == 35){
            return;
        }
        else throw new IllegalArgumentException("Lower the ramp!");
    }

    public boolean isRampDwn(){
        if(getTrailerAngle() == 35){
            return true;
        }
        else{
            return false;
        }
    }

    // section for functional methods:

    public void liftRamp(){
        setTrailerAngle(0);
    }

    public void lowerRamp(){
        setTrailerAngle(35);
    }


    public void loadCar(PassengerCar car) {
        checkIfRampDown();
        loader.loadObject(car);
    }

    private void unloadInDirection(int i){
        loader.unloadFromBehind(i);
    }

    public void unloadCar(PassengerCar c){
        loader.setDirection(getDirection());
        checkIfRampDown();
        int size = loader.getNrContainedObjects();
        int position = loader.getIndexOfStorage(c);
        ArrayList<PassengerCar> otherCars = new ArrayList<PassengerCar>();
        for(int i = size; i > position+1; i--){
            otherCars.add(loader.getStorage().get(i-1));
            loader.getStorage().remove(i-1);
        }
        loader.unloadFromBehind(position);
        for(int i = otherCars.size(); i > 0; i--){
            loader.getStorage().add(otherCars.get(i-1));
        }
    }

    public void unloadAllCars(){
        checkIfRampDown();
        loader.unloadAllObjects(Loader.fromBehind);
    }

    // section for overridden methods:

    @Override
    public void move(){
        loader.setX(getX());
        loader.setY(getY());
        loader.setDirection(getDirection());
        super.move();
        loader.moveWithCurrentSpeed(getCurrentSpeed());
    }

    @Override
    public void setTrailerAngle(double angle){
        if(angle == 35){
            super.setTrailerAngle(35);
        }
        else if(angle == 0){
            super.setTrailerAngle(0);
        }
        else{
            throw new IllegalArgumentException("The ramp can only have two modes, either up or down!");
        }
    }

}
