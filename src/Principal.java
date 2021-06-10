import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menu de opciones
        boolean flagMenu = true;
        System.out.println("  ###     #####   #######  ####     ######   #######  ###  ##           ####     ##                 #####     ###    ##        #####\n" +
                           " #####   ###      #######  ##       ###  ##    ###    ###  ##           ##       ##                ###       #####   ##       ###  ##\n" +
                           " ## ##    #####   #######  #####    ###  ##    ###    ###  ##           #####    ##                ### ##    ## ##   ##       ###  ##\n" +
                           "##   ##      ###    ###    ##       #######    ###      ####            ##       ##                ###  ##  ##   ##  ##       ###  ##\n" +
                           "##   ##      ###    ###    ##       ######     ###      ####            ##       ##                ###  ##  ##   ##  ##       ###  ##\n" +
                           "## ####  #######    ###    #######  ### ###  #######  #######           #######  #######           #######  ## ####  #######  #######\n" +
                           "## ####  #######    ###    #######  ### ###  #######  ###  ##           #######  #######           #######  ## ####  #######  #######\n" +
                           "## ####  ######     ###    #######  ### ###  #######  ###  ##           #######  #######            #####   ## ####  #######   #####\n");
        while(flagMenu){
            int opcion;
            System.out.println("1- Atacar un romano");
            System.out.println("3- Salir");
            System.out.print("Ingrese opción: ");
            opcion = sc.nextInt();
            if (opcion < 1 || opcion > 3){
                System.out.print("\nIngrese una opción válida\n\n");
            }
            else{
                if (opcion == 1){
                    //Punto 1
                    System.out.print("Ingrese nombre del Galo: ");
                    String nombreGalo = sc.next();
                    System.out.print("\nIngrese nombre del Romano: ");
                    String nombreRomano = sc.next();

                    Galo galo = new Galo(nombreGalo);
                    Romano romano = new Romano(nombreRomano);

                    galo.atacarRomano(galo, romano);

                    while(flagMenu)
                    {
                        System.out.println("1- Seguir atacando");
                        System.out.println("2- Beber posión");
                        System.out.println("3- Salir");
                        System.out.print("Ingrese opción: ");
                        opcion = sc.nextInt();

                        if(opcion < 1 || opcion > 3){
                            System.out.print("\nIngrese una opción válida\n\n");
                        }else{
                            if(opcion == 1){
                                galo.atacarRomano(galo, romano);
                            } else if(opcion == 2){
                                galo.tomarPosion(galo);
                            }else{
                                // Se termina el juego
                                System.out.println("¡Game Over!");
                                flagMenu = false;
                            }
                        }
                    }
                }
                else{
                    // Se termina el juego
                    System.out.println("¡Game Over!");
                    flagMenu = false;
                }
            }
        }
    }
}

