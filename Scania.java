import java.awt.*;

/**
 * Class that creates a Scania truck
 */
public class Scania extends Truck{
    /**
     * Constructor
     */
    public Scania(){
        super(2, Color.orange, 730, "Streamline");
    }

    /**
     * Method overridden from vehicle to make it impossible to move if trailer is up.
     */
    @Override
    public void move() {
        if (super.getTrailerAngle() == 0) {
            super.move();
        }
        else {
            throw new IllegalArgumentException("Lower the trailer to 0!");
        }
    }
}
