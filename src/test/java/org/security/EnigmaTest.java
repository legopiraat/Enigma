package org.security;

import org.junit.Before;

public class EnigmaTest {

    private Enigma enigma;

    @Before
    public void before() {
        enigma = new Enigma(1,2,3);
    }
}
