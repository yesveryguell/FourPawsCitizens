/**
 * package that contains the class
 */
package co.edu.unbosque.fourpawscitizens.controller;

import co.edu.unbosque.fourpawscitizens.model.ManagerDAO;

import javax.swing.*;
import java.util.Scanner;

/**
 * AplMain class.
 * This class contains the functional part of the program that runs the methods from other classes.
 *
 * @authors : (- Jhoan Ricardo Cuevas Patiño
 *             - Juan Felipe Rojas Rodríguez)
 */
public class AplMain {

    public static void main(String[] args) {

        /**
         * this attribute called managerDAO type ManagerDAO.
         */
        ManagerDAO managerDAO = new ManagerDAO();
        /**
         * this print a message that contains inside the System.
         */
        System.out.println("\n" + managerDAO.uploadData() + "\n");
        /**
         * this print a message that contains inside the System.
         */
        System.out.println(managerDAO.assignID() + "\n");
        /**
         * this attribute called seleccion type String.
         */
        String seleccion = "SI";

        do {
            try {
                /**
                 * this attribute called informacion type String.
                 */
                String informacion = "Dear user, please write a number for the option you want to use.\n" +
                        "[1] A pet information finding with microchip.\n" +
                        "[2] The number of pets by specie.\n" +
                        "[3] Potentially dangerous pets by neighbourhood .\n" +
                        "[4] Pet's ID by characteristics.\n" +
                        "[5] Finish.";
                /**
                 * this print a message that contains inside the System.
                 */
                System.out.println(informacion);
                /**
                 * this attribute called sc3 type Scanner.
                 */
                Scanner sc3 = new Scanner(System.in);
                /**
                 * this attribute called numero type int.
                 */
                int numero = sc3.nextInt();
                /**
                 * This method, when the user give a number for choose from the menu so he can
                 * choose from 1 to 5. The number 1 find by microchip, the number 2 find by species,
                 * the number 3 find by potential dangerous, the number 4 find the characteristics of the pets.
                 * <pre>The user write the number for what he want to make.</pre>
                 * <post>The program will show the option and what he needs.</post>
                 * @param numero is the number choose the user numero is type int.
                 */
                switch (numero) {

                    case 1:

                        System.out.println("Please write the number of the microchip: ");
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
                                System.out.println("Dear user, we can't find the microchip.\n" +
                                        "Remember you only can write numbers not another type of character." +
                                        "\nPlease, rewrite the number of the microchip you gorgeous: .");
                            }

                        } while (ex == 1);

                        break;

                    case 2:

                        System.out.println("Please dear user, write the specie: ");
                        String pEspecie;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pEspecie = sc2.nextLine().toUpperCase();

                            if ("CANINO".equals(pEspecie) || "FELINO".equals(pEspecie)) {

                                System.out.println(managerDAO.countBySpecies(pEspecie));
                            } else {
                                System.out.println("Dear user, please remember only write this " +
                                        "two species --> (Felino y Canino)." +
                                        "\nPlease, rewrite the specie: ");
                            }

                        } while (!"CANINO".equals(pEspecie) && !"FELINO".equals(pEspecie));

                        break;

                    case 3:
                        System.out.println("Dear user, please write the number of pontentially " +
                                "dangerous pets you want see: .");
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
                                System.out.println("Dear user, you write a wrong chracter\n" +
                                        "\nPlease rewrite the number of the potentially dangerous pets: ");
                            }

                        } while (ex2 == 1);

                        System.out.println("Do you want to see the first " + pN + " pets, write: TOP.\n" +
                                "Do yo want to see the last " + pN + " pets, write: LAST");
                        String pPosition;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pPosition = sc2.nextLine().toUpperCase();

                            if (!"TOP".equals(pPosition) && !"LAST".equals(pPosition)) {

                                System.out.println("Dear user, please remember only write this two species -->(TOP y LAST)." +
                                        "\nDo you want to see the first " + pN + " pets, write: TOP.\n" +
                                        "Do yo want to see the last " + pN + " pets, write: LAST");
                            }

                        } while (!"LAST".equals(pPosition) && !"TOP".equals(pPosition));


                        System.out.println("Dear user, please the neighborhood: .");
                        String pNeighborhood;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pNeighborhood = sc2.nextLine().toUpperCase();

                            if (!"A. NARINO".equals(pNeighborhood) && !"B. UNIDOS".equals(pNeighborhood) && !"BOSA".equals(pNeighborhood)
                                    && !"C. BOLIVAR".equals(pNeighborhood) && !"CHAPINERO".equals(pNeighborhood) && !"ENGATIVA".equals(pNeighborhood)
                                    && !"FONTIBON".equals(pNeighborhood) && !"KENNEDY".equals(pNeighborhood) && !"LA CANDELARIA".equals(pNeighborhood)
                                    && !"LA CANDELARIA".equals(pNeighborhood) && !"LOS MARTIRES".equals(pNeighborhood)
                                    && !"MUNICIPIOS ALEDA�OS BOGOTA D.C.".equals(pNeighborhood) && !"P. ARANDA".equals(pNeighborhood)
                                    && !"R. URIBE".equals(pNeighborhood) && !"SAN CRISTOBAL".equals(pNeighborhood)
                                    && !"SANTA FE".equals(pNeighborhood) && !"SIN IDENTIFICAR".equals(pNeighborhood)
                                    && !"SUBA".equals(pNeighborhood) && !"SUMAPAZ".equals(pNeighborhood)
                                    && !"TEUSAQUILLO".equals(pNeighborhood) && !"TUNJUELITO".equals(pNeighborhood)
                                    && !"USAQUEN".equals(pNeighborhood) && !"USME".equals(pNeighborhood)) {

                                System.out.println("Dear user, we can't find your neighborhood." +
                                        "\nPlease rewrite: ");
                            } else {

                                System.out.println(managerDAO.findBypotentDangerousInNeighborhood(pN, pPosition, pNeighborhood));
                            }

                        } while (!"A. NARINO".equals(pNeighborhood) && !"B. UNIDOS".equals(pNeighborhood) && !"BOSA".equals(pNeighborhood)
                                && !"C. BOLIVAR".equals(pNeighborhood) && !"CHAPINERO".equals(pNeighborhood) && !"ENGATIVA".equals(pNeighborhood)
                                && !"FONTIBON".equals(pNeighborhood) && !"KENNEDY".equals(pNeighborhood) && !"LA CANDELARIA".equals(pNeighborhood)
                                && !"LA CANDELARIA".equals(pNeighborhood) && !"LOS MARTIRES".equals(pNeighborhood)
                                && !"MUNICIPIOS ALEDA�OS BOGOTA D.C.".equals(pNeighborhood) && !"P. ARANDA".equals(pNeighborhood)
                                && !"R. URIBE".equals(pNeighborhood) && !"SAN CRISTOBAL".equals(pNeighborhood) && !"SANTA FE".equals(pNeighborhood)
                                && !"SIN IDENTIFICAR".equals(pNeighborhood) && !"SUBA".equals(pNeighborhood) && !"SUMAPAZ".equals(pNeighborhood)
                                && !"TEUSAQUILLO".equals(pNeighborhood) && !"TUNJUELITO".equals(pNeighborhood)
                                && !"USAQUEN".equals(pNeighborhood) && !"USME".equals(pNeighborhood));

                        break;

                    case 4:

                        System.out.println("Please dear user, write the specie:");
                        String pEspecie2;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pEspecie2 = sc2.nextLine().toUpperCase();

                            if ("CANINO".equals(pEspecie2) || "FELINO".equals(pEspecie2)) {
                            } else {
                                System.out.println("");
                            }
                        } while (!"CANINO".equals(pEspecie2) && !"FELINO".equals(pEspecie2));


                        System.out.println("Por favor ingrese el sexo de la mascota.");
                        String pSex;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pSex = sc2.nextLine().toUpperCase();

                            if ("MACHO".equals(pSex) || "HEMBRA".equals(pSex)) {
                            } else {
                                System.out.println("Dear user, please remember only write this" +
                                        "two type of sex --> (hembra y macho)." +
                                        "\nPlease, rewrite the sex: ");
                            }
                        } while (!"MACHO".equals(pSex) && !"HEMBRA".equals(pSex));


                        System.out.println("Dear user, please write the size of the pet");
                        String pSize;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pSize = sc2.nextLine().toUpperCase();

                            if ("GIGANTE".equals(pSize) || "GRANDE".equals(pSize) || "MEDIANO".equals(pSize) || "MINIATURA".equals(pSize)
                                    || "MUY GRANDE".equals(pSize) || "PEQUE�O".equals(pSize)) {
                            } else {
                                System.out.println("Dear user, you wrote the wrong size." +
                                        "\nPlease rewrite the size: ");
                            }
                        } while (!"GIGANTE".equals(pSize) && !"GRANDE".equals(pSize) && !"MEDIANO".equals(pSize) && !"MINIATURA".equals(pSize)
                                && !"MUY GRANDE".equals(pSize) && !"PEQUE�O".equals(pSize));


                        System.out.println("If the pet is potentially dangerous write: SI\n" +
                                "If the pet isn't potentially dangerous write: NO");
                        String pPotentDangerous;
                        do {

                            Scanner sc2 = new Scanner(System.in);
                            pPotentDangerous = sc2.nextLine().toUpperCase();

                            if ("SI".equals(pPotentDangerous) || "NO".equals(pPotentDangerous)) {

                                System.out.println(managerDAO.findByMultipleFields(pSex, pEspecie2, pSize, pPotentDangerous));
                            } else {
                                System.out.println("Dear user, please remember only write this" +
                                        "two type of choices --> (SI y NO)." +
                                        "\nIf the pet is potentially dangerous write: SI\n" +
                                        "If the pet isn't potentially dangerous write: NO");
                            }
                        } while (!"SI".equals(pPotentDangerous) && !"NO".equals(pPotentDangerous));

                        break;

                    case 5:

                        seleccion = "NO";
                        break;

                    default:

                        System.out.println("Dear user, please write a number: ");
                        break;
                }

            } catch (Exception e1) {

                System.out.println("You wrote a wrong character.");
            }
        } while ("SI".equals(seleccion.toUpperCase()));
    }
}
