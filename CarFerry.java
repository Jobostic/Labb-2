import java.awt.*;
import java.util.ArrayList;

public class CarFerry<C extends PassengerCar> extends EngineVehicle{

    private Loader<PassengerCar> loader;
    private boolean anchored;

    public CarFerry(int storageCapacity){
        super(Color.blue, "Obilia", 10000, 1500);
        this.loader = new Loader<PassengerCar>(storageCapacity,10000);
        this.anchored = true;
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

    public void checkIfAnchored(){
        if(anchored == true){
            return;
        }
        else{
            throw new IllegalArgumentException("The boat isn't anchored!");
        }
    }

    // section for functional methods:

    public void anchor(){
        if(getCurrentSpeed() == 0) {
            this.anchored = true;
        }
        else{
            throw new IllegalArgumentException("Stop the boat before anchoring!");
        }
    }

    public void takeOff(){
        this.anchored = false;
    }

    public void loadCar(PassengerCar c){
        checkIfAnchored();
        loader.loadObject(c);
    }

    public void unloadAllCars(){
        checkIfAnchored();
        loader.unloadAllObjects(Loader.fromFront);
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
}
