package AlarmClockTask.states;

import AlarmClockTask.AlarmClock;

public class AlarmState implements State {

    private final String MODE = "alarm";

    private AlarmClock clock;

    public AlarmState(AlarmClock clock) {
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
    public void longClickMode() {
        clock.setAlarmState(!clock.isAlarmOn());
    }

    @Override
    public void clickH() {
        clock.setAlarmHour((clock.getAlarmHours() + 1) % 24);

        clock.ringTheBell();
    }

    @Override
    public void clickM() {
        clock.setAlarmMinute((clock.getAlarmMinutes() + 1) % 60);

        clock.ringTheBell();
    }

    @Override
    public void tick() {
        clock.setClockMinute((clock.getMinutes() + 1) % 60);
        if (clock.getMinutes() == 0) {
            clock.setClockHour((clock.getHours() + 1) % 24);
        }

        clock.ringTheBell();
    }
}
