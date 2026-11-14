public class EstrategiaMontoCaracteristica extends EstrategiaMonto {

    public EstrategiaMontoCaracteristica(double valor, Condicion c) {
        super(valor, c);
    }

    public double calcular(Elemento e) {
        if (cumpleCondicion(e)) {
            return super.getValor() * e.getCaracteristicas().size();
        }
        return 0;
    }

}