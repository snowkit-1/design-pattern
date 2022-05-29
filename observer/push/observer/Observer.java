package observer.push.observer;

import observer.push.subject.Weather;

public interface Observer {

    void update(Weather weather);
}
