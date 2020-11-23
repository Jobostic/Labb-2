import java.util.ArrayList;

public class Garage<C extends PassengerCar> extends Object{

/*    private ArrayList<C> storage;
    private int storageCapacity;
    private int nrContainedObjects;*/
    private Loader<C> loader;

    public Garage(int storageCapacity, double weight){
        super(weight);
/*        this.storageCapacity = storageCapacity;
        this.storage = new ArrayList<C>(storageCapacity);
        this.nrContainedObjects = storage.size();*/
        this.loader = new Loader<C>(storageCapacity, weight);
    }

    // section for getters:

    public ArrayList<C> getStorage(){
        return loader.getStorage();
        // return storage;
    }

    public int getStorageCapacity(){
        return loader.getStorageCapacity();
       // return storageCapacity;
    }

    public int getNrContainedObjects(){
        return loader.getNrContainedObjects();
        // return storage.size();
    }

    // section for setters:

    public void setStorageCapacity(int capacity){
        loader.setStorageCapacity(capacity);
        //storageCapacity = capacity;
    }

    // section for supporting functions:

    public void checkIfFull(ArrayList<C> storage){
        loader.checkIfFull(storage);
/*        if(storage.size() < getStorageCapacity()){
            return;
        }
        else{
            throw new IllegalArgumentException("Storage is full!");
        }*/
    }

    // section for functional methods:

    public void loadCar(C car){
        loader.loadObject(car);
/*        checkIfFull(getStorage());
        getStorage().add(car);*/
    }

    public void unloadCar(C car, int inDirection){
        loader.unloadObject(car, inDirection);
/*        if(storage.contains(car)){
            storage.remove(car);
        }*/
    }

    //public void pickUpCar()


}
