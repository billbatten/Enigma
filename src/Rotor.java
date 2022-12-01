public class Rotor {

    public String rotorNumber;
    public int ringSetting;
    public int currentLetter;
    public int notchPosition;
    public String rotorConfiguration;

    public Rotor(String rotorNumber, String rotorConfiguration , int ringSetting, int currentLetter, int notchPosition) {
        this.rotorNumber = rotorNumber;
        this.ringSetting = ringSetting;
        this.currentLetter = currentLetter;
        this.rotorConfiguration = rotorConfiguration;
        this.notchPosition = notchPosition;
    }

    public static Rotor ConstructRotor(String rotorNumber, int ringSetting, int currentLetter){
        switch(rotorNumber){
            case "I":
                return new Rotor(rotorNumber, "EKMFLGDQVZNTOWYHXUSPAIBRCJ", ringSetting, currentLetter, 16);
            case "II":                                     //ABCDEFGHIJKLMNOPQRSTUVWYXZ
                return new Rotor(rotorNumber,"AJDKSIRUXBLHWTMCQGZNPYFVOE", ringSetting, currentLetter, 4);
            case "III":                                   //ABCDEFGHIJKLMNOPQRSTUVWYXZ
                return new Rotor(rotorNumber,"BDFHJLCPRTXVZNYEIWGAKMUSQO", ringSetting, currentLetter, 21);
            case "IV":                                    //ABCDEFGHIJKLMNOPQRSTUVWYXZ
                return new Rotor(rotorNumber,"ESOVPZJAYQUIRHXLNFTGKDCMWB", ringSetting, currentLetter, 9);
            case "V":                                     //ABCDEFGHIJKLMNOPQRSTUVWYXZ
                return new Rotor(rotorNumber,"VZBRGITYUPSDNHLXAWMJQOFECK", ringSetting, currentLetter, 25);
                                                          //ABCDEFGHIJKLMNOPQRSTUVWYXZ
        }
        return null;
    }
    
    public void moveRotor() {
        this.currentLetter = (this.currentLetter + 1) % 26;

    }

    public boolean notchHit() {
        return this.currentLetter == this.notchPosition;
    }


}
