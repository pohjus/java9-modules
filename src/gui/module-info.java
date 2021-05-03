module gui {
    requires utilities;

    requires javafx.graphics;
    requires javafx.controls;

    requires java.net.http;

    requires com.fasterxml.jackson.databind;


    exports mypackage.gui to javafx.graphics;

    uses random.MyRandom;

}