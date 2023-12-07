package AlarmClockTest;

import AlarmClockTask.AlarmClock;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class AppTest {

    @Test
    void testStartingBellIfAlarmOn3() {
        AlarmClock clock = new AlarmClock();
        clock.longClickMode();
        clock.clickMode();
        assertThat(clock.getCurrentMode()).isEqualTo("alarm");

        for (int i = 0; i < 18 * 60; i++) {
            clock.tick();
        }

        assertThat(clock.isAlarmTime()).isTrue();
        assertThat(clock.isAlarmOn()).isTrue();

        assertThat(clock.getCurrentMode()).isEqualTo("bell");
        clock.clickMode();
        assertThat(clock.getCurrentMode()).isEqualTo("clock");
    }

    @Test
    void testNoBellForAlarmModeIfAlarmOff() {
        AlarmClock clock = new AlarmClock();
        clock.clickMode();
        assertThat(clock.getCurrentMode()).isEqualTo("alarm");

        for (int i = 0; i < 18 * 60; i++) {
            clock.tick();
        }

        assertThat(clock.isAlarmTime()).isTrue();
        assertThat(clock.isAlarmOn()).isFalse();
        assertThat(clock.getCurrentMode()).isEqualTo("alarm");

        clock.clickMode();
        clock.tick();
        assertThat(clock.getCurrentMode()).isEqualTo("clock");
    }

}
