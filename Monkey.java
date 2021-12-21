public class Monkey extends RescueAnimal {
    // Monkey specific attribues
    private Double tailLength;
    private Double height;
    private Double bodyLength;
    private String species;

    // Default constructor
    public Monkey() {
        this.tailLength = 0.0;
        this.height = 0.0;
        this.bodyLength = 0.0;
        this.species = "none";
    }

    // Advanced constructor to initilize all attributes at once
    public Monkey(String name, String type, String gender, String age, String weight, String acquisitionDate,
            String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry,
            Double tailLength, Double height, Double bodyLength, String species) {
        setName(name);
        setAnimalType(type);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);
    }

    // Main method
    public static void main(String[] args) {

    }

    // Setter for tail length
    public void setTailLength(Double tailLength) {
        this.tailLength = tailLength;
    }

    // Getter for tail length
    public Double getTailLength() {
        return tailLength;
    }

    // Setter for height
    public void setHeight(Double height) {
        this.height = height;
    }

    // Getter for height
    public Double getHeight() {
        return height;
    }

    // Setter for body length
    public void setBodyLength(Double bodyLength) {
        this.bodyLength = bodyLength;
    }

    // Getter for body length
    public Double getBodyLength() {
        return bodyLength;
    }

    // Setter for species
    public void setSpecies(String species) {
        this.species = species;
    }

    // Getter for species
    public String getSpecies() {
        return species;
    }
}
