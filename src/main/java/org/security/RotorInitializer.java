package org.security;

import java.util.HashMap;

public class RotorInitializer {

    private HashMap<Integer, Rotor> rotors;

    public RotorInitializer() {
        init();
    }

    public Rotor getRotorMap(int rotorId) {
        return rotors.get(rotorId);
    }

    private void init() {
        rotors = new HashMap<>();

        //normal
        rotors.put(1, new Rotor(mapRotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ".toLowerCase()), 'q'));
        rotors.put(2, new Rotor(mapRotor("AJDKSIRUXBLHWTMCQGZNPYFVOE".toLowerCase()), 'e'));
        rotors.put(3, new Rotor(mapRotor("BDFHJLCPRTXVZNYEIWGAKMUSQO".toLowerCase()), 'v'));
        rotors.put(4, new Rotor(mapRotor("ESOVPZJAYQUIRHXLNFTGKDCMWB".toLowerCase()), 'j'));
        rotors.put(5, new Rotor(mapRotor("VZBRGITYUPSDNHLXAWMJQOFECK".toLowerCase()), 'z'));

        //Reflectors
        rotors.put(901, new Rotor(mapRotor("EJMZALYXVBWFCRQUONTSPIKHGD".toLowerCase()), ' '));
        rotors.put(902, new Rotor(mapRotor("YRUHQSLDPXNGOKMIEBFZCWVJAT".toLowerCase()), ' '));
        rotors.put(903, new Rotor(mapRotor("FVPJIAOYEDRZXWGCTKUQSBNMHL".toLowerCase()), ' '));
    }

    private HashMap<Character, Character> mapRotor(String sequence) {
        HashMap<Character, Character> mapping = new HashMap<>();
        char normal = 'a';

        for (char c : sequence.toCharArray()) {
            mapping.put(normal, c);
            normal++;
        }

        return mapping;
    }
}
