public class Enigma {

    private final Object Exception = "Duplicated rotor";
    // User configuration settings
    public Rotor rightRotor;
    public Rotor centreRotor;
    public Rotor leftRotor;

    public Reflector reflector;

    public Plugboard plugboard;

    public final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Enigma(String[] rotorOrder, String reflector, int[] rotorPositions, int[] ringSettings, String[] plugboardPairs, String userMessage) throws Throwable {
        if ((rotorOrder[0].equals(rotorOrder[1])) || (rotorOrder[0].equals(rotorOrder[2])) || (rotorOrder[1].equals(rotorOrder[2]))) {
            throw (Throwable) Exception;
        }
        this.leftRotor = Rotor.ConstructRotor(rotorOrder[0], ringSettings[0], rotorPositions[0]);
        this.centreRotor = Rotor.ConstructRotor(rotorOrder[1], ringSettings[1], rotorPositions[1]);
        this.rightRotor = Rotor.ConstructRotor(rotorOrder[2], ringSettings[2], rotorPositions[2]);
        this.reflector = Reflector.ReflectorConfiguration(reflector);
        this.plugboard = new Plugboard(plugboardPairs);
        encryptMessage(userMessage);
    }

    private void encryptMessage(String userMessage) {
        String currentLetter;
        for (int i = 0; i < userMessage.length(); i++) {
            currentLetter = String.valueOf(userMessage.charAt(i));
            singleLetterEncryption(currentLetter, reflector, plugboard);
            rotate();
        }
    }

    private String singleLetterEncryption(String currentLetter, Reflector reflector, Plugboard plugboard) {
        String encryptedLetter;

        //Forward journey
        if (plugboard.PlugboardPairs(plugboard).get(currentLetter) != null){
            System.out.println(currentLetter);
            System.out.println((plugboard.PlugboardPairs(plugboard).get(currentLetter)));
            currentLetter = plugboard.PlugboardPairs(plugboard).get(currentLetter);
        }
        encryptedLetter = String.valueOf(rightRotor.rotorConfiguration.charAt(alphabet.indexOf(currentLetter)));
        encryptedLetter = String.valueOf(centreRotor.rotorConfiguration.charAt(alphabet.indexOf(encryptedLetter)));
        encryptedLetter = String.valueOf(leftRotor.rotorConfiguration.charAt(alphabet.indexOf(encryptedLetter)));

        encryptedLetter = String.valueOf(reflector.reflectorConfig[1].charAt(alphabet.indexOf(encryptedLetter)));

        //Return journey
        encryptedLetter = String.valueOf(alphabet.charAt(leftRotor.rotorConfiguration.indexOf(encryptedLetter)));
        encryptedLetter = String.valueOf(alphabet.charAt(centreRotor.rotorConfiguration.indexOf(encryptedLetter)));
        encryptedLetter = String.valueOf(alphabet.charAt(rightRotor.rotorConfiguration.indexOf(encryptedLetter)));
        System.out.println(encryptedLetter);

        if (plugboard.PlugboardPairs(plugboard).get(encryptedLetter) != null){
            System.out.println(encryptedLetter);
            System.out.println((plugboard.PlugboardPairs(plugboard).get(encryptedLetter)));
            encryptedLetter = plugboard.PlugboardPairs(plugboard).get(encryptedLetter);
        }
        return encryptedLetter;
    }

    public void rotate() {
        System.out.println("left rotor = " + leftRotor.currentLetter + " (" + alphabet.charAt(leftRotor.currentLetter) + ")");
        System.out.println("centre rotor = " + centreRotor.currentLetter + " (" + alphabet.charAt(centreRotor.currentLetter) + ")");
        System.out.println("right rotor = " + rightRotor.currentLetter + " (" + alphabet.charAt(rightRotor.currentLetter) + ")" + "\n");


        if (rightRotor.notchHit() && !centreRotor.notchHit()){
            centreRotor.moveRotor();
        }
        if (centreRotor.notchHit() && !rightRotor.notchHit()){
            leftRotor.moveRotor();
        }
        if (rightRotor.notchHit() && centreRotor.notchHit()){
            centreRotor.moveRotor();
            leftRotor.moveRotor();
        }

        rightRotor.moveRotor();

//        System.out.println("left rotor = " + leftRotor.currentLetter + " (" + alphabet.charAt(leftRotor.currentLetter) + ")");
//        System.out.println("centre rotor = " + centreRotor.currentLetter + " (" + alphabet.charAt(centreRotor.currentLetter) + ")");
//        System.out.println("right rotor = " + rightRotor.currentLetter + " (" + alphabet.charAt(rightRotor.currentLetter) + ")" + "\n");


    }

}
