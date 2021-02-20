package co.edu.unbosque.fourpawscitizens.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ManagerDAO {


    ArrayList<PetDTO> alPet;

    public ManagerDAO() {

        alPet = new ArrayList<PetDTO>();
        uploadData();

        for (int i = 0; i < alPet.size(); i++) {

            System.out.println(alPet.get(i).getMicrochip());
        }
    }

    public void uploadData() {

        String bookmark = ";";
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\cueva\\FourPawsCitizens\\src\\data\\pets-citizens.csv"));

            String line = bufferedReader.readLine();

            while (line != null) {

                PetDTO pet = new PetDTO();
                String[] space = line.split(bookmark);

                if (space.length == 6) {

                    pet.setId("0");
                    try {

                        pet.setMicrochip(Long.parseLong(space[0]));
                        pet.setSpecies(space[1]);
                        pet.setSex(space[2]);
                        pet.setSize(space[3]);
                        pet.setPotentDangerous(Boolean.parseBoolean(space[4]));
                        pet.setNeighborhood(space[5]);
                        alPet.add(pet);
                    } catch (NumberFormatException e) {
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
