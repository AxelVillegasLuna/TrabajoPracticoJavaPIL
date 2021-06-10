import java.util.Random;

public class Muerdago extends Ingrediente{
    private int tamanioManojo = (int) (Math.random() * 3) + 1;

    public Muerdago(Galo galo){
        int astuciaGalo = galo.getAstucia();
        int valorNuevoAstucia;

        switch(this.tamanioManojo) {
            case 1:
                galo.setFuerza(1);
                valorNuevoAstucia = (astuciaGalo * 75) / 100;
                galo.setAstucia(valorNuevoAstucia);
                break;
            case 2:
                galo.setFuerza(2);
                valorNuevoAstucia = (astuciaGalo * 50) / 100;
                galo.setAstucia(valorNuevoAstucia);
                break;
            case 3:
                galo.setFuerza(3);
                valorNuevoAstucia = (astuciaGalo * 25) / 100;
                galo.setAstucia(valorNuevoAstucia);
                break;
            default:
                galo.setFuerza(0);
                galo.setAstucia(0);
        }

    }
}
