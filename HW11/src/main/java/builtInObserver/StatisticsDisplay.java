package builtInObserver;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer {
    private double maxTemp = -99999;
    private double avrTemp = 0;
    private double minTemp = 99999;
    private int count = 0;

    public void update(Observable o, Object arg) {
        double temp = ((WeatherData) o).getTemperature();
        if (temp > maxTemp) maxTemp = temp;
        if (temp < minTemp) minTemp = temp;
        avrTemp = (avrTemp * count + temp) / (count + 1);
        count++;
        System.out.println("Avg/Max/Min temperature = " + avrTemp + "/" + maxTemp + "/" + minTemp);
    }
}
