public class Enigma {

    private final Object Exception = "Duplicated rotor";
    // User configuration settings
    public Rotor rightRotor;
    public Rotor centreRotor;
    public Rotor leftRotor;

    public Reflector reflector;

    public Plugboard plugboard;

    public final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * @param rotorOrder - Order inn which the rotors are positioned in the machine.
     * @param reflector - Which reflector was selected. B or C.
     * @param rotorPositions - The letter that the rotor starts on as an int.
     * @param ringSettings - The ring setting of each rotor.
     * @param plugboardPairs - A String[] of pairs of letters on the plugboard connected by a wire.
     * @param userMessage - The message inputted by the user that with be encrypted or decrypted
     * @throws Throwable
     */
    public Enigma(String[] rotorOrder, String reflector, int[] rotorPositions, int[] ringSettings, String[] plugboardPairs, String userMessage) throws Throwable {
        if ((rotorOrder[0].equals(rotorOrder[1])) || (rotorOrder[0].equals(rotorOrder[2])) || (rotorOrder[1].equals(rotorOrder[2]))) {
            throw (Throwable) Exception;
        }
        this.rightRotor = Rotor.ConstructRotor(rotorOrder[0], ringSettings[0], rotorPositions[0]);
        this.centreRotor = Rotor.ConstructRotor(rotorOrder[1], ringSettings[1], rotorPositions[1]);
        this.leftRotor = Rotor.ConstructRotor(rotorOrder[2], ringSettings[2], rotorPositions[2]);
        this.reflector = Reflector.ReflectorConfiguration(reflector);
        this.plugboard = new Plugboard(plugboardPairs);
        encryptMessage(userMessage);
    }

    private void encryptMessage(String userMessage) {
        StringBuilder encryptedMessage = new StringBuilder();
        String currentLetter;
        for (int i = 0; i < userMessage.length(); i++) {
            currentLetter = String.valueOf(userMessage.charAt(i));
            rotate();
            encryptedMessage.append(singleLetterEncryption(currentLetter, reflector, plugboard));
        }
        System.out.println("Encrypted message = " + encryptedMessage);
    }

    private String singleLetterEncryption(String currentLetter, Reflector reflector, Plugboard plugboard) {
        String encryptedLetter;

        //Forward journey
        if (plugboard.PlugboardPairs(plugboard).get(currentLetter) != null){
            System.out.println("Before plugboard = " + currentLetter);
            currentLetter = plugboard.PlugboardPairs(plugboard).get(currentLetter);
            System.out.println("After plugboard = " + currentLetter);
        }
        encryptedLetter = String.valueOf(rightRotor.alphabetConfiguration.charAt(alphabet.indexOf(currentLetter)));
        System.out.println("\nEntering right rotor = " + encryptedLetter);
        encryptedLetter = getForwardRotorEncryption(encryptedLetter, rightRotor);
        System.out.println("Leaving right rotor = " + encryptedLetter);


        encryptedLetter = String.valueOf(centreRotor.alphabetConfiguration.charAt(rightRotor.alphabetConfiguration.indexOf(encryptedLetter)));
        System.out.println("\nEntering centre rotor = " + encryptedLetter);
        encryptedLetter = getForwardRotorEncryption(encryptedLetter, centreRotor);
        System.out.println("Leaving centre rotor = " + encryptedLetter);

        encryptedLetter = String.valueOf(leftRotor.alphabetConfiguration.charAt(alphabet.indexOf(encryptedLetter)));
        System.out.println("\nEntering left rotor = " + encryptedLetter);
        encryptedLetter = getForwardRotorEncryption(encryptedLetter, leftRotor);
        System.out.println("Leaving left rotor = " + encryptedLetter);

        encryptedLetter = String.valueOf(alphabet.charAt(leftRotor.alphabetConfiguration.indexOf(encryptedLetter)));
        System.out.println("\nEntering reflector = " + encryptedLetter);

        int index = alphabet.indexOf(encryptedLetter);
        encryptedLetter = String.valueOf(reflector.reflectorConfig.charAt(index));
        System.out.println("Leaving reflector = " + encryptedLetter);


        encryptedLetter = String.valueOf(leftRotor.alphabetConfiguration.charAt(alphabet.indexOf(encryptedLetter)));
        System.out.println("\nEntering left rotor = " + encryptedLetter);

        encryptedLetter = String.valueOf(alphabet.charAt(leftRotor.rotorConfiguration.indexOf(encryptedLetter)));
        System.out.println("Leaving left rotor = " + encryptedLetter);

        encryptedLetter = String.valueOf(centreRotor.alphabetConfiguration.charAt(alphabet.indexOf(encryptedLetter)));
        System.out.println("\nEntering centre rotor = " + encryptedLetter);

        encryptedLetter = String.valueOf(alphabet.charAt(centreRotor.rotorConfiguration.indexOf(encryptedLetter)));
        System.out.println("Leaving centre rotor = " + encryptedLetter);

        encryptedLetter = String.valueOf(rightRotor.alphabetConfiguration.charAt(alphabet.indexOf(encryptedLetter)));
        System.out.println("\nEntering right rotor = " + encryptedLetter);

        encryptedLetter = String.valueOf(alphabet.charAt(rightRotor.rotorConfiguration.indexOf(encryptedLetter)));
        System.out.println("Leaving right rotor = " + encryptedLetter);


        // TODO - Need to get right rotor into ETW config working

        encryptedLetter = String.valueOf(alphabet.charAt(rightRotor.alphabetConfiguration.indexOf(encryptedLetter)));

        if (plugboard.PlugboardPairs(plugboard).get(encryptedLetter) != null){
            encryptedLetter = plugboard.PlugboardPairs(plugboard).get(encryptedLetter);
        }
        return encryptedLetter;
    }

    public void rotate() {

        if (rightRotor.notchHit() && !centreRotor.notchHit()){
            centreRotor.moveRotor();
            centreRotor.rotorConfiguration = Rotor.alphabetShift(centreRotor.alphabetConfiguration, 1);
        }
        if (centreRotor.notchHit() && !rightRotor.notchHit()){
            leftRotor.moveRotor();
            leftRotor.rotorConfiguration = Rotor.alphabetShift(leftRotor.alphabetConfiguration, 1);
        }
        if (rightRotor.notchHit() && centreRotor.notchHit()){
            centreRotor.moveRotor();
            leftRotor.moveRotor();
            centreRotor.alphabetConfiguration = Rotor.alphabetShift(centreRotor.alphabetConfiguration, 1);
            leftRotor.alphabetConfiguration = Rotor.alphabetShift(leftRotor.alphabetConfiguration, 1);
        }

        rightRotor.moveRotor();
        rightRotor.alphabetConfiguration = Rotor.alphabetShift(rightRotor.alphabetConfiguration, 1);
    }


    public String getForwardRotorEncryption(String inboundLetter, Rotor rotor) {
        int inboundLetterIndex = alphabet.indexOf(inboundLetter);
        return String.valueOf(rotor.rotorConfiguration.charAt(inboundLetterIndex));
    }


}
