public class CondicionMarca extends Condicion {
    private String marca;

    public CondicionMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public boolean cumple(Elemento e) {
        return e.getMarca().equals(marca);
    }

}
