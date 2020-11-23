import java.awt.*;
import java.util.ArrayList;

public class Loader<C extends Object> extends Object{

    private ArrayList<C> storage;
    private int storageCapacity;
    private int nrContainedObjects;
    public static final int fromFront = 0;
    public static final int fromRight = 1;
    public static final int fromBehind = 2;
    public static final int fromLeft = 3;

    public Loader(int storageCapacity,double weight){
        super(weight);
        storage = new ArrayList<C>(storageCapacity);
        this.storageCapacity = storageCapacity;
        this.nrContainedObjects = 0;
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

    public int getIndexOfStorage(Object o){
        return storage.indexOf(o);
    }

    // section for setters:

    public void setStorageCapacity(int capacity){
        storageCapacity = capacity;
    }

    // section for supporting methods:

    public void checkIfFull(ArrayList<C> storage){
        if(storage.size() < getStorageCapacity()){
            return;
        }
        else{
            throw new IllegalArgumentException("Storage is full!");
        }
    }

    public void checkWeight(C object, double allowedWeight){
        if(object.getWeight() <= allowedWeight){
            return;
        }
        else{
            throw new IllegalArgumentException("Too heavy!");
        }
    }

    public void checkIfCloseEnough(Object c, double xAway, double yAway){
        if(Math.abs(c.getX() - getX()) <= xAway && Math.abs(c.getY() - getY()) <= yAway){
            return;
        }
        else{
            throw new IllegalArgumentException("Move closer!");
        }
    }

    // section for functional methods:

    public void loadObject(C object) {
        checkWeight(object, 2000);
        checkIfCloseEnough(object,1,1);
        checkIfFull(getStorage());
        getStorage().add(object);
        object.setX(getX());
        object.setY(getY());
    }

    public void unloadObject(C object, int inDirection){
        if(storage.contains(object)){
            if(inDirection == fromFront){
                unloadFromFront(getIndexOfStorage(object));
            }
            else if(inDirection == fromRight){
                unloadFromRight(getIndexOfStorage(object));
            }
            else if(inDirection == fromBehind){
                unloadFromBehind(getIndexOfStorage(object));
            }
            else if(inDirection == fromLeft){
                unloadFromLeft(getIndexOfStorage(object));
            }
            else{
                throw new IllegalArgumentException("Choose direction for unloading!");
            }
        //unloadInDirection(getIndexOfStorage(object));
        }
        else{
            throw new IllegalArgumentException("This is not inside this storage!");
        }
    }

    public void unloadFromBehind(int i){
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

    public void unloadFromFront(int i){
        if(getDirection() == NORTH) {
            storage.get(i).setY(getY() + 1);
        }
        else if(getDirection() == EAST){
            storage.get(i).setX(getX() + 1);
        }
        else if(getDirection() == SOUTH){
            storage.get(i).setY(getY() - 1);
        }
        else if(getDirection() == WEST){
            storage.get(i).setX(getX() - 1);
        }
        storage.remove(i);
    }

    public void unloadFromRight(int i){
        if(getDirection() == NORTH) {
            storage.get(i).setX(getX() + 1);
        }
        else if(getDirection() == EAST){
            storage.get(i).setY(getY() - 1);
        }
        else if(getDirection() == SOUTH){
            storage.get(i).setX(getX() - 1);
        }
        else if(getDirection() == WEST){
            storage.get(i).setY(getY() + 1);
        }
        storage.remove(i);
    }

    public void unloadFromLeft(int i){
        if(getDirection() == NORTH) {
            storage.get(i).setX(getX() - 1);
        }
        else if(getDirection() == EAST){
            storage.get(i).setY(getY() + 1);
        }
        else if(getDirection() == SOUTH){
            storage.get(i).setX(getX() + 1);
        }
        else if(getDirection() == WEST){
            storage.get(i).setY(getY() - 1);
        }
        storage.remove(i);
    }

    public void unloadAllObjects(int inDirection){
        int size = storage.size();
        for(int i = size; i > 0; i--){
            //unloadInDirection(i-1);
            if(inDirection == fromFront){
                unloadFromFront(i-1);
            }
            else if(inDirection == fromRight){
                unloadFromRight(i-1);
            }
            else if(inDirection == fromBehind){
                unloadFromBehind(i-1);
            }
            else if(inDirection == fromLeft){
                unloadFromLeft(i-1);
            }
            else{
                throw new IllegalArgumentException("Choose direction for unloading!");
            }
        }
    }

    // section for overridden methods:

    public void moveWithCurrentSpeed(double currentSpeed){
        setCurrentSpeed(currentSpeed);
        super.move();
        for(int i = 0; i < getStorage().size(); i++){
            getStorage().get(i).setX(getX());
            getStorage().get(i).setY(getY());
        }
    }
}
