import java.util.ArrayList;
import java.util.List;

public class ProductoSimple extends Elemento {
    private double precio;
    private List<String> caracteristicas;

    public ProductoSimple(int id, String marca, double precio) {
        super(id, marca);
        this.precio = precio;
        this.caracteristicas = new ArrayList<>();
    }

    protected ProductoSimple copiaInicial() {
        return new ProductoSimple(getId(), getMarca(), precio);
    }

    public List<Elemento> getCopia(Estrategia est) {
        List<Elemento> lista = new ArrayList<>();

        if (est.cumpleCondicion(this)) {
            ProductoSimple ps = copiaInicial();
            ps.caracteristicas = new ArrayList<>(this.caracteristicas);
            lista.add(ps);
        }
        return lista;
    }

    public void setCaracteristicas(String ca) {
        this.caracteristicas.add(ca);
    }

    public List<String> getCaracteristicas() {
        return new ArrayList<>(this.caracteristicas);
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
