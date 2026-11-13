import java.util.ArrayList;
import java.util.List;

public class CondicionCaracteristicas extends Condicion {
    private List<String> cars;

    public CondicionCaracteristicas(List<String> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<String> getCaracteristicas() {
        return new ArrayList<>(this.cars);
    }

    public boolean cumple(Elemento e) {
        for (String car : cars) {
            if (!e.getCaracteristicas().contains(car)) {
                return false;
            }
        }

        return true;
    }

}
