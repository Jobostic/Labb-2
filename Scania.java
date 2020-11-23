import java.awt.*;
import java.util.ArrayList;

public class Scania<O extends Object> extends Truck{

    private Loader<O> loader;

    public Scania(int storageCapacity){
        super(Color.orange, "Streamline", 4000, 730,2);
        this.loader = new Loader<O>(storageCapacity, 4000);
    }

    // section for getters:

    public ArrayList<O> getStorage(){
        return loader.getStorage();
    }

    public int getStorageCapacity(){
        return loader.getStorageCapacity();
    }

    public int getNrContainedObjects(){
        return loader.getNrContainedObjects();
    }

    // section for setters:
    public void setStorageCapacity(int capacity){
        loader.setStorageCapacity(capacity);
    }

    // section for supporting methods

    public void checkIfFull(ArrayList<O> storage){
        loader.checkIfFull(storage);
    }

    // section for functional methods:
    public void loadObject(O object) {
        loader.loadObject(object);
    }

    public void unloadObject(O object){
        loader.unloadObject(object, Loader.fromBehind);
    }

    public void unloadAllObjects() {
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
}
