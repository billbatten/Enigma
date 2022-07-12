import java.util.HashMap;

public class Plugboard {

    public Plugboard(String[] connections) {

        //A string array is passed into the function and it is converted to a hashset in order to swap the numbers as
        // they enter and leave the plugboard

        HashMap<String, String> plugboardPairs = new HashMap<>();
        for (String x : connections) {
            plugboardPairs.put((x.substring(0, x.length() / 2)), (x.substring(1)));

        }
    }
}
