import java.awt.*;

/**
 * Abstract class that represents a truck
 */
public class Truck extends Vehicle{
    /**
     * The angle of the trailer
     */
    private double trailerAngle;

    /**
     * Constructor that calls the superclass Car and sets trailerAngle to 0
     * @param nrDoors number of doors
     * @param color color
     * @param enginePower Horsepower
     * @param modelName Model name
     */
    public Truck(int nrDoors, Color color, int enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);
        this.trailerAngle = 0;
    }

    /**
     * Getter for the trailers angle
     * @return
     */
    public double getTrailerAngle(){
        return trailerAngle;
    }

    /**
     * The speed factor of truck. Assumptions are made that a truck doesn't have a turbo or something else to increase the speed factor.
     * @return The speed factor
     */
    @Override
    public double speedFactor(){
        double speedFactor = getEnginePower() * 0.01;
        return speedFactor;
    }

    /**
     * Setter for trailer angle
     * @param angle the chosen angle
     */
    private void setTrailerAngle(double angle){
        trailerAngle = angle;
    }

    /**
     * Method that lifts the trailer by chosen amount.
     * The truck must be standing still, the chosen angle must be positive and the total angle cannot exceed 70 degrees
     * @param angle How much you would like to lift the trailer.
     */
    public void liftTrailer(double angle) {
        if(getCurrentSpeed() == 0) {
            if (angle >= 0) {
                if (getTrailerAngle() + angle <= 70) {
                    trailerAngle = getTrailerAngle() + angle;
                } else {
                    throw new IllegalArgumentException("The angle cannot exceed 70 degrees");
                }
            } else {
                throw new IllegalArgumentException("The angle must be positive");
            }
        }
        else{
            throw new IllegalArgumentException("Stop the truck!");
        }
    }

    /**
     * Method that lowers the trailer by chosen amount.
     * The truck must be standing still, the chosen angle must be positive and the total angle cannot be below 0 degrees
     * @param angle How much you would like to lower the trailer.
     */
    public void lowerTrailer(double angle) {
        if (getCurrentSpeed() == 0) {
            if (angle >= 0) {
                if (getTrailerAngle() - angle >= 0) {
                    trailerAngle = getTrailerAngle() - angle;
                } else {
                    throw new IllegalArgumentException("The final angle must be in the interval [0,70]");
                }
            } else {
                throw new IllegalArgumentException("The angle must be positive!");
            }
        }
        else {
            throw new IllegalArgumentException("Stop the truck!");
        }
    }
}
