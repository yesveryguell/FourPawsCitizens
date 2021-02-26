package co.edu.unbosque.fourpawscitizens.controller;

import co.edu.unbosque.fourpawscitizens.model.ManagerDAO;

import javax.swing.*;
import java.util.Scanner;

public class AplMain {

    public static void main(String[] args) {


        ManagerDAO managerDAO = new ManagerDAO();

        System.out.println("\n" + managerDAO.uploadData() + "\n");
        System.out.println(managerDAO.assignID() + "\n");

        String seleccion = "SI";

        do {
            try {

                String informacion = "Señor usuario, por favor ingrese el número de la opción que desea realizar.\n" +
                        "[1] Mostrar mascota por número de microchip.\n" +
                        "[2] Cantidad de mascotas por especie.\n" +
                        "[3] Mascotas potencialmente peligrosas según su localidad.\n" +
                        "[4] Id de las mascotas segun sus caracteristicas.\n" +
                        "[5] Salir";

                System.out.println(informacion);

                Scanner sc3 = new Scanner(System.in);
                int numero = sc3.nextInt();

                switch (numero) {

                    case 1:

                        System.out.println("Por favor ingrese el microchip de su mascota.");
                        int ex = 0;
                        do {
                            try {
                                Scanner sc2 = new Scanner(System.in);
                                long pMicrochip = sc2.nextLong();
                                String mensaje = managerDAO.findByMicrochip(pMicrochip);

                                if (!"".equals(mensaje)) {
                                    System.out.println(mensaje);
                                    ex = 0;
                                } else {
                                    ex = 1;
                                }
                            } catch (Exception e) {
                                ex = 1;
                            }

                            if (ex == 1) {
                                System.out.println("Señor usuario, el microship no fue encontrado.\nRecuerde que este solo debe contener caracteres numericos." +
                                        "\nPor favor ingrese el microchip de su mascota de nuevo.");
                            }

                        } while (ex == 1);

                        break;

                    case 2:

                        System.out.println("Por favor ingrese la especie.");
                        String pEspecie;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pEspecie = sc2.nextLine().toUpperCase();

                            if ("CANINO".equals(pEspecie) || "FELINO".equals(pEspecie)) {

                                System.out.println(managerDAO.countBySpecies(pEspecie));
                            } else {
                                System.out.println("Señor usuario, recuerde que solo existe dos especies(Felino y Canino)." +
                                        "\nPor favor ingrese la especie de nuevo.");
                            }

                        } while (!"CANINO".equals(pEspecie) && !"FELINO".equals(pEspecie));

                        break;

                    case 3:
                        System.out.println("Por favor el ingrese el numero mascotas potencialmente peligrosas que desea ver.");
                        int ex2 = 0;
                        int pN = 0;
                        do {

                            try {
                                Scanner sc2 = new Scanner(System.in);
                                pN = sc2.nextInt();
                                ex2 = 0;

                            } catch (Exception e) {
                                ex2 = 1;
                            }

                            if (ex2 == 1) {
                                System.out.println("Señor usuario ah escrito un caracter no valido\n" +
                                        "\nPor favor el ingrese el numero mascotas potencialmente peligrosas que desea ver.");
                            }

                        } while (ex2 == 1);

                        System.out.println("Si desea ver los/las primeros/primeras " + pN + " mascotas, escriba: TOP.\n" +
                                "Si desea ver los/las ultimos/ultimas " + pN + " mascotas, escriba: LAST");
                        String pPosition;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pPosition = sc2.nextLine().toUpperCase();

                            if (!"TOP".equals(pPosition) && !"LAST".equals(pPosition)) {

                                System.out.println("Señor usuario, recuerde que solo existe dos opciones(TOP y LAST)." +
                                        "\nSi desea ver los/las primeros/primeras " + pN + " mascotas, escriba: TOP.\n" +
                                        "Si desea ver los/las ultimos/ultimas " + pN + " mascotas, escriba: LAST");
                            }

                        } while (!"LAST".equals(pPosition) && !"TOP".equals(pPosition));


                        System.out.println("Por favor ingrese la localidad.");
                        String pNeighborhood;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pNeighborhood = sc2.nextLine().toUpperCase();

                            if (!"A. NARINO".equals(pNeighborhood) && !"B. UNIDOS".equals(pNeighborhood) && !"BOSA".equals(pNeighborhood)
                                    && !"C. BOLIVAR".equals(pNeighborhood) && !"CHAPINERO".equals(pNeighborhood) && !"ENGATIVA".equals(pNeighborhood)
                                    && !"FONTIBON".equals(pNeighborhood) && !"KENNEDY".equals(pNeighborhood) && !"LA CANDELARIA".equals(pNeighborhood)
                                    && !"LA CANDELARIA".equals(pNeighborhood) && !"LOS MARTIRES".equals(pNeighborhood) && !"MUNICIPIOS ALEDA�OS BOGOTA D.C.".equals(pNeighborhood)
                                    && !"P. ARANDA".equals(pNeighborhood) && !"R. URIBE".equals(pNeighborhood) && !"SAN CRISTOBAL".equals(pNeighborhood) && !"SANTA FE".equals(pNeighborhood)
                                    && !"SIN IDENTIFICAR".equals(pNeighborhood) && !"SUBA".equals(pNeighborhood) && !"SUMAPAZ".equals(pNeighborhood) && !"TEUSAQUILLO".equals(pNeighborhood)
                                    && !"TUNJUELITO".equals(pNeighborhood) && !"USAQUEN".equals(pNeighborhood) && !"USME".equals(pNeighborhood)) {

                                System.out.println("Señor usuario, la localidad no fue encontrada." +
                                        "\nPor favor el ingrese la localidad de nuevo.");
                            } else {

                                System.out.println(managerDAO.findBypotentDangerousInNeighborhood(pN, pPosition, pNeighborhood));
                            }

                        } while (!"A. NARINO".equals(pNeighborhood) && !"B. UNIDOS".equals(pNeighborhood) && !"BOSA".equals(pNeighborhood)
                                && !"C. BOLIVAR".equals(pNeighborhood) && !"CHAPINERO".equals(pNeighborhood) && !"ENGATIVA".equals(pNeighborhood)
                                && !"FONTIBON".equals(pNeighborhood) && !"KENNEDY".equals(pNeighborhood) && !"LA CANDELARIA".equals(pNeighborhood)
                                && !"LA CANDELARIA".equals(pNeighborhood) && !"LOS MARTIRES".equals(pNeighborhood) && !"MUNICIPIOS ALEDA�OS BOGOTA D.C.".equals(pNeighborhood)
                                && !"P. ARANDA".equals(pNeighborhood) && !"R. URIBE".equals(pNeighborhood) && !"SAN CRISTOBAL".equals(pNeighborhood) && !"SANTA FE".equals(pNeighborhood)
                                && !"SIN IDENTIFICAR".equals(pNeighborhood) && !"SUBA".equals(pNeighborhood) && !"SUMAPAZ".equals(pNeighborhood) && !"TEUSAQUILLO".equals(pNeighborhood)
                                && !"TUNJUELITO".equals(pNeighborhood) && !"USAQUEN".equals(pNeighborhood) && !"USME".equals(pNeighborhood));

                        break;

                    case 4:

                        System.out.println("Por favor ingrese la especie de la moscota.");
                        String pEspecie2;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pEspecie2 = sc2.nextLine().toUpperCase();

                            if ("CANINO".equals(pEspecie2) || "FELINO".equals(pEspecie2)) {
                            } else {
                                System.out.println("Señor usuario, recuerde que solo existe dos especies(Felino y Canino)." +
                                        "\nPor favor ingrese la especie de la moscota de nuevo.");
                            }
                        } while (!"CANINO".equals(pEspecie2) && !"FELINO".equals(pEspecie2));


