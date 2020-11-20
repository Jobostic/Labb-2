import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Truck{

    private final double rampDown = 35;
    private final double rampUp = 0;
    private ArrayList<PassengerCar> storage;
    private int storageCapacity;
    private int nrContainedObjects;
    private boolean rampDwn;


    public CarTransport(int storageCapacity){
        super(Color.blue, "Transporter", 4000, 750, 2);
        this.storageCapacity = storageCapacity;
        this.storage = new ArrayList<PassengerCar>(storageCapacity);
        this.nrContainedObjects = storage.size();
    }

    // section for getters:

    public ArrayList<PassengerCar> getStorage(){
        return storage;
    }

    public int getStorageCapacity(){
        return storageCapacity;
    }

    public int getNrContainedObjects(){
        return storage.size();
    }

    // section for setters:
    public void setStorageCapacity(int capacity){
        storageCapacity = capacity;
    }

    // section for supporting methods:

    public void checkIfFull(ArrayList<PassengerCar> storage){
        if(storage.size() < getStorageCapacity()){
            return;
        }
        else{
            throw new IllegalArgumentException("Storage is full!");
        }
    }

    public void checkWeight(PassengerCar car, double allowedWeight){
        if(car.getWeight() <= allowedWeight){
            return;
        }
        else{
            throw new IllegalArgumentException("Too heavy!");
        }
    }

    public void checkIfCloseEnough(PassengerCar c, double xAway, double yAway){
        if(Math.abs(c.getX() - getX()) <= xAway && Math.abs(c.getY() - getY()) <= yAway){
            return;
        }
        else{
            throw new IllegalArgumentException("Move closer!");
        }
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
        checkWeight(car, 2000);
        checkIfRampDown();
        checkIfCloseEnough(car,1,1);
        checkIfFull(getStorage());
        getStorage().add(car);
        car.setX(getX());
        car.setY(getY());
    }

    private void unloadInDirection(int i){
        if(getDirection() == NORTH) {
            storage.get(i).setY(getY() - 1);
        }
        else if(getDirection() == EAST){
            storage.get(i).setX(getX() - 1);
        }
        else if(getDirection() == SOUTH){
            storage.get(i).setY(getY() + 1);
        }
        else if(getDirection() == WEST){
            storage.get(i).setX(getX() + 1);
        }
        storage.remove(i);
    }

    public void unloadCar(PassengerCar c){
        checkIfRampDown();
        int size = storage.size();
        int position = storage.indexOf(c);
        ArrayList<PassengerCar> otherCars = new ArrayList<PassengerCar>();
        for(int i = size; i > position+1; i--){
            otherCars.add(storage.get(i-1));
            storage.remove(i-1);
        }
        unloadInDirection(position);
        for(int i = otherCars.size(); i > 0; i--){
            storage.add(otherCars.get(i-1));
        }
    }

    public void unloadAllCars(){
        checkIfRampDown();
        int size = storage.size();
        for(int i = size; i > 0; i--){
            unloadInDirection(i-1);
        }
    }

    @Override
    public void move(){
        isAngleZero();
        super.move();
        for(int i = 0; i < storage.size(); i++){
            storage.get(i).setX(getX());
            storage.get(i).setY(getY());
        }
    }

}
