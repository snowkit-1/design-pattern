package observer.pull.observer;

import observer.pull.subject.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {

    private double currentWindSpeed = 0.0;

    private double lastWindSpeed;

    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        lastWindSpeed = currentWindSpeed;
        currentWindSpeed = weatherData.getWindSpeed();

        display();
    }

    @Override
    public void display() {
        if (currentWindSpeed < lastWindSpeed) {
            System.out.println("기상 예보: 바람이 약해지고 있습니다.");
        } else if (currentWindSpeed == lastWindSpeed) {
            System.out.println("기상 예보: 바람의 변화가 없습니다.");
        } else if (currentWindSpeed > lastWindSpeed) {
            System.out.println("기상 예보: 바람이 강해지고 있습니다!");
        }
    }
}
