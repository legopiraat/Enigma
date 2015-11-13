package org.security;

import org.security.encrypt.Enigma;
import org.security.encrypt.RotorInitializer;

public class App {
    public static void main(String[] args) {
        RotorInitializer initializer = new RotorInitializer();
        Enigma enigma = new Enigma();

        enigma.setRotors(
                initializer.getRotorMap(1),
                initializer.getRotorMap(2),
                initializer.getRotorMap(3),
                initializer.getRotorMap(901));

        enigma.setRotorStartingPoints(0,0,0);
        String encrypted = enigma.pressSentence("test");

        enigma.setRotorStartingPoints(0,0,0);
        String decrypted = enigma.pressSentence(encrypted);

        System.out.println(encrypted);
        System.out.println(decrypted);
    }
}
