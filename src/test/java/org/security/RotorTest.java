package org.security;

import org.junit.Before;
import org.junit.Test;
import org.security.encrypt.Rotor;
import org.security.encrypt.RotorInitializer;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RotorTest {

    private Rotor rotor;

    @Before
    public void before() {
        RotorInitializer initializer = new RotorInitializer();
        rotor = initializer.getRotorMap(1);
    }

    @Test
    public void rotor1SettingsShouldBeMatchingString() {
        HashMap<Integer, Character> map = rotor.getRotorMapping();

        String expectedString = "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toLowerCase();
        char[] expectedChars = expectedString.toCharArray();
        char currentLetter = 'a';

        for (int i = 0; i < map.size(); i++) {
            assertThat(map.get(currentLetter).equals(expectedChars[i]), is(true));
            currentLetter++;
        }

        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @Test
    public void wut() {
        rotor.increment();
        rotor.increment();
    }
}
