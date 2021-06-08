public class DulceDeLeche extends Ingrediente{

    public DulceDeLeche(Galo galo){
        galo.setAstucia(2);
        galo.setFuerza(10);
        System.out.println("Dulce de leche");
        System.out.println("Fuerza: " + galo.getFuerza());
        System.out.println("Astucia: " + galo.getAstucia());
    }
}
