import java.util.HashMap;

public class Plugboard {

    private final String[] plugboard;

    public Plugboard(String[] plugboard) {
        this.plugboard = plugboard;
    }

    public HashMap<String, String> PlugboardPairs(Plugboard plugboard){
    HashMap<String, String> plugboardPairs = new HashMap<>();
        for (String x : plugboard.plugboard) {
            plugboardPairs.put((x.substring(0, x.length() / 2)), (x.substring(1)));
            plugboardPairs.put((x.substring(1)), (x.substring(0, x.length() / 2)));
        }
        return plugboardPairs;
    }
}
