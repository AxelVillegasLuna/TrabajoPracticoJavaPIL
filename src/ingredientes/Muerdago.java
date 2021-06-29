package ingredientes;

import modelos.Galo;
import modelos.Ingrediente;

public class Muerdago extends Ingrediente {
    private int tamanioManojo = (int) (Math.random() * 3) + 1;

    public Muerdago(Galo galo) {
        int astuciaGalo = galo.getAstucia();
        int valorNuevoAstucia = 0;
        int fuerza = 0;

        switch (this.tamanioManojo) {
            case 1:
                fuerza = 1;
                valorNuevoAstucia = (astuciaGalo * 75) / 100;
                break;
            case 2:
                fuerza = 2;
                valorNuevoAstucia = (astuciaGalo * 50) / 100;
                break;
            case 3:
                fuerza = 3;
                valorNuevoAstucia = (astuciaGalo * 25) / 100;
                break;
        }
        galo.setFuerza(fuerza);
        galo.setAstucia(valorNuevoAstucia);
    }
}
