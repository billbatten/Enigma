public class Reflector {
    public String[] reflectorConfig;
    public Reflector(String reflectorChoice, String reflectorConfiguration) {
        this.reflectorConfig = new String[]{reflectorChoice, reflectorConfiguration};
    }

    public static Reflector ReflectorConfiguration(String reflectorChoice) {
        switch (reflectorChoice) {
            case "B":
                return new Reflector("B", "YRUHQSLDPXNGOKMIEBFZCWVJAT");
            case "C":
                return new Reflector("C", "FVPJIAOYEDRZXWGCTKUQSBNMHL");
        }
        return null;
    }
}
