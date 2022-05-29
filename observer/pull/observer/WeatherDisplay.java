package observer.pull.observer;

import observer.pull.subject.Weather;
import observer.pull.subject.WeatherData;

public class WeatherDisplay implements Observer, DisplayElement {

    private Weather weather;

    private WeatherData weatherData;

    public WeatherDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);

        weather = new Weather();
    }

    @Override
    public void update() {
        weather.setTemperature(weatherData.getTemperature());
        weather.setHumidity(weatherData.getHumidity());
        weather.setWindSpeed(weatherData.getWindSpeed());

        display();
    }

    @Override
    public void display() {
        System.out.printf("현재 날씨: 온도 %.2f°C, 습도 %.0f%%, 풍속 %.1fm/s\n", weather.getTemperature(),
                weather.getHumidity(), weather.getWindSpeed());
    }
}
