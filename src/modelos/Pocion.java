package modelos;

import ingredientes.Cucumber;
import ingredientes.DulceDeLeche;
import ingredientes.Muerdago;
import ingredientes.PetraOleum;

public class Pocion {
    private int cantidadIngredientes = (int) (Math.random() * 4) + 1;
    private Ingrediente ingredientes[] = new Ingrediente[cantidadIngredientes];

    public Pocion(Galo galo) {

        for (int i = 0; i < this.ingredientes.length; i++) {
            ingredientes[i] = new Ingrediente();
            switch (this.ingredientes[i].tipo) {
                case 1:
                    //Dulce de leche
                    new DulceDeLeche(galo);
                    break;
                case 2:
                    //Muérdago
                    new Muerdago(galo);
                    break;
                case 3:
                    //Cucumber
                    new Cucumber(galo);
                    break;
                case 4:
                    //PetraOleum
                    new PetraOleum(galo);
                    break;
            }
        }

        galo.setPoderPosion(galo.getFuerza(), galo.getAstucia());

        System.out.println(toStringPocion(galo));

    }

    public String toStringPocion(Galo galo) {
        return "\n/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/\n" + galo.getNombre() + " bebió la Poción y quedó con " + galo.getAstucia() + " de astucia y " + galo.getFuerza() + " de fuerza\n/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/\n";
    }

}
