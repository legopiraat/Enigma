package org.security;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Optional;

public class Rotor {

    @Getter
    @Setter
    private HashMap<Character, Character> rotorMapping;

    @Getter
    private char turningPoint;

    @Getter
    @Setter
    private int currentPosition;

    public Rotor(HashMap rotorMapping, char turningPoint) {
        this.rotorMapping = rotorMapping;
        this.turningPoint = turningPoint;
    }

    public char getKeyByValue(char value) {
        for (Character key : rotorMapping.keySet()) {
            if (rotorMapping.get(key).equals(value)) {
                increment();
                return key;
            }
        }

        throw new RuntimeException();
    }

    public char getValueByKey(char key) {
        increment();
        return rotorMapping.get(key);
    }

    private void increment() {

    }
}
