public class Main {

    public static void main(String[] args) throws Throwable {

        //User selected machine settings
        Enigma enigma = new Enigma(new String[]{"I", "II", "III"}, "B", new int[]{0, 4, 0}, new int[]{0, 0, 0},
                new String[]{"AB", "CD", "EF", "KS", "RP", "XW"}, "T");
    }
}
