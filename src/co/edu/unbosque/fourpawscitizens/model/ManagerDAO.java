/**
 * package that contains the class
 */
package co.edu.unbosque.fourpawscitizens.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ManagerDAO class.
 * This class contains the DAO a part of the program that create, read, update and delete.
 *
 * @authors (- Jhoan Ricardo Cuevas Patiño
 *           - Juan Felipe Rojas Rodríguez)
 */
public class ManagerDAO {
    /**
     * alPet is type ArrayList<PetDTO>
     */
    ArrayList<PetDTO> alPet;
    /**
     * alPetId is type ArrayList<PetDTO>
     */
    ArrayList<PetDTO> alPetId;

    /**
     * constructor of the class that inicializate the ArrayList.
     */
    public ManagerDAO() {

        alPet = new ArrayList<PetDTO>();
        alPetId = new ArrayList<PetDTO>();
    }

    /**
     * This method find in the archive all data, if the microchip is alphanumeric that data
     * will not be add to the ArrayList but if have only numbers will be added to the ArrayList.
     *
     * @return atrribute back with a pharase that is completly loaded.
     */
    public String uploadData() {
        String bookmark = ";";
        String back = "";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/data/pets-citizens.csv"));
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
                        if ("SI".equals(space[4])) {
                            pet.setPotentDangerous(true);
                        } else {
                            pet.setPotentDangerous(false);
                        }
                        pet.setNeighborhood(space[5]);
                        alPet.add(pet);
                    } catch (NumberFormatException e) {
                    }
                }
                line = bufferedReader.readLine();
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            back = "The loading process of the document is totally successful.";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return back;
    }

    /**
     * This method assign an ID for every pet in the list the last 3 digits of the microchip.
     * If repeated the method add another digit.
     *
     * @return an attribute type String saying all ID's is successfully assigned.
     */
    public String assignID() {
        String back = "";

        for (int i = 0; i < alPet.size(); i++) {
            String pId;
            String pMicrochip = String.valueOf(alPet.get(i).getMicrochip());
            String pSpecies = alPet.get(i).getSpecies();
            String pSex = alPet.get(i).getSex();
            String pSize = alPet.get(i).getSize().toString();
            String pDangerous;
            String pNeighborhood = alPet.get(i).getNeighborhood();

            pMicrochip = pMicrochip.substring(pMicrochip.length() - 3, pMicrochip.length());
            pSex = pSex.substring(0, 1);
            pSpecies = pSpecies.substring(0, 1);

            switch (pSize) {

                case "MINIATURA":
                    pSize = "MI";
                    break;

                case "GIGANTE":
                    pSize = "GI";
                    break;

                case "PEQUE�O":
                    pSize = "P";
                    break;

                case "MEDIANO":
                    pSize = "M";
                    break;

                case "GRANDE":
                    pSize = "G";
                    break;

                case "MUY GRANDE":
                    pSize = "MG";
                    break;

                default:
                    pSize = "0000000000000000000000000000000000000";
            }

            if (alPet.get(i).isPotentDangerous()) {
                pDangerous = "T";
            } else {
                pDangerous = "F";
            }
            pId = pMicrochip + "-" + pSex + pSpecies + pSize + pDangerous + "-" + pNeighborhood;

            if (alPetId.size() != 0) {
                for (int j = 0; j < alPetId.size(); j++) {
                    int size = pMicrochip.length();
                    String chip = String.valueOf(alPet.get(i).getMicrochip());
                    int normalSize = chip.length();
                    if (pId.equals(alPetId.get(j).getId()) && normalSize != size) {
                        pMicrochip = chip.substring(normalSize - (size + 1), normalSize);
                        pId = pMicrochip + "-" + pSex + pSpecies + pSize + pDangerous + "-" + pNeighborhood;
                    }
                }
            }

            PetDTO pet = new PetDTO(pId, alPet.get(i).getMicrochip(), alPet.get(i).getSpecies(), alPet.get(i).getSex(),
                    alPet.get(i).getSize(), alPet.get(i).isPotentDangerous(), alPet.get(i).getNeighborhood());
            alPetId.add(pet);

            back = "The assignation process of the I.D's is totally successful.";
        }
        return back;
    }

    /**
     * This method find a pet with the number of microchip if is same will show all
     * data of the pet.
     * <pre>the user write the number.</pre>
     * <post>the user will see the pet with that microchip.</post>
     *
     * @param microchip type long and microchip != 0.
     * @return pet type String showing all data of the pet founded by microchip.
     */
    public String findByMicrochip(long microchip) {

        String pet = "";

        for (int i = 0; i < alPet.size(); i++) {

            if (microchip == alPet.get(i).getMicrochip()) {

                pet = "" + alPet.get(i).toString() + "\n";
            }
        }
        return pet;
    }

    /**
     * This method count the species what the user want.
     * <pre>the user write the specie to show.</pre>
     * <post>the user will see the number of that species</post>
     *
     * @param species is type String and species != null.
     * @return species type String and a with the name of the species and number.
     */
    public String countBySpecies(String species) {
        int a = 0;
        for (int i = 0; i < alPet.size(); i++) {
            if (species.equals(alPet.get(i).getSpecies())) {
                a++;
            }
        }
        return "The number of " + species + " is: " + a;
    }

    /**
     * This method find by all pets dangerous in the neighbourhood
     * and the position de user want top/last.
     *
     * <pre>the user write the number of dangerous pets he want to see.</pre>
     * <post>The user will the number of pets that is potentially dangerous.</post>
     *
     * @param n            is type int and n != 0.
     * @param position     is type String and position != null.
     * @param neighborhood is type String and neighborhood != null.
     * @return pet type String with the numbers of pets the users wants see and
     * with the information complete about the pet.
     */
    public String findBypotentDangerousInNeighborhood(int n, String position, String neighborhood) {

        String pet = "";
        int a = 0;
        ArrayList<PetDTO> alDangerous = new ArrayList<PetDTO>();

        for (int i = 0; i < alPetId.size(); i++) {
            if (neighborhood.equals(alPetId.get(i).getNeighborhood()) && alPetId.get(i).isPotentDangerous()) {

                alDangerous.add(alPetId.get(i));
            }
        }

        if (n <= alDangerous.size()) {
            if ("TOP".equals(position)) {
                for (int i = 0; i < n; i++) {

                    pet = pet + alDangerous.get(i).toString() + "\n";
                }
            } else {
                for (int i = alDangerous.size() - 1; (alDangerous.size() - n) <= i; i--) {

                    pet = pet + alDangerous.get(i).toString() + "\n";
                }
            }
        } else {

            pet = "Superado";
        }
        return pet;
    }

    /**
     * This method find the pet with multiple attributes and show them if all what user
     * write is correct.
     *
     * <pre>The user write the different characteristics of the pet to find the multiple ID's.</pre>
     * <post>Will show all pet ID's whit same characteristics.</post>
     *
     * @param sex          is type String and sex != null.
     * @param species      is type String and position != null.
     * @param size         is type String and neighborhood != null.
     * @param potentDanger is type String and potentDanger != null.
     * @return pet type String with the ID's with the same characteristics.
     */
    public String findByMultipleFields(String sex, String species, String size, String potentDanger) {

        String pet = "";

        for (int i = 0; i < alPetId.size(); i++) {

            if (sex.equals(alPetId.get(i).getSex()) && species.equals(alPetId.get(i).getSpecies()) && size.equals(alPetId.get(i).getSize())) {

                if ("SI".equals(potentDanger)) {

                    pet += alPetId.get(i).getId() + "\n";
                } else {

                    pet += alPetId.get(i).getId() + "\n";
                }
            }
        }
        return pet;
    }

}