                        System.out.println("Por favor ingrese el sexo de la mascota.");
                        String pSex;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pSex = sc2.nextLine().toUpperCase();

                            if ("MACHO".equals(pSex) || "HEMBRA".equals(pSex)) {
                            } else {
                                System.out.println("Señor usuario, recuerde que solo existe dos sexos(Macho y Hembra)." +
                                        "\nPor favor ingrese el sexo de la mascota de nuevo.");
                            }
                        } while (!"MACHO".equals(pSex) && !"HEMBRA".equals(pSex));


                        System.out.println("Por favor ingrese el tamaño de la mascota");
                        String pSize;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pSize = sc2.nextLine().toUpperCase();

                            if ("GIGANTE".equals(pSize) || "GRANDE".equals(pSize) || "MEDIANO".equals(pSize) || "MINIATURA".equals(pSize)
                                    || "MUY GRANDE".equals(pSize) || "PEQUE�O".equals(pSize)) {
                            } else {
                                System.out.println("Señor usuario, el tamaño no es valido." +
                                        "\nPor favor ingrese el tamaño de la mascota de nuevo.");
                            }
                        } while (!"GIGANTE".equals(pSize) && !"GRANDE".equals(pSize) && !"MEDIANO".equals(pSize) && !"MINIATURA".equals(pSize)
                                && !"MUY GRANDE".equals(pSize) && !"PEQUE�O".equals(pSize));


                        System.out.println("Si la mascota es potencialmente peligrosa escriba: SI\n" +
                                "Si la mascota no es potencialmente peligrosa escriba: NO");
                        String pPotentDangerous;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pPotentDangerous = sc2.nextLine().toUpperCase();

                            if ("SI".equals(pPotentDangerous) || "NO".equals(pPotentDangerous)) {

                                System.out.println(managerDAO.findByMultipleFields(pSex, pEspecie2, pSize, pPotentDangerous));
                            } else {
                                System.out.println("Señor usuario, recuerde que solo existen dos opciones(Si y No)." +
                                        "\nSi la mascota es potencialmente peligrosa escriba: SI\n" +
                                        "Si la mascota no es potencialmente peligrosa escriba: NO");
                            }
                        } while (!"SI".equals(pPotentDangerous) && !"NO".equals(pPotentDangerous));

                        break;

                    case 5:

                        seleccion = "NO";
                        break;

                    default:

                        System.out.println("Señor usuario, por favor ingrese un numero de las lista.");
                        break;
                }

            } catch (Exception e1) {

                System.out.println("A escrito un caracter no valido.");
            }
        } while ("SI".equals(seleccion.toUpperCase()));
    }
}
