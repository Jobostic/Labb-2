import java.awt.*;

public class Volvo240 extends PassengerCar{
    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(Color.black, "Volvo240", 1400, 100, 4);
    }

    // section for getters:

    // section for setters:

    // section for functional methods:

    // section for overridden methods:

    public double speedFactor(){
        double speedFactor = getEnginePower() * 0.01 * trimFactor;
        return speedFactor;
    }

}
