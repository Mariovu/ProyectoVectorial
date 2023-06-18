module com.example.proyectovectorial {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires jep;
    requires djep;

    opens com.example.proyectovectorial to javafx.fxml;
    exports com.example.proyectovectorial;
}