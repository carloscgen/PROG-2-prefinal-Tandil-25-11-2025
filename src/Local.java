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

    public List<Elemento> copiaProductos() {
        List<Elemento> copias = new ArrayList<>();

        for (Elemento producto : productos) {
            copias.addAll(producto.getCopia(estrategia));
        }

        return copias;
    }

    private boolean pertenece(Elemento e) {
        for (Elemento elemento : productos) {
            if (elemento.getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    public double precioProductoPromocion(Elemento e) {
        double valorFinalProducto = e.getPrecio() - estrategia.calcular(e);
        if (valorFinalProducto > 0) {
            return valorFinalProducto;
        }
        return 0;
    }

    public boolean estaEnPromocion(Elemento e) {
        return e.cumplePromocion(estrategia) && pertenece(e);
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
