public class Rotor {

    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String rotorNumber;
    public int ringSetting;
    public int currentLetter;
    public int notchPosition;
    public String rotorConfiguration;
    public String alphabetConfiguration;

    public Rotor(String rotorNumber, String rotorConfiguration , int ringSetting, int currentLetter, int notchPosition, String alphabetConfiguration) {
        this.rotorNumber = rotorNumber;
        this.ringSetting = ringSetting;
        this.currentLetter = currentLetter;
        this.rotorConfiguration = rotorConfiguration;
        this.notchPosition = notchPosition;
        this.alphabetConfiguration = alphabetConfiguration;
    }

    public static Rotor ConstructRotor(String rotorNumber, int ringSetting, int currentLetter){
        switch(rotorNumber){
            case "I":
                return new Rotor(rotorNumber, rotorRingConfiguration(ringSetting, "EKMFLGDQVZNTOWYHXUSPAIBRCJ"), ringSetting, currentLetter, 16, alphabetShift(alphabet, currentLetter));
            case "II":                                    //ABCDEFGHIJKLMNOPQRSTUVWYXZ
                return new Rotor(rotorNumber, rotorRingConfiguration(ringSetting, "AJDKSIRUXBLHWTMCQGZNPYFVOE"), ringSetting, currentLetter, 4, alphabetShift(alphabet, currentLetter));
            case "III":                                   //ABCDEFGHIJKLMNOPQRSTUVWYXZ
                return new Rotor(rotorNumber, rotorRingConfiguration(ringSetting, "BDFHJLCPRTXVZNYEIWGAKMUSQO"), ringSetting, currentLetter, 21, alphabetShift(alphabet, currentLetter));
            case "IV":                                                                            //ABCDEFGHIJKLMNOPQRSTUVWYXZ
                return new Rotor(rotorNumber, rotorRingConfiguration(ringSetting, "ESOVPZJAYQUIRHXLNFTGKDCMWB"), ringSetting, currentLetter, 9, alphabetShift(alphabet, currentLetter));
            case "V":                                     //ABCDEFGHIJKLMNOPQRSTUVWYXZ
                return new Rotor(rotorNumber, rotorRingConfiguration(ringSetting, "VZBRGITYUPSDNHLXAWMJQOFECK"), ringSetting, currentLetter, 25, alphabetShift(alphabet, currentLetter));
                                                          //ABCDEFGHIJKLMNOPQRSTUVWYXZ
        }
        return null;
    }

    public static String alphabetShift(String currentAlphabetConfiguration, int currentLetter) {
        return currentAlphabetConfiguration.substring(currentLetter) + currentAlphabetConfiguration.substring(0, currentLetter);
    }

    private static String rotorRingConfiguration(int ringSetting, String originalConfiguration) {
                         //EKMFLGDQVZNTOWYHXUSPAIBRCJ
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWYXZ";
        StringBuilder shiftedConfiguration = new StringBuilder();
        for(char c : originalConfiguration.toCharArray()) {
            int index = alphabet.indexOf(c) + ringSetting;
            if (index >= 26){
                index = 0;
            }
            String x = String.valueOf(shiftedConfiguration.append(alphabet.charAt(index)));
        }
        System.out.println("shiftedConfiguration: " + shiftedConfiguration);
        return shiftedConfiguration.toString();
    }

    public void moveRotor() {
        this.currentLetter = (this.currentLetter + 1) % 26;
    }

    public boolean notchHit() {
        return this.currentLetter == this.notchPosition;
    }


}
