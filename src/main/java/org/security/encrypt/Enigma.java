package org.security.encrypt;

public class Enigma {

    private Rotor r1;
    private Rotor r2;
    private Rotor r3;
    private Rotor reverseRotor;

    public Enigma() {

    }

    public String pressSentence(String sentence) {
        char[] parts = sentence.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char part : parts) {
            builder.append(pressKey(part));
        }

        return builder.toString();
    }

    public char pressKey(char key) {
        if (key == ' ') {
            return key;
        }

        char rotor1Key = r1.getValueByKey(key);
        char rotor2Key = r2.getValueByKey(rotor1Key);
        char rotor3Key = r3.getValueByKey(rotor2Key);

        char reverserKey = reverseRotor.getValueByKey(rotor3Key);

        char rotor1ReverseKey = r3.getKeyByValue(reverserKey);
        char rotor2ReverseKey = r2.getKeyByValue(rotor1ReverseKey);
        char rotor3ReverseKey = r1.getKeyByValue(rotor2ReverseKey);

        rotate();

        return rotor3ReverseKey;
    }

    public void setRotors(Rotor r1, Rotor r2, Rotor r3, Rotor reverseRotor) {
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.reverseRotor = reverseRotor;
    }

    public void setRotorStartingPoints(int startR1, int startR2, int startR3) {
        this.r1.setCurrentPosition(startR1);
        this.r2.setCurrentPosition(startR2);
        this.r3.setCurrentPosition(startR3);
    }

    private void rotate() {
        r1.increment();

        if (r1.isTurningPointHit()) {
            r1.setTurningPointHit(false);
            r2.increment();
        }

        if (r2.isTurningPointHit()) {
            r2.setTurningPointHit(false);
            r3.increment();
        }
    }
}
