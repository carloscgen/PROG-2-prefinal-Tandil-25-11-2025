public class CondicionOR extends Condicion {
    Condicion c1;
    Condicion c2;

    public CondicionOR(Condicion c1, Condicion c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public boolean cumple(Elemento e) {
        return c1.cumple(e) || c2.cumple(e);
    }
}
