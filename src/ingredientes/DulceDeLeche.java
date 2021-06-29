package ingredientes;

import modelos.Galo;
import modelos.Ingrediente;

public class DulceDeLeche extends Ingrediente {

    public DulceDeLeche(Galo galo) {
        galo.setAstucia(2);
        galo.setFuerza(10);
    }
}
