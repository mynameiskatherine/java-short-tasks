package AlarmClockTask.states;

import AlarmClockTask.AlarmClock;

public class ClockState implements State {

    private static final String MODE = "clock";
    private AlarmClock clock;

    public ClockState(AlarmClock clock) {
        this.clock = clock;
    }
    @Override
    public String getMode() {
        return MODE;
    }
    @Override
    public void clickMode() {
        clock.setCurrentState(new AlarmState(clock));
    }

    @Override
    public void longClickMode() {
        clock.setAlarmState(!clock.isAlarmOn());
    }

    @Override
    public void clickH() {
        clock.setClockHour((clock.getHours() + 1) % 24);
    }

    @Override
    public void clickM() {
        clock.setClockMinute((clock.getMinutes() + 1) % 60);
    }

    @Override
    public void tick() {
        clickM();
        if (clock.getMinutes() == 0) {
            clickH();
        }

        clock.ringTheBell();
    }
}
