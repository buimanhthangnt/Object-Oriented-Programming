public class CurrentConditionDisplay implements Observer, DisplayElement{
    private WeatherData subject = new WeatherData();
    private double temperature;
    private double humidity;

    public CurrentConditionDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
        subject = weatherData;
    }

    public void update() {
        temperature = subject.getTemperature();
        humidity = subject.getHumidity();
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
