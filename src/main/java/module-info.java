module main.artifact {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens main.artifact to javafx.fxml;
    exports main.artifact;
}