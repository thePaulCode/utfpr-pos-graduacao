module dev.thepaulcode.generico {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens dev.thepaulcode.generico to javafx.fxml;
    exports dev.thepaulcode.generico.tipolimitado;
    exports dev.thepaulcode.generico.tipogen;
    opens dev.thepaulcode.generico.tipogen to javafx.fxml;
    opens dev.thepaulcode.generico.interfacegen to javafx.fxml;
}