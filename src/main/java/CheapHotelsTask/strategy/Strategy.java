package CheapHotelsTask.strategy;
import java.util.Map;

public interface Strategy {
    public static Map<String, Strategy> strategyMap = Map.of(
            "booking", new BookingStrategy(),
            "kayak", new KayakStrategy(),
            "ostrovok", new OstrovokStrategy());
    Map<String, Object> convert(Map<String, Object> hotel);
}
