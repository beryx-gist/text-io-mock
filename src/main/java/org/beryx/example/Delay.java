package org.beryx.example;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

public class Delay {
    private long delay;

    public long getDelay() {
        return delay;
    }

    public void initFromTextIO(TextIO textIO) {
        TextTerminal terminal = textIO.getTextTerminal();
        delay = textIO.newLongInputReader()
                .withMinVal(5L)
                .withMaxVal(13L)
                .withItemName("delay")
                .withDefaultValue(10L)
                .read("Delay in seconds");
        terminal.print("Delay set to " + delay + " seconds.");
    }
}
