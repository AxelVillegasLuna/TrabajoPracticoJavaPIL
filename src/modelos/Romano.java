package modelos;

public class Romano {
    private int nivelDeSalud;
    private int cantidadDeDientes;
    private String nombre;

    // Constructor para Romano con datos randoms creado por el jugador
    public Romano(String nombre) {
        this.nivelDeSalud = (int) (Math.random() * (1 - 100 + 1) + 100);
        this.cantidadDeDientes = 32;
        this.nombre = nombre;
    }

    // Constructor para Romano con datos concretos traídos de la DB
    public Romano(String nombre, int dientes, int salud) {
        this.nombre = nombre;
        this.cantidadDeDientes = dientes;
        this.nivelDeSalud = salud;
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
        this.nivelDeSalud = this.nivelDeSalud - (int) (poder * 0.10);
    }

    public void setCantidadDeDientes(int numero) {
        this.cantidadDeDientes = this.cantidadDeDientes - numero;
    }

    public boolean getAtaque(int poder) {
        if (this.nivelDeSalud > 0 && this.cantidadDeDientes > 1) {
            setNivelDeSalud(poder);
            setCantidadDeDientes(2);

            if (getCantidadDeDientes() > 1 && getNivelDeSalud() > 0) {
                // Evalúo si después del combate el Romano pierde
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void mostrarInformacionRomano(Romano romano) {
        System.out.println("\n#----------------------------#");
        System.out.println("Romano: " + romano.getNombre());
        System.out.println("Salud: " + romano.getNivelDeSalud());
        System.out.println("Cantidad de dientes: " + romano.getCantidadDeDientes());
        System.out.println("#----------------------------#");
    }
}

