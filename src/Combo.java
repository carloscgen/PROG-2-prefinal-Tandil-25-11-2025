import java.util.ArrayList;
import java.util.List;

public class Combo extends Elemento {
    private List<Elemento> elementos;

    public Combo(int id, String marca) {
        super(id, marca);
        this.elementos = new ArrayList<>();
    }

    public List<Elemento> getCopia(Estrategia est) {
        List<Elemento> lista = new ArrayList<>();
        Combo co = new Combo(getId(), getMarca());

        if (est.cumpleCondicion(this)) {
            lista.add(co);
            return lista;
        }

        for (Elemento elemento : elementos) {
            List<Elemento> copiasHijo = elemento.getCopia(est);

            for (Elemento copiaHijo : copiasHijo) {
                co.addElementos(copiaHijo);
            }
        }

        if (!co.getElementos().isEmpty()) {
            lista.add(co);
        }

        return lista;
    }

    public List<Elemento> getElementos() {
        return new ArrayList<>(this.elementos);
    }

    public void addElementos(Elemento e) {
        if (getMarca().equals(e.getMarca())) {
            elementos.add(e);
        }
    }

    public double getPrecio() {
        double total = 0;

        if (!elementos.isEmpty()) {
            for (Elemento elemento : elementos) {
                total += elemento.getPrecio();
            }
        }
        return total;
    }

    public List<String> getCaracteristicas() {
        List<String> caracteristicasTotales = new ArrayList<>();

        for (Elemento elemento : elementos) {
            List<String> caracteristicasElemento = elemento.getCaracteristicas();
            for (String caracteristica : caracteristicasElemento) {
                if (!caracteristicasTotales.contains(caracteristica)) {
                    caracteristicasTotales.add(caracteristica);
                }
            }
        }
        return caracteristicasTotales;
    }

    // public List<Elemento> copia(Estrategia est) {
    // List<Elemento> copias = new ArrayList<>();

    // Combo nuevoCombo = new Combo(getId(), getMarca());
    // if (!est.aplica(this)) {

    // for (Elemento el : elementos) {
    // List<Elemento> elUnidad = el.copia(est);

    // for (Elemento unidad : elUnidad) {

    // nuevoCombo.add(unidad);
    // }

    // }
    // if (nuevoCombo.size() > 0) {
    // copias.add(nuevoCombo);
    // }
    // } else {
    // copias.add(nuevoCombo);
    // }

    // return copias;
    // }

}
