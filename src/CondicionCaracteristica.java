public class CondicionCaracteristica extends Condicion {
    private String car;

    public CondicionCaracteristica(String car) {
        this.car = car;
    }

    public String getCaracteristica() {
        return this.car;
    }

    public boolean cumple(Elemento e) {
        return e.getCaracteristicas().contains(car);
    }

}
