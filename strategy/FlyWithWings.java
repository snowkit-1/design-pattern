package strategy;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("하늘을 날고 있어요!");
    }
}
