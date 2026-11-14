public class ProductoCaracteristicasLimitadas extends ProductoSimple {
    private final int limite;

    public ProductoCaracteristicasLimitadas(int id, String marca, double precio, int limite) {
        super(id, marca, precio);
        this.limite = limite;
    }

    protected ProductoSimple copiaInicial() {
        return new ProductoCaracteristicasLimitadas(getId(), getMarca(), getPrecio(), limite);
    }

    public void setCaracteristicas(String ca) {
        int cantCaract = super.getCaracteristicas().size();
        if (cantCaract < this.limite) {
            super.setCaracteristicas(ca);
        }
    }

    public int getLimite() {
        return this.limite;
    }

}
