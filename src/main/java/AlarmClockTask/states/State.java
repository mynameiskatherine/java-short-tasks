package AlarmClockTask.states;

public interface State {
    //нажатие на кнопку Mode
    void clickMode();

    //долгое нажатие на кнопку Mode
    void longClickMode();

    //нажатие на кнопку H
    void clickH();

    //нажатие на кнопку M
    void clickM();

    // при вызове, увеличивает время на одну минуту.
    // Если новое время совпало со временем на будильнике, то часы переключаются в режим срабатывания будильника (bell).
    void tick();

    String getMode();
}
