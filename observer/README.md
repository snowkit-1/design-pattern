# Observer Pattern
## 구현 목표
```java
class WeatherData {
    double getTemperature() {}
    double getHumidity() {}
    double getWindSpeed() {}
    void measurementsChanged() {
        // 코드 구현
    }
}
```
* WeatherData 클래스에는 온도, 습도, 풍속을 확인할 수 있는 Getter 메소드가 존재한다
* 새로운 측정 값이 갱신될 때마다 measurementsChanged() 메소드가 호출된다
* 위 API들을 사용해 클라이언트(디스플레이)에서 다음 기능을 구현한다
  * 현재 날씨(온도, 습도, 풍속 표시) 표시
  * 기온 통계(평균 기온, 최고 기온, 최저 기온) 표시
  * 기상 예보 표시
  * 추후 기능 추가될 수 있음

## Worst Case
```java
class WeatherData {
    
    // 인스턴스 변수 선언
    
    void measurementsChanged() {
        double temperature = getTemperature();
        double humidity = getHumidity();
        double windSpeed = getWindSpeed();
        
        // 디스플레이 갱신
        weatherDisplay.update(temperature, humidity, windSpeed);
        statisticsDisplay.update(temperature, humidity, windSpeed);
        forecastDisplay.update(temperature, humidity, windSpeed);
    }
    
    // 기타 메소드
}
```
* 위 구현의 문제점
  * weatherDisplay, statisticsDisplay, forecastDisplay
    * 인터페이스가 아닌 구체적인 구현을 바탕으로 개발
    * 캡슐화하지 않음
    * 코드를 수정하지 않으면 디스플레이 기능을 추가할 수 없음
  * 실행 중에 디스플레이를 더하거나 뺄 수 없다

## Observer Pattern이란?
* Subject(주제) - Observer(옵저버)
* 1:N 관계
* 주제의 상태가 바뀌면 옵저버들에게 연락이 가고 자동으로 정보가 갱신된다
* Push 방식과 Pull 방식
  * Push 방식
    * 주제가 갱신되면 모든 데이터를 옵저버들에게 전달한다
  * Pull 방식
    * 주제가 갱신되면 옵저버에게 알림을 보내고, 옵저버는 필요한 데이터만 주제에게서 가져간다

## Observer Pattern 구현 방법
```java
interface Subject {
    registerObserver(Observer observer);
    removeObserver(Observer observer);
    notifyObservers();
}

interface Observer {
    update();
}
```
* Subject는 옵저버 등록, 옵저버 삭제, 옵저버에게 알림 기능을 구현한다
* Observer는 갱신 기능을 구현한다