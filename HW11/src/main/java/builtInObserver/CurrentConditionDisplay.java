package builtInObserver;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer {
    public void update(Observable o, Object arg) {
        double temperature = ((WeatherData) o).getTemperature();
        double humidity = ((WeatherData) o).getHumidity();
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
