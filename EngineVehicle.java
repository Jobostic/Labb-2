import java.awt.*;

public abstract class EngineVehicle extends Vehicle{

    private double enginePower;

    // constructor
    public EngineVehicle(Color color, String modelName, double weight, double enginePower){
        super(color, modelName, weight);
        this.enginePower = enginePower;
        stopEngine();
    }

    // section for getters:

    public double getEnginePower(){
        return enginePower;
    }

    // section for setters:

    private void setEnginePower(double enginePower){
        this.enginePower = enginePower;
    }
    // section for functional methods:

    public double speedFactor(){
        double speedFactor = getEnginePower() * 0.01;
        return speedFactor;
    }

    public void startEngine(){
        setCurrentSpeed(0.1);
    }

    public void stopEngine(){
        setCurrentSpeed(0);
    }

    public void gas(double amount){
        nrIsPositive(amount, "Amount must be positive!");
        vehicleIsMoving("The vehicle is turned of!");
        nrIsInInterval(amount, 0, 1,"Amount must be in interval [0,1]");
        incrementSpeed(amount);
    }

    // section for overridden methods:

    @Override
    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

}
