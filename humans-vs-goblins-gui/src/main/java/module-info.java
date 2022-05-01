module com.company.humansvsgoblinsgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.company.humansvsgoblinsgui to javafx.fxml;
    exports com.company.humansvsgoblinsgui;
}