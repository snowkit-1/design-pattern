package strategy;

public class DuckSimulator {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.quack();// 꽥꽥
        mallardDuck.fly();// 하늘을 날고 있어요!
        mallardDuck.display();// 저는 청둥오리입니다.

        Duck mandarinDuck = new MandarinDuck();
        mandarinDuck.quack();// 꽥꽥
        mandarinDuck.fly();// 하늘을 날고 있어요!
        mandarinDuck.display();// 저는 원앙입니다.

        Duck rubberDuck = new RubberDuck();
        rubberDuck.quack();// 삑!
        rubberDuck.fly();// 저는 날 수 없어요.
        rubberDuck.display();// 저는 고무 오리 장난감입니다.

        Duck decoyDuck = new DecoyDuck();
        decoyDuck.quack();// --- 조용 ---
        decoyDuck.fly();// 저는 날 수 없어요.
        decoyDuck.display();// 저는 가짜 오리 모형입니다.

    }
}
