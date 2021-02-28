/**
 * package that contains the class
 */
package co.edu.unbosque.fourpawscitizens.model;

/**
 * PetDTO class.
 * This class contains the DTO mean the class have all attributes to create an object and
 * have all the attributes.
 *
 * @authors (- Jhoan Ricardo Cuevas Patiño
 *           - Juan Felipe Rojas Rodríguez)
 */
public class PetDTO {
    /**
     * id type String.
     */
    String id;
    /**
     * microchip type long.
     */
    long microchip;
    /**
     * species type String.
     */
    String species;
    /**
     * sex type String.
     */
    String sex;
    /**
     * size type String.
     */
    String size;
    /**
     * potentDangerous type boolean.
     */
    boolean potentDangerous;
    /**
     * neighborhood type String.
     */
    String neighborhood;

    /**
     * Specific constructor with all attributes and can use with other classes.
     *
     * @param id              is the type String and id != null.
     * @param microchip       is the type long and microchip != 0.
     * @param species         is the type String and species != null.
     * @param sex             is the type String and sex != null.
     * @param size            is the type String and size != null.
     * @param potentDangerous is the type boolean and potentDangerous = false v true.
     * @param neighborhood    is the type String and neighborhood != null.
     */
    public PetDTO(String id, long microchip, String species, String sex, String size, boolean potentDangerous,
                  String neighborhood) {
        super();
        this.id = id;
        this.microchip = microchip;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.potentDangerous = potentDangerous;
        this.neighborhood = neighborhood;
    }

    /**
     * Empty constructor of the class.
     */
    public PetDTO() {

    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nSpecies: " + species +
                "\nGender: " + sex +
                "\nSize: " + size +
                "\nPotentially Dangerous: " + potentDangerous +
                "\nneighborhood: " + neighborhood + "\n\n";
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the microchip
     */
    public long getMicrochip() {
        return microchip;
    }

    /**
     * @param microchip the microChip to set
     */
    public void setMicrochip(long microchip) {
        this.microchip = microchip;
    }

    /**
     * @return the species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @param species the species to set
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the potentDangerous
     */
    public boolean isPotentDangerous() {
        return potentDangerous;
    }

    /**
     * @param potentDangerous the potentDangerous to set
     */
    public void setPotentDangerous(boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
    }

    /**
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

}
