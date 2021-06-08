public class PetraOleum extends Ingrediente{
    private int valores [] = {2, 4, 6};
    private int indiceRandom = (int) (Math.random() * 2);
    private int cm3 = valores[indiceRandom];

    public PetraOleum(Galo galo){
        switch(this.cm3) {
            case 2:
                galo.setFuerza(2);
                System.out.println("PetraOleum");
                System.out.println("Fuerza: " + galo.getFuerza());
                break;
            case 4:
                galo.setFuerza(4);
                System.out.println("PetraOleum");
                System.out.println("Fuerza: " + galo.getFuerza());
                break;
            case 6:
                galo.setFuerza(6);
                System.out.println("PetraOleum");
                System.out.println("Fuerza: " + galo.getFuerza());
                break;
            default:
                galo.setFuerza(0);
        }

    }

}
