import java.awt.*;

import static org.junit.Assert.assertEquals;

public class main {

    public static void main(String[] args){
        Car v = new Volvo240();
        Car s = new Saab95();
        Car vo = new Volvo240();
        Car sa = new Saab95();
        Car saa = new Saab95();
        Car vol = new Volvo240();
        CarTransporter ct = new CarTransporter();
        ct.loadCar(v);
        ct.loadCar(s);
        ct.loadCar(vo);
        ct.loadCar(sa);
        ct.loadCar(saa);
        ct.loadCar(vol);
        ct.unloadCar(vo);
        System.out.println(ct.storage.indexOf(saa));
        System.out.print(ct.getListofCarsLoaded().toString());
    }
}
