import java.awt.*;
import java.util.ArrayList;

public class Scania extends Truck{

    private ArrayList<ScentedCandles> storage;
    private int storageCapacity;
    private int nrContainedObjects;

    public Scania(int storageCapacity){
        super(Color.orange, "Streamline", 4000, 730,2);
        this.storageCapacity = storageCapacity;
        this.storage = new ArrayList<ScentedCandles>(storageCapacity);
        this.nrContainedObjects = storage.size();
    }

    // section for getters:

    public ArrayList<ScentedCandles> getStorage(){
        return storage;
    }

    public int getStorageCapacity(){
        return storageCapacity;
    }

    public int getNrContainedObjects(){
        return nrContainedObjects;
    }

    // section for setters:
    public void setStorageCapacity(int capacity){
        storageCapacity = capacity;
    }

    // section for supporting methods

    public void checkIfFull(ArrayList<ScentedCandles> storage){
        if(storage.size() < getStorageCapacity()){
            return;
        }
        else{
            throw new IllegalArgumentException("Storage is full!");
        }
    }

    // section for functional methods:

    public void loadObject(ScentedCandles frankeeCandle) {
        checkIfFull(getStorage());
        getStorage().add(frankeeCandle);
    }

    public void unloadObject(ScentedCandles frankeeCandle){
        if(storage.contains(frankeeCandle)){
            storage.remove(frankeeCandle);
        }
    }

    public void emptyStorage() {
        if(storage.size() != 0){
            storage.clear();
        }
    }

}
