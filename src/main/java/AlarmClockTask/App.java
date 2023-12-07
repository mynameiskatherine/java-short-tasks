package AlarmClockTask;

public class App {
    public static void main(String[] args) {
        AlarmClock clock = new AlarmClock();
        clock.longClickMode();
        clock.clickMode();
        for (int i = 0; i < 18 * 60; i++) {
            clock.tick();
        }
        clock.clickMode();
        System.out.println(clock.getMode());
    }
}
