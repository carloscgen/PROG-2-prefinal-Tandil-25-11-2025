public class EstrategiaMonto extends Estrategia {
    private double valor;

    public EstrategiaMonto(double valor, Condicion c) {
        super(c);
        this.valor = valor;
    }

    public double calcular(Elemento e) {
        if (cumpleCondicion(e)) {
            return valor;
        }
        return 0;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double val) {
        this.valor = val;
    }

}
