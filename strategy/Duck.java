package strategy;

public abstract class Duck {

    protected FlyBehavior flyBehavior;

    protected QuackBehavior quackBehavior;

    // 동적으로 행동 변화
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    // 동적으로 행동 변화
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    // 모든 오리는 각각 생김새가 다르기에 display()는 직접 구현
    public abstract void display();

    // 모든 오리는 헤엄칠 수 있기 때문에 swim 상속
    public void swim() {
        System.out.println("모든 오리는 헤엄칠 수 있어요");
    }

    /*
     * 몇몇 오리는 날 수 있고, 몇몇 오리는 날 수 없다.
     * 객체지향의 기본을 따른다면 모든 서브클래스에서 fly()를 직접 구현하거나, 슈퍼클래스인 Duck에서 구현해놓고 서브클래스에서 재정의해야 한다.
     * 디자인 패턴인 Strategy Pattern을 따르면 슈퍼클래스인 Duck에선 FlyBehavior 인터페이스 메소드를 호출하고,
     * Duck의 서브클래스에선 FlyBehavior 인터페이스의 구현체를 생성자 등을 통해 초기화한다.
     */
    public void fly() {
        flyBehavior.fly();
    }

    /*
     * 몇몇 오리는 울음소리가 같다.
     * Strategy Pattern을 활용하면 슈퍼클래스인 Duck의 서브클래스에서 QuackBehavior의 구현체를 초기화할 수 있다.
     */
    public void quack() {
        quackBehavior.quack();
    }
}
