public class Enigma {

    // User configuration settings
    public Rotor rightRotor;
    public Rotor centreRotor;
    public Rotor leftRotor;

    public Reflector reflector;

    public Plugboard plugboard;

    public Enigma(String[] rotors, String reflector, int[] rotorPositions, int[] ringSettings, String plugboardPairs) {
        this.rightRotor = Rotor.ConstructRotor(rotors[0], ringSettings[0], rotorPositions[0]);
        this.centreRotor = Rotor.ConstructRotor(rotors[1], ringSettings[1], rotorPositions[1]);;
        this.leftRotor = Rotor.ConstructRotor(rotors[2], ringSettings[2], rotorPositions[2]);;
        this.reflector = Reflector.ReflectorConfiguration(reflector);
        this.plugboard = new Plugboard(plugboardPairs);
    }

}
