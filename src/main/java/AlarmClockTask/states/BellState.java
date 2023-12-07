package AlarmClockTask.states;

import AlarmClockTask.AlarmClock;

public class BellState implements State {

    private final String MODE = "bell";

    private AlarmClock clock;

    public BellState(AlarmClock clock) {
        this.clock = clock;
    }

    @Override
    public String getMode() {
        return MODE;
    }

    @Override
    public void clickMode() {
        clock.setCurrentState(new ClockState(clock));
    }

    @Override
    public void longClickMode() {}

    @Override
    public void clickH() {}

    @Override
    public void clickM() {}

    @Override
    public void tick() {
        clock.setClockMinute((clock.getMinutes() + 1) % 60);
        if (clock.getMinutes() == 0) {
            clock.setClockHour((clock.getHours() + 1) % 24);
        }

        clock.setCurrentState(new ClockState(clock));
    }
}
