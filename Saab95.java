import java.awt.*;

public class Saab95 extends PassengerCar{

    private boolean turboOn;

    public Saab95(){
        super(Color.red, "Saab95", 1710, 125, 2);
        this.turboOn = false;
    }

    // section for getters:

    // section for setter:

    // section for functional methods:

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    // section for overridden methods:
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        double speedFactor = getEnginePower() * 0.01 * turbo;
        return speedFactor;
    }
}
