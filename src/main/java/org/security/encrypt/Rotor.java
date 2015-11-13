package org.security.encrypt;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.stream.Stream;

public class Rotor {

    @Getter
    @Setter
    private HashMap<Integer, Character> rotorMapping;
    private HashMap<Integer, Character> alphabet;

    @Getter
    private int turningPoint;

    @Getter
    @Setter
    private boolean turningPointHit = false;

    @Getter
    @Setter
    private int currentPosition = 0;

    public Rotor(HashMap<Integer, Character> rotorMapping, HashMap<Integer, Character> alphabet, char turningPoint) {
        this.rotorMapping = rotorMapping;
        this.alphabet = alphabet;
        convertTurningPointToIndex(turningPoint);
    }

    private void convertTurningPointToIndex(char charTurningPoint) {
        alphabet.keySet().stream()
                .filter(key -> alphabet.get(key).equals(charTurningPoint))
                .forEach(key -> turningPoint = key);
    }

    public char getKeyByValue(char inputValue) {
        int keyIndex = 0;

        for (Integer key : rotorMapping.keySet()) {
            if (rotorMapping.get(key).equals(inputValue)) {
                keyIndex = (key + currentPosition) % 26;

                if (keyIndex == 0) {
                    keyIndex = 1;
                }

                break;
            }
        }

        return alphabet.get(keyIndex);
    }

    public char getValueByKey(char inputKey) {
        int valueIndex = 0;

        for (Integer key : alphabet.keySet()) {
            if (alphabet.get(key).equals(inputKey)) {
                valueIndex = (key + currentPosition) % 26;

                if (valueIndex == 0) {
                    valueIndex = 1;
                }
                break;
            }
        }

        return rotorMapping.get(valueIndex);
    }

    public void increment() {
        if (currentPosition == turningPoint) {
            turningPointHit = true;
        }

        currentPosition++;
    }
}
