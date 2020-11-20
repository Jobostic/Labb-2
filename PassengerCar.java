import java.awt.*;

public abstract class PassengerCar extends EngineVehicle{

    private int nrDoors;

    public PassengerCar(Color color, String modelName, double weight, double enginePower, int nrDoors){
        super(color, modelName, weight, enginePower);
        this.nrDoors = nrDoors;
    }

    // section for getters:
    public int getNrDoors(){
        return nrDoors;
    }

    // section for setters:
    public void setNrDoors(int nrDoors){
        this.nrDoors = nrDoors;
    }

    // section for functional methods:

}
