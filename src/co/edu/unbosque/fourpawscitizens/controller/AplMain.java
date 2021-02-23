package co.edu.unbosque.fourpawscitizens.controller;

import co.edu.unbosque.fourpawscitizens.model.ManagerDAO;

import javax.swing.*;
import java.util.Scanner;

public class AplMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ManagerDAO managerDAO = new ManagerDAO();

        System.out.println(managerDAO.uploadData());
        System.out.println(managerDAO.assignID());

        String seleccion = "SI";

        do {

            String informacion = "Señor usuario, por favor ingrese el número de la opción que desea realizar.\n" +
                    "[1] Mostrar mascota por número de microchip.\n" +
                    "[2] Cantidad de mascotas por especie.\n" +
                    "[3] Mascotas potencialmente peligrosas según su localidad.\n" +
                    "[4] Id de las mascotas segun sus caracteristicas.\n" +
                    "[5] Salir";

            System.out.println(informacion);

            String numero = sc.nextLine();

            switch (numero) {

                case "1":

                    System.out.println("Por favor ingrese el microchip de su mascota.");

                    long pMicrochip = sc.nextLong();
                    System.out.println(managerDAO.findByMicrochip(pMicrochip));

                    break;

                case "2":

                    System.out.println("Por favor ingrese la especie.");

                    String pEspecie = sc.nextLine().toUpperCase();
                    System.out.println(managerDAO.countBySpecies(pEspecie));

                    break;

                case "3":

                    System.out.println("Por favor el ingrese el numero mascotas potencialmente peligrosas que desea ver.");

                    int pN = sc.nextInt();

                    System.out.println("Si desea ver los primeros " + pN + " mascotas, escriba: TOP.\n" +
                            "Si desea ver los ultimos " + pN + " mascotas, escriba: LAST");

                    String pPosition = sc.nextLine().toUpperCase();

                    System.out.println("Por favor el ingrese la localidad.");

                    String pNeighborhood = sc.nextLine().toUpperCase();

                    System.out.println(managerDAO.findBypotentDangerousInNeighborhood(pN, pPosition, pNeighborhood));

                    break;

                case "4":

                    System.out.println("Por favor ingrese la especie de la moscota.");

                    String pEspecie2 = sc.nextLine().toUpperCase();

                    System.out.println("Por favor ingrese el sexo de la mascota.");

                    String pSex = sc.nextLine().toUpperCase();

                    System.out.println("Por favor ingrese el tamaño de la mascota");

                    String pSize = sc.nextLine().toUpperCase();

                    System.out.println("Si la mascota es potencialmente peligrosa escriba: SI\n" +
                            "Si la mascota no es potencialmente peligrosa escriba: NO");

                    String pPotentDangerous = sc.nextLine().toUpperCase();

                    System.out.println(managerDAO.findByMultipleFields(pSex, pEspecie2, pSize, pPotentDangerous));

                    break;

                case "5":

                    seleccion = "NO";

                    break;

                default:

                    System.out.println("Señor usuario, por favor ingrese un numero de las lista.");

                    break;
            }


        } while ("SI".equals(seleccion.toUpperCase()));
    }
}
