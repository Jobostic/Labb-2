import java.util.ArrayList;
import java.util.ArrayList.*;

public class Garage<C extends PassengerCar>{

    private ArrayList<C> storage;
    private int storageCapacity;
    private int nrContainedObjects;

    public Garage(int storageCapacity){
        this.storageCapacity = storageCapacity;
        this.storage = new ArrayList<C>(storageCapacity);
        this.nrContainedObjects = storage.size();
    }

    // section for getters:
    public ArrayList<C> getStorage(){
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

    // section for supporting functions:

    public void checkIfFull(ArrayList<C> storage){
        if(storage.size() < getStorageCapacity()){
            return;
        }
        else{
            throw new IllegalArgumentException("Storage is full!");
        }
    }

    // section for functional methods:

    public void loadCar(C car){
        checkIfFull(getStorage());
        getStorage().add(car);
    }

    public void unloadCar(C car){
        if(storage.contains(car)){
            storage.remove(car);
        }
    }

    //public void pickUpCar()


}
