import java.awt.*;

public abstract class Vehicle implements Movable{

    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double weight;
    private double posX; // Every Cars position in x-direction
    private double posY; // Every Cars position in y-direction
    private int direction; // Every Cars direction
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    public Vehicle(Color color, String modelName, double weight){
        this.color = color;
        this.modelName = modelName;
        this.weight = weight;
        this.direction = NORTH;
        this.posX = 0;
        this.posY = 0;
        this.currentSpeed = 0;
    }

    // Section for getters:

    public double getWeight(){
        return weight;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public String getName(){
        return modelName;
    }

    public Color getColor(){
        return color;
    }

    public int getDirection(){
        return direction;
    }

    public double getX(){
        return posX;
    }

    public double getY(){
        return posY;
    }

    // Section for setters:

    private void setWeight(double weight){
        this.weight = weight;
    }

    public void setCurrentSpeed(double amount){
        this.currentSpeed = amount;
    }

    private void setName(String modelName) {
        this.modelName = modelName;
    }

    private void setColor(Color color) {
        this.color = color;
    }

    private void setDirection(int direction){
        this.direction = direction;
    }

    public void setX(double posX){
        this.posX = posX;
    }

    public void setY(double posY){
        this.posY = posY;
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

    public void nrIsInInterval(double nr,double lowerBound, double upperBound, String error){
        if(nr >= lowerBound && nr <= upperBound){
            return;
        }
        else{
            throw new IllegalArgumentException(error);
        }
    }

    public void nrIsPositive(double nr,String error){
        if(nr >= 0){
            return;
        }
        else{
            throw new IllegalArgumentException(error);
        }
    }

    // Section for functional methods:

    // Will get limitations to engine power in those classes that have engines
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void brake(double amount){
        nrIsPositive(amount, "Amount must be positive");
        vehicleIsMoving("The vehicle is already standing still!");
        nrIsInInterval(amount,0,1,"Amount is outside interval [0,1]");
        decrementSpeed(amount);
    }

    public void move(){
        if(getDirection() == NORTH){
            posY = posY + getCurrentSpeed();
        }
        else if(getDirection() == EAST){
            posX = posX + getCurrentSpeed();
        }
        else if(getDirection() == SOUTH){
            posY = posY - getCurrentSpeed();
        }
        else if(getDirection() == WEST){
            posX = posX - getCurrentSpeed();
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
