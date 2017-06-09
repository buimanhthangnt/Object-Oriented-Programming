public class StatisticsDisplay implements Observer, DisplayElement{
    private WeatherData subject = new WeatherData();
    private double maxTemp = -99999;
    private double avrTemp = 0;
    private double minTemp = 99999;
    private int count = 0;

    public StatisticsDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
        subject = weatherData;
    }

    public void update() {
        double temp = subject.getTemperature();
        if (temp > maxTemp) maxTemp = temp;
        if (temp < minTemp) minTemp = temp;
        avrTemp = (avrTemp * count + temp) / (count + 1);
        count++;
        display();
    }

    public void display() {
        System.out.println("Avg/Max/Min temperature = " + avrTemp + "/" + maxTemp + "/" + minTemp);
    }
}
