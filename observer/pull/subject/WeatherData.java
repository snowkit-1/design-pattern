package observer.pull.subject;

import observer.pull.observer.Observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherData implements Subject {

    private Set<Observer> observers;

    private Weather weather;

    // 생성자에서 객체 생성 및 초기화
    public WeatherData() {
        observers = new HashSet<>();
        weather = new Weather();
    }

    // 옵저버 등록
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // 옵저버 삭제
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // 모든 옵저버들에게 상태 변화 알림
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    // 구현 목표 기준 상태가 갱신되면 실제로 호출되는 메소드
    public void measurementsChanged() {
        notifyObservers();
    }

    // 새로운 상태 갱신 메소드
    public void setMeasurements(double temperature, double humidity, double windSpeed) {
        weather.setTemperature(temperature);
        weather.setHumidity(humidity);
        weather.setWindSpeed(windSpeed);

        measurementsChanged();
    }

    public double getTemperature() {
        return weather.getTemperature();
    }

    public double getHumidity() {
        return weather.getHumidity();
    }

    public double getWindSpeed() {
        return weather.getWindSpeed();
    }
}
