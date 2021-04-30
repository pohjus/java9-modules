package implementations;

import java.util.logging.*;
import random.*;

public class MyRandomImpl1 implements MyRandom {

    private final Logger logger = Logger.getLogger(MyRandomImpl1.class.getName());

    public String getRandomWord(String... args) {

        logger.log(Level.INFO, "MyRandomImpl1 called, using Math.random()");

        return args[(int) (Math.random() * args.length)];
    }
}
