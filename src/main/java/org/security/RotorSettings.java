package org.security;

import java.util.HashMap;

public class RotorSettings {

    private HashMap<Integer, String> rotorMaps;

    public RotorSettings() {
        init();
    }

    public String getRotorMap(int rotorId) {
        return rotorMaps.get(rotorId);
    }

    private void init() {
        rotorMaps = new HashMap<>();

        //normal
        rotorMaps.put(1, "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toLowerCase());
        rotorMaps.put(2, "AJDKSIRUXBLHWTMCQGZNPYFVOE".toLowerCase());
        rotorMaps.put(3, "BDFHJLCPRTXVZNYEIWGAKMUSQO".toLowerCase());

        //Reflectors
        rotorMaps.put(901, "EJMZALYXVBWFCRQUONTSPIKHGD".toLowerCase());
        rotorMaps.put(902, "YRUHQSLDPXNGOKMIEBFZCWVJAT".toLowerCase());
        rotorMaps.put(903, "FVPJIAOYEDRZXWGCTKUQSBNMHL".toLowerCase());
    }
}
