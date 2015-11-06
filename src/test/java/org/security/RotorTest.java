package org.security;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RotorTest {

    private Rotor rotor;

    @Before
    public void before() {
        rotor = new Rotor(1);
    }

    @Test
    public void rotor1SettingsShouldBeMatchingString() {
        HashMap<Character, Character> map = rotor.getRotorMapping();

        String expectedString = "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toLowerCase();
        char[] expectedChars = expectedString.toCharArray();

        for (int i = 0; i < map.size(); i++) {
            assertThat(map.get(i).equals(expectedChars[i]), is(true));
        }

        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
