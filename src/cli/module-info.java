module cli {
    requires java.logging;
    requires java.net.http;
    requires utilities;
    requires Math;
    requires com.fasterxml.jackson.databind;

    uses random.MyRandom;
}