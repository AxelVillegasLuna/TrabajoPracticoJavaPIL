import java.util.ArrayList;
import java.util.List;

public class Posion {
    private List<Integer> ingredientes = new ArrayList<Integer>();

    public void MostrarIngredientes(){
        for(int ingrediente: ingredientes){
            System.out.println(ingrediente);
        }
    }

    public Posion(Galo galo) {
        int cantidadIngredientes = (int) (Math.random() * 4) + 1;
        for(int i = 1; i <= cantidadIngredientes; i++){
            ingredientes.add((int) (Math.random() * 4) + 1);
        }

        for(int ingrediente: ingredientes){
            switch(ingrediente) {
                case 1:
                    //Dulce de leche
                    new DulceDeLeche(galo);
                    break;
                case 2:
                    //Muerdago
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
                default:
                    continue;
            }
        }
    }

}
