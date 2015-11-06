package org.security;

public class App {
    public static void main(String[] args) {
        Enigma enigma = new Enigma(1, 2, 3);

        char[] string = "heil hitler".toCharArray();

        StringBuilder builder = new StringBuilder();

        for (char letter : string) {
            builder.append(enigma.pressKey(letter));
        }

        System.out.println(builder.toString());
        char[] output = builder.toString().toCharArray();

        builder = new StringBuilder();

        for (char reverseLetter : output) {
            builder.append(enigma.pressKey(reverseLetter));
        }

        System.out.println(builder.toString());
    }
}
