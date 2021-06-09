import java.util.Random;

public class Galo {
    private int fuerza;
    private int astucia;



    private String nombre;

    public Galo(String nombre) {
        this.fuerza = (int)(Math.random()*(1-25+1)+25);
        this.astucia = (int)(Math.random()*(1-5+1)+5);
        this.nombre = nombre;
    }

    public void setFuerza(int fuerza) {
        this.fuerza += fuerza;
        if(this.fuerza > 25){
            this.fuerza = 25;
        }
    }

    public void setAstucia(int astucia) {
        this.astucia += astucia;
        if(this.astucia > 5){
            this.astucia = 5;
        }
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getAstucia() {
        return astucia;
    }

    public String getNombre() {
        return nombre;
    }

    public void atacarRomano(Galo galo, Romano romano){
        /**
         * Esta funcion permite simular el ataque de un Galo a un Romano
         */
        int poderGalo = galo.getAstucia() * galo.getFuerza();
        /*Datos Galo*/
        System.out.println("Galo: "+galo.getNombre());
        System.out.println("--------------------");
        System.out.println("Fuerza: "+galo.getFuerza());
        System.out.println("Astucia: "+galo.getAstucia());
        System.out.println("Poder: "+poderGalo);

        /*Datos Romano*/
        System.out.println("Romano: "+romano.getNombre());
        System.out.println("--------------------");
        System.out.println("Salud: "+romano.getNivelDeSalud());
        System.out.println("Cantidad de dientes: "+romano.getCantidadDeDientes());

        /**
         * Optimizar las impresiones de arriba con un toString en cada objeto
         */

        System.out.println("Combate");

        boolean resultado = true;
        int contadorCombate = 0;
        while (resultado){
            contadorCombate++;
            if (romano.getAtaque(poderGalo)){

                System.out.println(toStringCombate(galo, romano, contadorCombate, poderGalo));

                poderGalo = poderGalo - 1;
                if (poderGalo > 0){
                    resultado = true;
                }
                else{
                    System.out.println("\nResultado\n\nEl galo "+galo.getNombre()+" se quedo sin fuerza, "+romano.getNombre()+" gana el combate");
                    resultado = false;
                }
            }
            else{
                if (romano.getCantidadDeDientes() < 0){
                    System.out.println("\nResultado\n\nEl romano "+romano.getNombre()+" fue derrotado por que quedo sin dientes");
                }
                else{
                    if (romano.getNivelDeSalud() < 1){
                        System.out.println("\nResultado\n\nEl romano "+romano.getNombre()+" fue derrotado por que quedo sin vida");
                    }
                }
                resultado = false;
            }

        }
    }

    public String toStringCombate(Galo galo, Romano romano, int contadorCombate, int poderGalo){
        return "Combate "+contadorCombate+" - "+ galo.getNombre()+" con "+poderGalo+" de poder ataca a "+romano.getNombre()+
                " que queda con "+romano.getCantidadDeDientes()+" dientes y "+romano.getNivelDeSalud()+" de salud";
    }

}

