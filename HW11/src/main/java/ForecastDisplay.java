public class ForecastDisplay implements Observer, DisplayElement{
    private WeatherData subject = new WeatherData();
    private double oldTemp;
    private double oldHumid;
    private String notification;

    public ForecastDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
        subject = weatherData;
    }

    public void update() {
        double temp = subject.getTemperature();
        double humid = subject.getHumidity();
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
        display();
    }

    public void display() {
        System.out.println("Forecast: " + notification);
    }
}
