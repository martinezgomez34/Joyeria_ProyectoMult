module com.eduard034.joyeria_proyectomult {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.eduard034.joyeria_proyectomult to javafx.fxml;
    exports com.eduard034.joyeria_proyectomult;
    exports com.eduard034.joyeria_proyectomult.controllers;
    opens com.eduard034.joyeria_proyectomult.controllers to javafx.fxml;
}