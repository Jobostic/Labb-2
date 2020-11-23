import java.awt.*;

public abstract class Vehicle extends Object implements Movable{

    private Color color; // Color of the car
    private String modelName; // The car model name

    public Vehicle(Color color, String modelName, double weight){
        super(weight);
        this.color = color;
        this.modelName = modelName;
    }

    // Section for getters:

    /*public double getCurrentSpeed(){
        return currentSpeed;
    }*/

    public String getName(){
        return modelName;
    }

    public Color getColor(){
        return color;
    }

    // section for setters:

 /*   public void setCurrentSpeed(double amount){
        this.currentSpeed = amount;
    }*/

    private void setName(String modelName) {
        this.modelName = modelName;
    }

    private void setColor(Color color) {
        this.color = color;
    }

    // Section for abstract methods:

    public abstract double speedFactor();

    //Section for supporting methods:

    public void vehicleIsStationary(String error){
        if (getCurrentSpeed() == 0){
            return;
        }
        else{
            throw new IllegalArgumentException("The vehicle is moving!");
        }
    }

    public void vehicleIsMoving(String error){
        if(getCurrentSpeed() > 0) {
            return;
        }
        else{
            throw new IllegalArgumentException(error);
        }
    }

    // Section for functional methods:

    // Will get limitations to engine power in those classes that have engines
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    public void brake(double amount){
        nrIsPositive(amount, "Amount must be positive");
        vehicleIsMoving("The vehicle is already standing still!");
        nrIsInInterval(amount,0,1,"Amount is outside interval [0,1]");
        decrementSpeed(amount);
    }

    public void move(){
        if(getDirection() == NORTH){
            setY(getY() + getCurrentSpeed());
        }
        else if(getDirection() == EAST){
            setX(getX() + getCurrentSpeed());
        }
        else if(getDirection() == SOUTH){
            setY(getY() - getCurrentSpeed());
        }
        else if(getDirection() == WEST){
            setX(getX() - getCurrentSpeed());
        }
    }

    public void turnLeft(){
        if(getDirection() == NORTH){
            setDirection(WEST);
        }
        else if(getDirection() == EAST){
            setDirection(NORTH);
        }
        else if(getDirection() == SOUTH){
            setDirection(EAST);
        }
        else if(getDirection() == WEST){
            setDirection(SOUTH);
        }
    }

    public void turnRight(){
        if(getDirection() == NORTH){
            setDirection(EAST);
        }
        else if(getDirection() == EAST){
            setDirection(SOUTH);
        }
        else if(getDirection() == SOUTH){
            setDirection(WEST);
        }
        else if(getDirection() == WEST){
            setDirection(NORTH);
        }
    }

}
