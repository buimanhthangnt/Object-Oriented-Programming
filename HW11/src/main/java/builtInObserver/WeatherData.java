package builtInObserver;

import java.util.Observable;

public class WeatherData extends Observable {
    private double temperature;
    private double humidity;
    private double pressure;

    public void setMeasurements(double t, double h, double p) {
        temperature = t;
        humidity = h;
        pressure = p;
        setChanged();
        notifyObservers();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }
}
