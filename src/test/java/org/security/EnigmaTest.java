package org.security;

import org.junit.Before;
import org.junit.Test;
import org.security.encrypt.Enigma;
import org.security.encrypt.RotorInitializer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class EnigmaTest {

    private Enigma enigma;
    private RotorInitializer initializer;

    @Before
    public void before() {
        enigma = new Enigma();
        initializer = new RotorInitializer();
    }

    @Test
    public void testEnigmaWithASentence() {
        String input = "test";
        String expectedOutput = "nohs";

        enigma.setRotors(
                initializer.getRotorMap(1),
                initializer.getRotorMap(2),
                initializer.getRotorMap(3),
                initializer.getRotorMap(901));

        enigma.setRotorStartingPoints(0,0,0);

        String output = enigma.pressSentence(input);

        assertThat(output, equalTo(expectedOutput));
    }

    @Test
    public void testEngimaWithAnEncryptedSentence() {
        String input = "nohs";
        String expectedOutput = "test";

        enigma.setRotors(
                initializer.getRotorMap(1),
                initializer.getRotorMap(2),
                initializer.getRotorMap(3),
                initializer.getRotorMap(901));

        enigma.setRotorStartingPoints(0,0,0);

        String output = enigma.pressSentence(input);

        assertThat(output, equalTo(expectedOutput));
    }
}
