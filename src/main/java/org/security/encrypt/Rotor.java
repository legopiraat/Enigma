package org.security.encrypt;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Optional;

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
    private int currentPosition;

    public Rotor(HashMap rotorMapping, HashMap alphabet, char turningPoint) {
        this.rotorMapping = rotorMapping;
        this.alphabet = alphabet;
        this.turningPoint = turningPoint;
    }

    public char getKeyByValue(char value) {

    }

    public char getValueByKey(char inputKey) {
        int valueIndex = 0;

        for (Integer key : alphabet.keySet()) {
            if (alphabet.get(key).equals(inputKey)) {
                valueIndex = key + currentPosition % 26;
            }
        }

        char value = rotorMapping.get(valueIndex);

        increment();
        return value;
    }

    public void increment() {
        if(alphabet.get(currentPosition).equals(turningPoint)) {
            turningPointHit = true;
        }

        if(currentPosition == 26) {
            currentPosition = 1;
        } else {
            currentPosition++;
        }
    }
}
