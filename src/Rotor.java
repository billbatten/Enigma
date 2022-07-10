public class Rotor {

    public String rotorNumber;
    public int ringSetting;
    public int startLetter;
    public int notchPosition;
    public String rotorConfiguration;

    public Rotor(String rotorNumber, String rotorConfiguration , int ringSetting, int startLetter, int notchPosition) {
        this.rotorNumber = rotorNumber;
        this.ringSetting = ringSetting;
        this.startLetter = startLetter;
        this.rotorConfiguration = rotorConfiguration;
        this.notchPosition = notchPosition;
    }

    public static Rotor ConstructRotor(String rotorNumber, int ringSetting, int startLetter){
        switch(rotorNumber){
            case "I":
                return new Rotor("I", "EKMFLGDQVZNTOWYHXUSPAIBRCJ", ringSetting, startLetter, 16);
            case "II":
                return new Rotor("II","AJDKSIRUXBLHWTMCQGZNPYFVOE", startLetter, ringSetting, 4);
            case "III":
                return new Rotor("III","BDFHJLCPRTXVZNYEIWGAKMUSQO", startLetter, ringSetting, 21);
            case "IV":
                return new Rotor("IV","ESOVPZJAYQUIRHXLNFTGKDCMWB", startLetter, ringSetting, 9);
            case "V":
                return new Rotor("V","VZBRGITYUPSDNHLXAWMJQOFECK", startLetter, ringSetting, 25);
        }
        return null;
    }


}
