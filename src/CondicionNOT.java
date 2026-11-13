public class CondicionNOT extends Condicion {
    Condicion c1;

    public CondicionNOT(Condicion c1) {
        this.c1 = c1;
    }

    public boolean cumple(Elemento e) {
        return !c1.cumple(e);
    }
}
