import java.awt.*;
import java.util.ArrayList;

public class Transporter {


    private int storageCapacity;
    private int nrContainedObjects;

    // section for getters:

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

    // section for supporting methods:

    public void checkIfFull(ArrayList<ScentedCandles> storage){
        if(storage.size() < getStorageCapacity()){
            return;
        }
        else{
            throw new IllegalArgumentException("Storage is full!");
        }
    }

}
