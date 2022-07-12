public class Enigma {

    // User configuration settings
    public Rotor rightRotor;
    public Rotor centreRotor;
    public Rotor leftRotor;

    public Reflector reflector;

    public Plugboard plugboard;

    public Enigma(String[] rotorOrder, String reflector, int[] rotorPositions, int[] ringSettings, String[] plugboardPairs) {
        this.leftRotor = Rotor.ConstructRotor(rotorOrder[0], ringSettings[0], rotorPositions[0]);
        this.centreRotor = Rotor.ConstructRotor(rotorOrder[1], ringSettings[1], rotorPositions[1]);;
        this.rightRotor = Rotor.ConstructRotor(rotorOrder[2], ringSettings[2], rotorPositions[2]);;
        this.reflector = Reflector.ReflectorConfiguration(reflector);
        this.plugboard = new Plugboard(plugboardPairs);
        rotate();
    }

    public void rotate() {

        System.out.println("left rotor = " + leftRotor.currentLetter);
        System.out.println("centre rotor = " + centreRotor.currentLetter);
        System.out.println("right rotor = " + rightRotor.currentLetter + "\n");


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

        System.out.println("left rotor = " + leftRotor.currentLetter);
        System.out.println("centre rotor = " + centreRotor.currentLetter);
        System.out.println("right rotor = " + rightRotor.currentLetter);


    }

}
