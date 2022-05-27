package strategy.duck;

import strategy.fly.FlyWithWings;
import strategy.quack.Quack;

public class MandarinDuck extends Duck {

    public MandarinDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("저는 원앙입니다.");
    }
}
