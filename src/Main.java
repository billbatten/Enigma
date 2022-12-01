public class Main {

    public static void main(String[] args) throws Throwable {

        //User selected machine settings
        Enigma enigma = new Enigma(new String[]{"I", "II", "IV"}, "B", new int[]{0, 4, 16}, new int[]{1, 2, 3},
                new String[]{"AB", "CD", "EF", "KS", "RP"}, "K");

    }
}
