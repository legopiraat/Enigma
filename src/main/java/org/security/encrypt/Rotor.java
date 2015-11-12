package org.security.encrypt;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class Rotor {

    @Getter
    @Setter
    private HashMap<Integer, Character> rotorMapping;
    private HashMap<Integer, Character> alphabet;

    @Getter
    private char turningPoint;

    @Getter
    @Setter
    private boolean turningPointHit = false;

    @Getter
    @Setter
    private int currentPosition = 1;

    public Rotor(HashMap rotorMapping, HashMap alphabet, char turningPoint) {
        this.rotorMapping = rotorMapping;
        this.alphabet = alphabet;
        this.turningPoint = turningPoint;
    }

    public char getKeyByValue(char value) {
        int keyIndex = 0;

        for (Integer key : rotorMapping.keySet()) {
            if (rotorMapping.get(key).equals(value)) {
                keyIndex = (key + currentPosition - 1) % 26;

                if (keyIndex == 0) {
                    keyIndex = 1;
                }

                break;
            }
        }

        char key = alphabet.get(keyIndex + 1);
        return key;
    }

    public char getValueByKey(char inputKey) {
        int valueIndex = 0;

        for (Integer key : alphabet.keySet()) {
            if (alphabet.get(key).equals(inputKey)) {
                valueIndex = (key + currentPosition - 1) % 26;

                if (valueIndex == 0) {
                    valueIndex = 1;
                }

                break;
            }
        }

        return rotorMapping.get(valueIndex - 1);
    }

    public void increment() {
        if (alphabet.get(currentPosition).equals(turningPoint)) {
            turningPointHit = true;
        }

        if (currentPosition == 25) {
            currentPosition = 1;
        } else {
            currentPosition++;
        }
    }
}
