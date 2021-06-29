package ingredientes;

import modelos.Galo;
import modelos.Ingrediente;

public class PetraOleum extends Ingrediente {
    private int valores[] = {2, 4, 6};
    private int indiceRandom = (int) (Math.random() * 2);
    private int cm3 = valores[indiceRandom];

    public PetraOleum(Galo galo) {
        switch (this.cm3) {
            case 2:
                galo.setFuerza(2);
                break;
            case 4:
                galo.setFuerza(4);
                break;
            case 6:
                galo.setFuerza(6);
                break;
            default:
                galo.setFuerza(0);
        }

    }

}
