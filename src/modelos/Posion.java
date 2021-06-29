package modelos;

import ingredientes.Cucumber;
import ingredientes.DulceDeLeche;
import ingredientes.Muerdago;
import ingredientes.PetraOleum;

public class Posion {
    private int cantidadIngredientes = (int) (Math.random() * 4) + 1;
    private Ingrediente ingredientes[] = new Ingrediente[cantidadIngredientes];

    public Posion(Galo galo) {

        for (int i = 0; i < this.ingredientes.length; i++) {
            ingredientes[i] = new Ingrediente();
            switch (this.ingredientes[i].tipo) {
                case 1:
                    //Dulce de leche
                    new DulceDeLeche(galo);
                    break;
                case 2:
                    //ingredientes.Muerdago
                    new Muerdago(galo);
                    break;
                case 3:
                    //ingredientes.Cucumber
                    new Cucumber(galo);
                    break;
                case 4:
                    //ingredientes.PetraOleum
                    new PetraOleum(galo);
                    break;
                default:
                    continue;
            }
        }

        galo.setPoderPosion();

        System.out.println(toStringPosion(galo));

    }

    public String toStringPosion(Galo galo) {
        return "\n/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/\n" + galo.getNombre() + " bebió la Posión y quedó con " + galo.getAstucia() + " de astucia y " + galo.getFuerza() + " de fuerza.\n/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/\n";
    }

}
