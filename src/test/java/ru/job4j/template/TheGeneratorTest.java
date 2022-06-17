package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TheGeneratorTest {
    @Test
    @Ignore
    public void whenGenerated() {
        Generator generator = new TheGenerator();
        String temp = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Addy");
        map.put("subject", "you");
        String rsl = generator.produce(temp, map);
        assertThat(rsl, is("I am a Addy, Who are you?"));
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenKeyIsNot() {
        Generator generator = new TheGenerator();
        String temp = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Addy");
        String rsl = generator.produce(temp, map);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenKeyIsExcess() {
        Generator generator = new TheGenerator();
        String temp = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Addy");
        map.put("surname", "Bay");
        String rsl = generator.produce(temp, map);
    }
}