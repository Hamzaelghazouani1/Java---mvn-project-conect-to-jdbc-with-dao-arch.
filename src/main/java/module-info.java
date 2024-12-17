module ma.enset.gestionbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ma.enset.gestionbd to javafx.fxml;
    exports ma.enset.gestionbd;
}