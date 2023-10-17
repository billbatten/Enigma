public class Reflector {
    public String reflectorConfig;
    public Reflector(String reflectorConfiguration) {
//        this.reflectorConfig = new String[]{reflectorChoice, reflectorConfiguration};
        this.reflectorConfig = reflectorConfiguration;
    }

    public static Reflector ReflectorConfiguration(String reflectorChoice) {
        switch (reflectorChoice) {
            case "B":
//                return new Reflector("B", "YRUHQSLDPXNGOKMIEBFZCWVJAT");
                return new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
            case "C":                                 //ABCDEFGHIJKLMNOPQRSTUVWYXZ
                return new Reflector("FVPJIAOYEDRZXWGCTKUQSBNMHL");
                                                                      //ABCDEFGHIJKLMNOPQRSTUVWYXZ
        }
        return null;
    }
}
