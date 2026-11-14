public abstract class Estrategia {
    private Condicion c;

    public abstract double calcular(Elemento e);

    public boolean cumpleCondicion(Elemento e) {
        return c.cumple(e);
    }

    public Estrategia(Condicion c) {
        this.c = c;
    }

    public Condicion getCondicion() {
        return this.c;
    }

    public void setCondicion(Condicion c) {
        this.c = c;
    }
}
