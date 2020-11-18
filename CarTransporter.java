import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class CarTransporter extends Vehicle{

    private Truck t;
    private boolean rampDown;
    public LinkedList<Car> storage = new LinkedList<>();

    public CarTransporter() {
        super(2, Color.blue, 730, "Transporter");
        this.rampDown = false;
    }

    public double speedFactor(){
        return t.speedFactor();
    }

    public int getNrOfCarsLoaded(){
        return storage.size();
    }

    public LinkedList<Car> getListofCarsLoaded(){
        return storage;
    }

    public void liftRamp(){
        if(getCurrentSpeed() == 0){
            rampDown = false;
        }
        else{
            throw new IllegalArgumentException("Stop the transporter!");
        }
    }

    public void lowerRamp(){
        if(getCurrentSpeed() == 0){
            rampDown = true;
        }
        else{
            throw new IllegalArgumentException("Stop the transporter!");
        }
    }

    public void loadCar(Car c){
        if(rampDown == false){
            if(Math.abs(c.getX() - getX()) <= 1 && Math.abs(c.getY() - getY()) <=1) {
                storage.add(c);
                c.setX(getX());
                c.setY(getY());
            }
            else{
                throw new IllegalArgumentException("Move closer!");
            }
        }
        else{
            throw new IllegalArgumentException("Lift the ramp!");
        }
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

    public void unloadCar(Car c){
        if(rampDown == false){
            int size = storage.size();
            int position = storage.indexOf(c);
            LinkedList<Car> otherCars = new LinkedList<Car>();
            for(int i = size; i > position+1; i--){
                otherCars.add(storage.get(i-1));
                storage.remove(i-1);
            }
            unloadInDirection(position);
            for(int i = otherCars.size(); i > 0; i--){
                storage.add(otherCars.get(i-1));
            }
        }
        else{
            throw new IllegalArgumentException("Lift the ramp!");
        }
    }

    public void unloadAllCars(){
        if(rampDown == false){
            int size = storage.size();
            for(int i = size; i > 0; i--){
                unloadInDirection(i-1);
            }
        }
        else{
            throw new IllegalArgumentException("Lift the ramp");
        }
    }

    @Override
    public void move(){
        if(rampDown == false){
            super.move();
            for(int i = 0; i < storage.size(); i++){
                storage.get(i).setX(getX());
                storage.get(i).setY(getY());
            }
        }
        else{
            throw new IllegalArgumentException("Lift the ramp");
        }
    }




}
