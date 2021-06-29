package modelos;

public class Galo {
    private int fuerza;
    private int astucia;
    private int poder;
    private int contadorCombate;

    private String nombre;

    public Galo(String nombre) {
        this.fuerza = (int) (Math.random() * (1 - 25 + 1) + 25);
        this.astucia = (int) (Math.random() * (1 - 5 + 1) + 5);
        this.poder = this.fuerza * this.astucia;
        this.nombre = nombre;
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

    public void setPoder() {
        this.poder = this.poder - 1;
    }

    public void setPoderPosion() {
        this.poder = this.fuerza * this.astucia;
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
         * Esta funcion permite simular el ataque de un models.Galo a un models.Romano
         */
        /*Datos models.Galo*/
        System.out.println("\n*------------------*");
        System.out.println("Galo: " + this.nombre);
        System.out.println("Fuerza: " + this.fuerza);
        System.out.println("Astucia: " + this.astucia);
        System.out.println("Poder: " + this.poder);
        System.out.println("*------------------*");

        /*Datos models.Romano*/
        System.out.println("\n#----------------------------#");
        System.out.println("Romano: " + romano.getNombre());
        System.out.println("Salud: " + romano.getNivelDeSalud());
        System.out.println("Cantidad de dientes: " + romano.getCantidadDeDientes());
        System.out.println("#----------------------------#");

        System.out.println("\n/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");

        contadorCombate++;

        if (romano.getAtaque(this.poder)) {
            System.out.println(toStringCombate(galo, romano, contadorCombate));
            galo.setPoder();

            if (this.poder < 0) {
                System.out.println("El galo " + this.nombre + " se quedo sin fuerza, " + romano.getNombre() + " gana el combate");
                System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
            }
        } else {
            if (romano.getCantidadDeDientes() <= 0) {
                System.out.println("El romano " + romano.getNombre() + " fue derrotado por que quedo sin dientes");
                System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
            } else {
                if (romano.getNivelDeSalud() < 1) {
                    System.out.println("El romano " + romano.getNombre() + " fue derrotado por que quedo sin vida");
                    System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
                }
            }

        }

    }

    public String toStringCombate(Galo galo, Romano romano, int contadorCombate) {
        return "Combate " + contadorCombate + " - " + this.nombre + " con " + this.poder + " de poder ataca a " + romano.getNombre() +
                " que queda con " + romano.getCantidadDeDientes() + " dientes y " + romano.getNivelDeSalud() + " de salud\n" + "/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n";
    }

    public void tomarPosion(Galo galo) {
        new Posion(galo);
    }

}

