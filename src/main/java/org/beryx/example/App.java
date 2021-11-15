package org.beryx.example;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class App {
    public static void main(String[] args) throws Exception {
        TextIO textIO = TextIoFactory.getTextIO();
        try {
            Delay delay = new Delay();
            delay.initFromTextIO(textIO);

            textIO.getTextTerminal().print("Sleeping " + delay.getDelay() + " seconds before terminating.");
            Thread.sleep(1000 * delay.getDelay());
        } finally {
            textIO.dispose();
        }
    }
}
