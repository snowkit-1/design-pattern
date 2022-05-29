package observer.pull;

import observer.pull.observer.ForecastDisplay;
import observer.pull.observer.StatisticsDisplay;
import observer.pull.observer.WeatherDisplay;
import observer.pull.subject.WeatherData;

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
