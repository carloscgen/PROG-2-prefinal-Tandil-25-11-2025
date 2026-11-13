import java.util.ArrayList;
import java.util.List;

public class Local {
    private String nombre;
    private List<Elemento> productos;
    private Estrategia estrategia;

    public Local(String nombre, Estrategia estrategia) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
        this.estrategia = estrategia;
    }

    public void setEstrategia(Estrategia e) {
        this.estrategia = e;
    }

    public Estrategia getEstrategia() {
        return this.estrategia;
    }

    public List<Elemento> getProductos() {
        return new ArrayList<>(this.productos);
    }

    public void agregarProductos(Elemento e) {
        this.productos.add(e);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
