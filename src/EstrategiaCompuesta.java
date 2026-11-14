public class EstrategiaCompuesta extends Estrategia{
    Estrategia e1;
    Estrategia e2;

    public EstrategiaCompuesta(Condicion c, Estrategia e1, Estrategia e2) {
        super(c);
        this.e1 = e1;
        this.e2 = e2;
    }

    public double calcular(Elemento el) {
        if(cumpleCondicion(el)) {
            return e1.calcular(el) + e2.calcular(el);
        }
        return 0;
    }

}
