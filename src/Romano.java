public class Romano {
    private int nivelDeSalud;
    private int cantidadDeDientes = 32;
    private String nombre;

    public boolean getAtaque(int poder){
        if (this.nivelDeSalud > 0 && this.cantidadDeDientes > 1){
            this.cantidadDeDientes = this.cantidadDeDientes - 2;
            this.nivelDeSalud = this.nivelDeSalud - (int)(poder * 0.10);

            if (this.nivelDeSalud > 0 && this.cantidadDeDientes > 1)
            {
                return true;
            }
            else {
                return false;
            }

        }
        else {
            return false;
        }

    }
}
