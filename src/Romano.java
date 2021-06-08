public class Romano {
    private int nivelDeSalud;
    private int cantidadDeDientes;
    private String nombre;

    public Romano(String nombre) {

        this.nivelDeSalud = (int)(Math.random()*(1-100+1)+100);
        this.cantidadDeDientes = 32;
        this.nombre = nombre;
    }

    public int getNivelDeSalud() {
        return nivelDeSalud;
    }

    public int getCantidadDeDientes() {
        return cantidadDeDientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNivelDeSalud(int poder) {
        this.nivelDeSalud = this.nivelDeSalud - (int)(poder * 0.10);
    }

    public void setCantidadDeDientes() {
        this.cantidadDeDientes = this.cantidadDeDientes - 2;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getAtaque(int poder){
        if (this.nivelDeSalud > 0 && this.cantidadDeDientes > 1){
            setNivelDeSalud(poder);
            setCantidadDeDientes();

            if (getCantidadDeDientes() > 1 && getNivelDeSalud() > 0){
                /**
                 * Evaluo si despues del combate el Romano pierde
                 */
                return true;
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }
}
