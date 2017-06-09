package builtInObserver;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer {
    private double oldTemp;
    private double oldHumid;

    public void update(Observable o, Object arg) {
        double temp = ((WeatherData) o).getTemperature();
        double humid = ((WeatherData) o).getHumidity();
        String notification;
        if (oldTemp == 0 && oldHumid == 0) notification = "Improving weather on the way!";
        else if (temp > oldTemp) {
            if (humid > 80) notification = "It is hotter, rainy weather!";
            else notification = "It is hotter, sunny day";
        }
        else {
            if (humid > 80) notification = "Watch out for cooler, rainy weather!";
            else notification = "Watch out for cooler, sunny day";
        }
        oldTemp = temp;
        oldHumid = humid;
        System.out.println("Forecast: " + notification);
    }
}
