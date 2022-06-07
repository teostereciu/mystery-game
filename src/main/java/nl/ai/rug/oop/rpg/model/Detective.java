package nl.ai.rug.oop.rpg.model;

/**
 * @Author Daniël
 */
public class Detective {
    private int detectiveKind;
    private String detectiveName;

    /**
     * Makes a new instance of the object detective
     * @param detectiveName which detective is chosen
     */
    public Detective(String detectiveName){
        if (detectiveName.equals("Sarah Salwitt")) {
            this.detectiveName = detectiveName;
            SarahSalwitt();
        } else { /* detectiveName == "Doctor Dormitory" */
            this.detectiveName = detectiveName;
            DoctorDormitory();
        }
    }

    /**
     * Creates detective 0
     */
    private void SarahSalwitt() {
        this.detectiveKind = 0;
    }

    /**
     * Creates detective 1
     */
    private void DoctorDormitory() {
        this.detectiveKind = 1;
    }

    /**
     * @return the name of the detective
     */
    public String getDetectiveName() {return detectiveName; }

    /**
     * @return the number of the detective
     */
    public int getDetectiveKind() {return detectiveKind; }
}
