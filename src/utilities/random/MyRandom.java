
package random;

public class MyRandom {
      public static String getRandomWord(String... args) {
          return args[(int) (Math.random() * args.length)];
      }
}