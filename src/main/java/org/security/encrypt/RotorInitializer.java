package org.security.encrypt;

import java.util.HashMap;

public class RotorInitializer {

    private HashMap<Integer, Rotor> rotors;
    private static final HashMap<Integer, Character> ALPHABET = getAlphabetMap();

    public RotorInitializer() {
        init();
    }

    public Rotor getRotorMap(int rotorId) {
        return rotors.get(rotorId);
    }

    private void init() {
        rotors = new HashMap<>();

        //normal
        rotors.put(1, new Rotor(mapRotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ".toLowerCase()), ALPHABET, 'q'));
        rotors.put(2, new Rotor(mapRotor("AJDKSIRUXBLHWTMCQGZNPYFVOE".toLowerCase()), ALPHABET, 'e'));
        rotors.put(3, new Rotor(mapRotor("BDFHJLCPRTXVZNYEIWGAKMUSQO".toLowerCase()), ALPHABET, 'v'));
        rotors.put(4, new Rotor(mapRotor("ESOVPZJAYQUIRHXLNFTGKDCMWB".toLowerCase()), ALPHABET, 'j'));
        rotors.put(5, new Rotor(mapRotor("VZBRGITYUPSDNHLXAWMJQOFECK".toLowerCase()), ALPHABET, 'z'));

        //Reflectors
        rotors.put(901, new Rotor(mapRotor("EJMZALYXVBWFCRQUONTSPIKHGD".toLowerCase()), ALPHABET, ' '));
        rotors.put(902, new Rotor(mapRotor("YRUHQSLDPXNGOKMIEBFZCWVJAT".toLowerCase()), ALPHABET, ' '));
        rotors.put(903, new Rotor(mapRotor("FVPJIAOYEDRZXWGCTKUQSBNMHL".toLowerCase()), ALPHABET, ' '));
    }

    private HashMap<Integer, Character> mapRotor(String sequence) {
        HashMap<Integer, Character> mapping = new HashMap<>();
        char[] charSequence = sequence.toCharArray();

        for (int i = 0; i < charSequence.length; i++) {
            mapping.put(i, charSequence[i]);
        }

        return mapping;
    }

    private static HashMap<Integer, Character> getAlphabetMap() {
        HashMap<Integer, Character> alphabet = new HashMap<>();
        char current = 'a';

        for (int i = 1; i <= 26; i++) {
            alphabet.put(i, current);
            current++;
        }

        return alphabet;
    }
}
