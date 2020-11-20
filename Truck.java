import java.awt.*;
import java.util.ArrayList;

public abstract class Truck extends EngineVehicle{

    private double trailerAngle;
    private double nrDoors;

    public Truck(Color color, String modelName, double weight, double enginePower, int nrDoors){
        super(color, modelName, weight, enginePower);
        this.nrDoors = nrDoors;
        this.trailerAngle = 0;
    }

    // section for getters:

    public double getTrailerAngle(){
        return trailerAngle;
    }


    // section for setters:

    public void setTrailerAngle(double angle){
        trailerAngle = angle;
    }

    // section for abstract methods:


    // section for supporting methods:

    public void withinAngleLimit(double angle){
        nrIsInInterval(angle,0,70,"Angle is outside the limits!");
    }

    public void isAngleZero(){
        if(getTrailerAngle() == 0){
            return;
        }
        else{
            throw new IllegalArgumentException("The trailer angle is not zero!");
        }
    }

    // section for functional methods:

    public void liftTrailer(double angle){
        vehicleIsStationary("Stop the truck!");
        nrIsPositive(angle,"Angle must be positive!");
        withinAngleLimit(getTrailerAngle() + angle);
        setTrailerAngle(getTrailerAngle() + angle);
    }

    public void lowerTrailer(double angle){
        vehicleIsStationary("Stop the truck!");
        nrIsPositive(angle,"Angle must be positive!");
        withinAngleLimit(getTrailerAngle() - angle);
        setTrailerAngle(getTrailerAngle() - angle);
    }

    // section for overridden methods:

   @Override
    public void move(){
        isAngleZero();
        super.move();
    }

}
