module com.example.face_creator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.face_creator to javafx.fxml;
    exports com.example.face_creator;
}