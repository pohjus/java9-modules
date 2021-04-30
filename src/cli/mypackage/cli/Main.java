
package mypackage.cli;

import java.util.logging.*;
import random.*;
import java.util.*;
public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String [] args) {
        MyRandom random = MyRandom.getInstance();
        logger.log(Level.INFO, random.getRandomWord("Hello", "World"));
    }
}
