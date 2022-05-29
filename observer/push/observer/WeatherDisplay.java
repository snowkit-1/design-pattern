package observer.push.observer;

import observer.push.subject.Weather;
import observer.push.subject.WeatherData;

public class WeatherDisplay implements Observer, DisplayElement {

    private Weather weather;

    /*
     * 현재 Push 방식 예제 코드에서 Subject 레퍼런스(WeatherData)는 생성자 말고 사용하는 곳이 없지만 저장하는 이유는
     * 나중에 옵저버 목록에서 삭제할 때 유용하게 사용할 수 있기 때문이다
     */
    private WeatherData weatherData;

    public WeatherDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);

        weather = new Weather();
    }

    @Override
    public void update(Weather weather) {
        this.weather = weather;

        display();
    }

    @Override
    public void display() {
        System.out.printf("현재 날씨: 온도 %.2f°C, 습도 %.0f%%, 풍속 %.1fm/s\n", weather.getTemperature(),
                weather.getHumidity(), weather.getWindSpeed());
    }
}
