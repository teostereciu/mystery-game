package nl.ai.rug.oop.rpg.model;

/**
 * @Author Daniël
 */
public class Detective {
    private int detectiveKind;

    public Detective(String detectiveName){
        if (detectiveName.equals("Sarah Salwitt")) {
            SarahSalwitt();
        } else { /* detectiveName == "Doctor Dormitory" */
            DoctorDormitory();
        }
    }

    private void SarahSalwitt() {
        this.detectiveKind = 1;
    }

    private void DoctorDormitory() {
        this.detectiveKind = 2;
    }
}
