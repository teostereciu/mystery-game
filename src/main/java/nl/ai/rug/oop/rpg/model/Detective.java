package nl.ai.rug.oop.rpg.model;

/**
 * @Author Daniël
 */
public class Detective {
    private int detectiveKind;
    private String detectiveName;

    public Detective(String detectiveName){
        if (detectiveName.equals("Sarah Salwitt")) {
            this.detectiveName = detectiveName;
            SarahSalwitt();
        } else { /* detectiveName == "Doctor Dormitory" */
            this.detectiveName = detectiveName;
            DoctorDormitory();
        }
    }

    private void SarahSalwitt() {
        this.detectiveKind = 1;
    }

    public String getDetectiveName() {return detectiveName; }
    private void DoctorDormitory() {
        this.detectiveKind = 2;
    }
}
