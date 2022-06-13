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
        if (detectiveName.equals("SarahSalwitt")) {
            this.detectiveName = detectiveName;
            GoodCop();
        } else { /* detectiveName == "DoctorDormitory" */
            this.detectiveName = detectiveName;
            BadCop();
        }
    }

    /**
     * Creates detective 0
     */
    private void GoodCop() {
        this.detectiveKind = 0;
    }

    /**
     * Creates detective 1
     */
    private void BadCop() {
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
