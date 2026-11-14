public class EstrategiaPorcentaje extends EstrategiaMonto {

    public EstrategiaPorcentaje(double valor, Condicion c) {
        super(valor, c);
    }

    public double calcular(Elemento e) {
        if (cumpleCondicion(e)) {
            return e.getPrecio() * (super.getValor() / 100);
        }
        return 0;
    }
}
