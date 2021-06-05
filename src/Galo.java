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

    public int getAstucia() {
        return astucia;
    }

    public int getFuerza() {
        return fuerza;
    }
}
