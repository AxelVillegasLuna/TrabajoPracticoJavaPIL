package modelos;

public class Ingrediente {
    protected int tipo;

    public Ingrediente() {
        this.tipo = (int) (Math.random() * 4) + 1;
    }
}
