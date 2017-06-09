import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    private List<Observer> listObservers = new ArrayList<Observer>();
    private double temperature;
    private double humidity;
    private double pressure;

    public void setMeasurements(double t, double h, double p) {
        temperature = t;
        humidity = h;
        pressure = p;
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        listObservers.add(observer);
    }

    public void removeObserver(Observer observer) {
        listObservers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer: listObservers) {
            observer.update();
        }
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
