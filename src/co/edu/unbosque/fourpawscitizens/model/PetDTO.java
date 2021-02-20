package co.edu.unbosque.fourpawscitizens.model;

public class PetDTO {
	String id;
	long microChip;
	String species;
	String sex;
	String size;
	boolean potentDangerous;
	String neighborhood;

	public PetDTO(String id, long microChip, String species, String sex, String size, boolean potentDangerous,
			String neighborhood) {
		super();
		this.id = id;
		this.microChip = microChip;
		this.species = species;
		this.sex = sex;
		this.size = size;
		this.potentDangerous = potentDangerous;
		this.neighborhood = neighborhood;
	}
	public PetDTO() {
		
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
	 * @return the microChip
	 */
	public long getMicroChip() {
		return microChip;
	}

	/**
	 * @param microChip the microChip to set
	 */
	public void setMicroChip(long microChip) {
		this.microChip = microChip;
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
