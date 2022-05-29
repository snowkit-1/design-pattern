package observer.push;

import observer.push.observer.ForecastDisplay;
import observer.push.observer.StatisticsDisplay;
import observer.push.observer.WeatherDisplay;
import observer.push.subject.WeatherData;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        WeatherDisplay weatherDisplay = new WeatherDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(16, 52, 2.5);
        weatherData.setMeasurements(21, 51, 2.5);
        weatherData.setMeasurements(15, 63, 2.1);
    }
}
