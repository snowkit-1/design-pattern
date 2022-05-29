package observer.push.observer;

import observer.push.subject.Weather;
import observer.push.subject.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {

    private double currentWindSpeed = 0.0;

    private double lastWindSpeed;

    /*
     * 현재 Push 방식 예제 코드에서 Subject 레퍼런스(WeatherData)는 생성자 말고 사용하는 곳이 없지만 저장하는 이유는
     * 나중에 옵저버 목록에서 삭제할 때 유용하게 사용할 수 있기 때문이다
     */
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(Weather weather) {
        lastWindSpeed = currentWindSpeed;
        currentWindSpeed = weather.getWindSpeed();

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
