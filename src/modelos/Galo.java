package modelos;

public class Galo {
    private int fuerza;
    private int astucia;
    private int poder;
    private int contadorCombate;
    private String nombre;

    // Constructor para Galo con datos randoms creado por el jugador
    public Galo(String nombre) {
        this.fuerza = (int) (Math.random() * (1 - 25 + 1) + 25);
        this.astucia = (int) (Math.random() * (1 - 5 + 1) + 5);
        this.poder = this.fuerza * this.astucia;
        this.nombre = nombre;
        this.contadorCombate = 0;
    }

    // Constructor para Galo con datos concretos traídos de la DB
    public Galo(String nombre, int astucia, int fuerza) {
        this.nombre = nombre;
        this.astucia = astucia;
        this.fuerza = fuerza;
        this.poder = this.fuerza * this.astucia;
        this.contadorCombate = 0;
    }

    public void setFuerza(int fuerza) {
        this.fuerza += fuerza;
        if (this.fuerza > 25) {
            this.fuerza = 25;
        }
    }

    public void setAstucia(int astucia) {
        this.astucia += astucia;
        if (this.astucia > 5) {
            this.astucia = 5;
        }
    }

    public void setPoder(int numero) {
        this.poder = this.poder - numero;
    }

    public void setPoderPosion(int fuerza, int astucia) {
        this.poder = fuerza * astucia;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getAstucia() {
        return astucia;
    }

    public int getPoder() {
        return poder;
    }

    public String getNombre() {
        return nombre;
    }

    public void atacarRomano(Galo galo, Romano romano) {
        /**
         * Esta funcion permite simular el ataque de un Galo a un Romano
         */
        System.out.println("\n/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");

        this.contadorCombate++;

        if (romano.getAtaque(this.poder)) {
            System.out.println("Combate " + this.contadorCombate + " - " + galo.getNombre() + " con " + this.poder + " de poder ataca a " + romano.getNombre() +
                    " que queda con " + romano.getCantidadDeDientes() + " dientes y " + romano.getNivelDeSalud() + " de salud" +
                    "\n/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
            this.setPoder(1);
            if (this.poder <= 0) {
                System.out.println("El galo " + this.nombre + " se quedó sin fuerza, " + romano.getNombre() + " gana el combate" +
                        "\n/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
                System.out.println("----------------------------------------GAME OVER---------------------------------------");
                System.exit(0);
            } else {

            }
        } else {
            if (romano.getCantidadDeDientes() <= 0) {
                System.out.println("El romano " + romano.getNombre() + " fue derrotado porque quedó sin dientes" +
                        "\n/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
                System.out.println("----------------------------------------GAME OVER---------------------------------------");
                System.exit(0);
            } else {
                if (romano.getNivelDeSalud() < 1) {
                    System.out.println("El romano " + romano.getNombre() + " fue derrotado porque quedó sin vida" +
                            "\n/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
                    System.out.println("----------------------------------------GAME OVER---------------------------------------");
                    System.exit(0);
                }
            }
        }

    }

    public void mostrarInformacionGalo(Galo galo) {
        System.out.println("\n*------------------*");
        System.out.println("Galo: " + galo.getNombre());
        System.out.println("Fuerza: " + galo.getFuerza());
        System.out.println("Astucia: " + galo.getAstucia());
        System.out.println("Poder: " + galo.getPoder());
        System.out.println("*------------------*");
    }

    public void tomarPosion(Galo galo) {
        new Posion(galo);
    }

}

