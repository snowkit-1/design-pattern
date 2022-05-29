package observer.push.observer;

import observer.push.subject.Weather;
import observer.push.subject.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement {

    private double minTemperature = Double.MAX_VALUE;

    private double maxTemperature = Double.MIN_VALUE;

    private double avgTemperature;

    private double sumTemperature = 0.0;

    private int count = 0;

    /*
     * 현재 Push 방식 예제 코드에서 Subject 레퍼런스(WeatherData)는 생성자 말고 사용하는 곳이 없지만 저장하는 이유는
     * 나중에 옵저버 목록에서 삭제할 때 유용하게 사용할 수 있기 때문이다
     */
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(Weather weather) {
        sumTemperature += weather.getTemperature();
        count++;

        avgTemperature = sumTemperature / count;

        if (minTemperature > weather.getTemperature()) {
            minTemperature = weather.getTemperature();
        }

        if (maxTemperature < weather.getTemperature()) {
            maxTemperature = weather.getTemperature();
        }

        display();
    }

    @Override
    public void display() {
        System.out.printf("평균/최고/최저 기온(°C): %.1f°C/%.1f°C/%.1f°C\n", avgTemperature, maxTemperature, minTemperature);
    }
}
