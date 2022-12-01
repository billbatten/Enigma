public class Reflector {
    public String[] reflectorConfig;
    public Reflector(String reflectorChoice, String reflectorConfiguration) {
        this.reflectorConfig = new String[]{reflectorChoice, reflectorConfiguration};
    }

    public static Reflector ReflectorConfiguration(String reflectorChoice) {
        switch (reflectorChoice) {
            case "B":
                return new Reflector("B", "YRUHQSLDPXNGOKMIEBFZCWVJAT");
            case "C":                                                 //ABCDEFGHIJKLMNOPQRSTUVWYXZ
                return new Reflector("C", "FVPJIAOYEDRZXWGCTKUQSBNMHL");
                                                                      //ABCDEFGHIJKLMNOPQRSTUVWYXZ
        }
        return null;
    }
}
