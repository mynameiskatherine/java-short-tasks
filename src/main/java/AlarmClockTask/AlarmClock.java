package AlarmClockTask;

import AlarmClockTask.states.AlarmState;
import AlarmClockTask.states.BellState;
import AlarmClockTask.states.ClockState;
import AlarmClockTask.states.State;

import java.util.Map;

public class AlarmClock implements State {
    private int clockHour = 12;
    private int clockMinute = 0;
    private int alarmHour = 6;
    private int alarmMinute = 0;
    private boolean alarmState = false;
    private State currentState = new ClockState(this);

    //показывает включен ли режим будильника. Возвращает логическое значение
    public boolean isAlarmOn() {
        return alarmState;
    }

    //возвращает true, если время на часах совпадает со временем на будильнике, иначе false
    public boolean isAlarmTime() {
        return (clockHour == alarmHour && clockMinute == alarmMinute);
    }

    //возвращает минуты, установленные на часах
    public int getMinutes() {
        return clockMinute;
    }

    //возвращает часы, установленные на часах
    public int getHours() {
        return clockHour;
    }

    //возвращает минуты, установленные на будильнике
    public int getAlarmMinutes() {
        return alarmMinute;
    }

    //возвращает часы, установленные на будильнике
    public int getAlarmHours() {
        return alarmHour;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setClockHour(int clockHour) {
        this.clockHour = clockHour;
    }

    public void setClockMinute(int clockMinute) {
        this.clockMinute = clockMinute;
    }

    public void setAlarmHour(int alarmHour) {
        this.alarmHour = alarmHour;
    }

    public void setAlarmMinute(int alarmMinute) {
        this.alarmMinute = alarmMinute;
    }

    public void setAlarmState(boolean alarmState) {
        this.alarmState = alarmState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    @Override
    public void clickMode() {
        getCurrentState().clickMode();
    }

    @Override
    public void longClickMode() {
        getCurrentState().longClickMode();
    }

    @Override
    public void clickH() {
        getCurrentState().clickH();
    }

    @Override
    public void clickM() {
        getCurrentState().clickM();
    }

    @Override
    public void tick() {
        getCurrentState().tick();
    }

    @Override
    public String getMode() {
        return getCurrentState().getMode();
    }

    public void ringTheBell() {
        if (this.isAlarmOn() && this.isAlarmTime()) {
            this.setCurrentState(new BellState(this));
        }
    }

}
