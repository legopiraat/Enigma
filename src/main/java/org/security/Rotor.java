package org.security;

import lombok.Getter;

import java.util.HashMap;
import java.util.Optional;

public class Rotor {

    @Getter
    private HashMap<Character, Character> rotorMapping;

    public Rotor(int settingId) {
        rotorMapping = new HashMap<>();

        RotorSettings rotorSettings = new RotorSettings();
        String rotorString = rotorSettings.getRotorMap(settingId);

        mapRotorString(rotorString);
    }

    private void mapRotorString(String rotorString) {
        char[] splitted = rotorString.toCharArray();
        char begin = 'a';

        for (char split : splitted) {
            rotorMapping.put(begin, split);
            begin++;
        }
    }


    public char getKeyByValue(char value) {
        for (Character key : rotorMapping.keySet()) {
            if (rotorMapping.get(key).equals(value)) {
                return key;
            }
        }

        throw new RuntimeException();
    }

    public char getValueByKey(char key) {
        return rotorMapping.get(key);
    }
}
