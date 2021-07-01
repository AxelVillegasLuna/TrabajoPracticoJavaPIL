import modelos.Galo;
import modelos.Romano;
import persistenciaDatos.DatosGalo;
import persistenciaDatos.DatosRomano;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Inicializamos los objetos de persistencia
        DatosGalo datosGalo = new DatosGalo();
        DatosRomano datosRomano = new DatosRomano();
        // Creamos las tablas
        datosGalo.crearTablaGalos();
        datosRomano.crearTablaRomanos();
        // Cargamos las tablas con los datos
        datosGalo.cargarGalos();
        datosRomano.cargarRomanos();

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
        while (flagMenu) {
            int opcion;
            System.out.println("1- Seleccionar un galo");
            System.out.println("2- Crear un galo");
            System.out.println("3- Salir");
            System.out.print("Ingrese opción: ");
            opcion = sc.nextInt();
            if (opcion < 1 || opcion > 3) {
                System.out.print("\nIngrese una opción válida\n\n");
            } else {
                if (opcion == 1) {
                    // Jugar con galo traído de la DB
                    datosGalo.obtenerGalos();
                    System.out.print("\nIngrese número del Galo: ");
                    int galoDB = sc.nextInt();
                    Galo galo = datosGalo.obtenerGaloEspecifico(galoDB);
                    while (galo == null) {
                        datosGalo.obtenerGalos();
                        System.out.print("\nERROR! Ingrese una opción válida\n");
                        System.out.print("\nIngrese número del Galo: ");
                        galoDB = sc.nextInt();
                        galo = datosGalo.obtenerGaloEspecifico(galoDB);
                    }
                    while (flagMenu) {
                        System.out.println("1- Seleccionar romano");
                        System.out.println("2- Crear romano");
                        System.out.println("3- Salir");
                        System.out.print("Ingrese opción: ");
                        opcion = sc.nextInt();

                        if (opcion < 1 || opcion > 3) {
                            System.out.print("\nIngrese una opción válida\n\n");
                        } else {
                            if (opcion == 1) {
                                // Jugar con romano traído de la DB
                                datosRomano.obtenerRomanos();
                                System.out.print("\nIngrese número del Romano: ");
                                int romanoDB = sc.nextInt();
                                Romano romano = datosRomano.obtenerRomanoEspecifico(romanoDB);
                                while (romano == null) {
                                    datosRomano.obtenerRomanos();
                                    System.out.print("\nERROR! Ingrese una opción válida\n");
                                    System.out.print("\nIngrese número del Romano: ");
                                    romanoDB = sc.nextInt();
                                    romano = datosRomano.obtenerRomanoEspecifico(romanoDB);
                                }
                                galo.mostrarInformacionGalo(galo);
                                romano.mostrarInformacionRomano(romano);
                                galo.atacarRomano(galo, romano);

                                while (flagMenu) {
                                    System.out.println("1- Seguir atacando");
                                    System.out.println("2- Beber posión");
                                    System.out.println("3- Salir");
                                    System.out.print("Ingrese opción: ");
                                    opcion = sc.nextInt();

                                    if (opcion < 1 || opcion > 3) {
                                        System.out.print("\nIngrese una opción válida\n\n");
                                    } else {
                                        if (opcion == 1) {
                                            galo.mostrarInformacionGalo(galo);
                                            romano.mostrarInformacionRomano(romano);
                                            galo.atacarRomano(galo, romano);
                                        } else if (opcion == 2) {
                                            galo.tomarPosion(galo);
                                        } else {
                                            // Se termina el juego
                                            System.out.println("¡GAME OVER!");
                                            flagMenu = false;
                                        }
                                    }
                                }
                            } else if (opcion == 2) {
                                // Jugar con romano creado por el jugador
                                System.out.print("\nIngrese nombre del Romano: ");
                                String nombreRomano = sc.next();
                                Romano romano = new Romano(nombreRomano);
                                datosRomano.guardarRomano(romano.getNombre(), romano.getCantidadDeDientes(), romano.getNivelDeSalud());
                                galo.mostrarInformacionGalo(galo);
                                romano.mostrarInformacionRomano(romano);
                                galo.atacarRomano(galo, romano);
                                while (flagMenu) {
                                    System.out.println("1- Seguir atacando");
                                    System.out.println("2- Beber posión");
                                    System.out.println("3- Salir");
                                    System.out.print("Ingrese opción: ");
                                    opcion = sc.nextInt();

                                    if (opcion < 1 || opcion > 3) {
                                        System.out.print("\nIngrese una opción válida\n\n");
                                    } else {
                                        if (opcion == 1) {
                                            galo.mostrarInformacionGalo(galo);
                                            romano.mostrarInformacionRomano(romano);
                                            galo.atacarRomano(galo, romano);
                                        } else if (opcion == 2) {
                                            galo.tomarPosion(galo);
                                        } else {
                                            // Se termina el juego
                                            System.out.println("¡GAME OVER!");
                                            flagMenu = false;
                                        }
                                    }
                                }
                            } else {
                                // Se termina el juego
                                System.out.println("¡GAME OVER!");
                                flagMenu = false;
                            }
                        }
                    }

                } else if (opcion == 2) {
                    // Jugar con galo creado por el jugador
                    System.out.print("Ingrese nombre del Galo: ");
                    String nombreGalo = sc.next();
                    Galo galo = new Galo(nombreGalo);
                    datosGalo.guardarGalo(galo.getNombre(), galo.getAstucia(), galo.getFuerza());

                    while (flagMenu) {
                        System.out.println("1- Seleccionar romano");
                        System.out.println("2- Crear romano");
                        System.out.println("3- Salir");
                        System.out.print("Ingrese opción: ");
                        opcion = sc.nextInt();

                        if (opcion < 1 || opcion > 3) {
                            System.out.print("\nIngrese una opción válida\n\n");
                        } else {
                            if (opcion == 1) {
                                // Jugar con romano traído de la DB
                                datosRomano.obtenerRomanos();
                                System.out.println("\nIngrese número del Romano: ");
                                int romanoDB = sc.nextInt();
                                Romano romano = datosRomano.obtenerRomanoEspecifico(romanoDB);
                                while (romano == null) {
                                    datosRomano.obtenerRomanos();
                                    System.out.print("\nERROR! Ingrese una opción válida\n");
                                    System.out.print("\nIngrese número del Romano: ");
                                    romanoDB = sc.nextInt();
                                    romano = datosRomano.obtenerRomanoEspecifico(romanoDB);
                                }
                                galo.mostrarInformacionGalo(galo);
                                romano.mostrarInformacionRomano(romano);
                                galo.atacarRomano(galo, romano);

                                while (flagMenu) {
                                    System.out.println("1- Seguir atacando");
                                    System.out.println("2- Beber posión");
                                    System.out.println("3- Salir");
                                    System.out.print("Ingrese opción: ");
                                    opcion = sc.nextInt();

                                    if (opcion < 1 || opcion > 3) {
                                        System.out.print("\nIngrese una opción válida\n\n");
                                    } else {
                                        if (opcion == 1) {
                                            galo.mostrarInformacionGalo(galo);
                                            romano.mostrarInformacionRomano(romano);
                                            galo.atacarRomano(galo, romano);
                                        } else if (opcion == 2) {
                                            galo.tomarPosion(galo);
                                        } else {
                                            // Se termina el juego
                                            System.out.println("¡GAME OVER!");
                                            flagMenu = false;
                                        }
                                    }
                                }
                            } else if (opcion == 2) {
                                // Jugar con romano creado por el jugador
                                System.out.print("\nIngrese nombre del Romano: ");
                                String nombreRomano = sc.next();
                                Romano romano = new Romano(nombreRomano);
                                datosRomano.guardarRomano(romano.getNombre(), romano.getCantidadDeDientes(), romano.getNivelDeSalud());
                                galo.mostrarInformacionGalo(galo);
                                romano.mostrarInformacionRomano(romano);
                                galo.atacarRomano(galo, romano);
                                while (flagMenu) {
                                    System.out.println("1- Seguir atacando");
                                    System.out.println("2- Beber posión");
                                    System.out.println("3- Salir");
                                    System.out.print("Ingrese opción: ");
                                    opcion = sc.nextInt();

                                    if (opcion < 1 || opcion > 3) {
                                        System.out.print("\nIngrese una opción válida\n\n");
                                    } else {
                                        if (opcion == 1) {
                                            galo.mostrarInformacionGalo(galo);
                                            romano.mostrarInformacionRomano(romano);
                                            galo.atacarRomano(galo, romano);
                                        } else if (opcion == 2) {
                                            galo.tomarPosion(galo);
                                        } else {
                                            // Se termina el juego
                                            System.out.println("¡GAME OVER!");
                                            flagMenu = false;
                                        }
                                    }
                                }
                            } else {
                                // Se termina el juego
                                System.out.println("¡GAME OVER!");
                                flagMenu = false;
                            }
                        }
                    }

                } else {
                    // Se termina el juego
                    System.out.println("¡GAME OVER!");
                    flagMenu = false;
                }
            }
        }
    }
}

