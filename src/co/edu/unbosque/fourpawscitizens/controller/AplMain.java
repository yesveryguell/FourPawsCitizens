package co.edu.unbosque.fourpawscitizens.controller;

import co.edu.unbosque.fourpawscitizens.model.ManagerDAO;

import javax.swing.*;
import java.util.Scanner;

public class AplMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagerDAO managerDAO = new ManagerDAO();

        System.out.println("sex, especie, ");

        String sex = "HEMBRA";
        String species = "CANINO";
        String size = "MINIATURA";
        String potentDanger = "NO";

       System.out.println(managerDAO.findByMultipleFields(sex, species, size, potentDanger));
    }
}
