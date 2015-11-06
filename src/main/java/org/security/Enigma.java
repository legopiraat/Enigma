package org.security;

public class Enigma {

    private Rotor rotor1;
    private Rotor rotor2;
    private Rotor rotor3;
    private Rotor reverseRotor;

    public Enigma(int rotor1Setting, int rotor2Setting, int rotor3Setting) {
        rotor1 = new Rotor(rotor1Setting);
        rotor2 = new Rotor(rotor2Setting);
        rotor3 = new Rotor(rotor3Setting);

        reverseRotor = new Rotor(901);
    }

    public char pressKey(char key) {
        if(key == ' ') {
            return ' ';
        }

        char rotor1Key = rotor1.getValueByKey(key);
        char rotor2Key = rotor2.getValueByKey(rotor1Key);
        char rotor3Key = rotor3.getValueByKey(rotor2Key);
        char reverserKey = reverseRotor.getValueByKey(rotor3Key);
        char rotor1ReverseKey = rotor3.getKeyByValue(reverserKey);
        char rotor2ReverseKey = rotor2.getKeyByValue(rotor1ReverseKey);
        char rotor3ReverseKey = rotor1.getKeyByValue(rotor2ReverseKey);

        return rotor3ReverseKey;
    }
}
