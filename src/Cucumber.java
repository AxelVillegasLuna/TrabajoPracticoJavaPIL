public class Cucumber extends Ingrediente{
    public Cucumber(Galo galo){
        galo.setAstucia(1);
        System.out.println("Cucumber");
        System.out.println("Astucia: " + galo.getAstucia());
    }
}
