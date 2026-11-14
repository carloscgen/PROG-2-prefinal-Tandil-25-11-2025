import java.util.List;

public abstract class Elemento {
    private int id;
    private String marca;

    public abstract double getPrecio();
    public abstract List<String> getCaracteristicas();
    public abstract List<Elemento> getCopia(Estrategia e);

    public boolean cumplePromocion(Estrategia e) {
        return e.cumpleCondicion(this);
    }

    public Elemento(int id, String marca) {
        this.id = id;
        this.marca = marca;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
