package org.beryx.example;

import org.beryx.textio.TextIO;
import org.beryx.textio.mock.MockTextTerminal;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test void appIsWorking() {
        MockTextTerminal terminal = new MockTextTerminal();
        TextIO textIO = new TextIO(terminal);

        terminal.getInputs().addAll(List.of("aaa", "3", "17", ""));

        Delay delay = new Delay();
        delay.initFromTextIO(textIO);

        List<String> output = terminal.getOutput().lines().collect(Collectors.toList());
        List<String> expected = List.of(
                "Delay in seconds [10]: aaa",
                "Invalid value for 'delay'.",
                "Expected a long value between 5 and 13.",
                "Delay in seconds [10]: 3",
                "Invalid value for 'delay'.",
                "Expected a long value between 5 and 13.",
                "Delay in seconds [10]: 17",
                "Invalid value for 'delay'.",
                "Expected a long value between 5 and 13.",
                "Delay in seconds [10]:",
                "Delay set to 10 seconds."
        );
        assertEquals(expected, output);
        assertEquals(10L, delay.getDelay());
    }
}
