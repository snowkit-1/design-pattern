package observer.pull.observer;

import observer.pull.subject.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement {

    private double minTemperature = Double.MAX_VALUE;

    private double maxTemperature = Double.MIN_VALUE;

    private double avgTemperature;

    private double sumTemperature = 0.0;

    private int count = 0;

    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        double temperature = weatherData.getTemperature();

        sumTemperature += temperature;
        count++;

        avgTemperature = sumTemperature / count;

        if (minTemperature > temperature) {
            minTemperature = temperature;
        }

        if (maxTemperature < temperature) {
            maxTemperature = temperature;
        }

        display();
    }

    @Override
    public void display() {
        System.out.printf("평균/최고/최저 기온(°C): %.1f°C/%.1f°C/%.1f°C\n", avgTemperature, maxTemperature, minTemperature);
    }
}
