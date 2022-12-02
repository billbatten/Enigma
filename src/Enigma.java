public class Enigma {

    // User configuration settings
    public Rotor rightRotor;
    public Rotor centreRotor;
    public Rotor leftRotor;

    public Reflector reflector;

    public Plugboard plugboard;

    public Enigma(String[] rotorOrder, String reflector, int[] rotorPositions, int[] ringSettings, String[] plugboardPairs) {
        this.leftRotor = Rotor.ConstructRotor(rotorOrder[0], ringSettings[0], rotorPositions[0]);
        this.centreRotor = Rotor.ConstructRotor(rotorOrder[1], ringSettings[1], rotorPositions[1]);
        this.rightRotor = Rotor.ConstructRotor(rotorOrder[2], ringSettings[2], rotorPositions[2]);
        this.reflector = Reflector.ReflectorConfiguration(reflector);
        this.plugboard = new Plugboard(plugboardPairs);
        rotate();
    }

    public void rotate() {

        System.out.println("left rotor = " + leftRotor.currentLetter);
        System.out.println("centre rotor = " + centreRotor.currentLetter);
        System.out.println("right rotor = " + rightRotor.currentLetter + "\n");

        // centre rotor moves 1 position
        if (rightRotor.notchHit() && !centreRotor.notchHit()){
            centreRotor.moveRotor();
        }
        // left rotor moves 1 position
        if (centreRotor.notchHit() && !rightRotor.notchHit()){
            leftRotor.moveRotor();
        }
        // double step. Centre rotor and left rotor move 1 place
        if (rightRotor.notchHit() && centreRotor.notchHit()){
            centreRotor.moveRotor();
            leftRotor.moveRotor();
        }
        // Right rotor always moves one position each key press
        rightRotor.moveRotor();

        char[] alphabetConversion = new char[]{'A','B','C','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','Y','X','Z'};
        
        System.out.println("Current letter = " + alphabetConversion[leftRotor.currentLetter]);
        System.out.println("left rotor = " + leftRotor.currentLetter);
        System.out.println("centre rotor = " + centreRotor.currentLetter);
        System.out.println("right rotor = " + rightRotor.currentLetter);


    }
    public void encryptMessage(String inputMessage){


    }




}
