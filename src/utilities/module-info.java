module utilities {
    exports random;

    requires transitive data;
    requires java.logging;


    uses random.MyRandom;

    provides random.MyRandom with implementations.MyRandomImpl2;
}