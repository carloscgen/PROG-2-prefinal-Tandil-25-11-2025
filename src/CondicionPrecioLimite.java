public class CondicionPrecioLimite extends Condicion {
    private double limite;

    public CondicionPrecioLimite(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return this.limite;
    }

    public boolean cumple(Elemento e) {
        return e.getPrecio() > this.limite;
    }
}
