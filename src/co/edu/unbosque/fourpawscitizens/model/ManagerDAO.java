package co.edu.unbosque.fourpawscitizens.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ManagerDAO {

    ArrayList<PetDTO> alPet;
    ArrayList<PetDTO> alPetId;

    public ManagerDAO() {

        alPet = new ArrayList<PetDTO>();
        alPetId = new ArrayList<PetDTO>();
        uploadData();
        assingID();
        for (int i = 0; i < alPetId.size(); i++) {

            System.out.println(alPetId.get(i).getId());
        }
    }

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
            back = "El proceso de carga del archivo ha finalizado";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return back;
    }

    public String assingID() {
        String back = "";

        for (int i = 0; i < alPet.size(); i++) {
            String pId;
            String pMicrochip = String.valueOf(alPet.get(i).getMicrochip());
            String pSpecies = alPet.get(i).getSpecies();
            String pSex = alPet.get(i).getSex();
            String pSize = alPet.get(i).getSize();
            String pDangerous;
            String pNeighborhood = alPet.get(i).getNeighborhood();

            pMicrochip = pMicrochip.substring(pMicrochip.length() - 3, pMicrochip.length());
            pSex = pSex.substring(0, 1);
            pSpecies = pSpecies.substring(0, 1);
            pSize = pSize.substring(0, 1);

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

            back = "El proceso de asignación de ids ha finalizado";
        }
        return back;
    }

    public String findByMicrochip(long pMicrochip) {

        PetDTO pet = new PetDTO();

        for (int i = 0; i < alPetId.size(); i++) {

            if (pMicrochip == alPetId.get(i).getMicrochip()) {

                pet = alPetId.get(i);
            }
        }

        return pet.toString();
    }

}
