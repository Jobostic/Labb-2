import java.awt.*;

public class Object {

    private double weight;
    private double posX; // Every Cars position in x-direction
    private double posY; // Every Cars position in y-direction
    private int direction; // Every Cars direction
    private double currentSpeed;
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    public Object(double weight){
        this.weight = weight;
        this.posX = 0;
        this.posY = 0;
        this.direction = NORTH;
        this.currentSpeed = 0;
    }

    // section for getters:

    public double getWeight(){
        return weight;
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

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    // section for setters:

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public void setX(double posX){
        this.posX = posX;
    }

    public void setY(double posY){
        this.posY = posY;
    }

    public void setCurrentSpeed(double amount){
        this.currentSpeed = amount;
    }

    // section for supporting methods:

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

    // section for functional methods:

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
}
