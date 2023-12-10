package lab3.locations;

import lab3.exceptions.CustomCheckedException;

public interface LightSource {
    void turnOn() throws CustomCheckedException;
    void turnOff();
}

