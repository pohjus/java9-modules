package implementations;

import java.util.logging.*;

import random.*;

import java.util.concurrent.ThreadLocalRandom;

public class MyRandomImpl2 implements MyRandom {
    private final Logger logger = Logger.getLogger(MyRandomImpl1.class.getName());

    public String getRandomWord(String... args) {

        logger.log(Level.INFO, "MyRandomImpl2 called, using ThreadLocalRandom.current()");

        return args[ThreadLocalRandom.current().nextInt(0, args.length)];
    }
}

