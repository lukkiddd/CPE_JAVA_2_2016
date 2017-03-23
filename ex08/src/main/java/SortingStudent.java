import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Comparator;


/**
 * Created by lukkiddd on 3/21/2017 AD.
 */
public class SortingStudent extends Application {

    final ToggleGroup group = new ToggleGroup();
    final ToggleGroup group_order = new ToggleGroup();
    String g1;
    String g2;
    ArrayList<Student> students = new ArrayList<Student>();
    TextArea text = new TextArea();

    public static void sort(ArrayList<Student> s, Comparator<Student> c, boolean asc) {
        int i, j;
        Student s_temp;
        for(i = 0; i < s.size()-1; i++) {
            for(j = 0; j < s.size(); j++) {
                if((c.compare(s.get(i), s.get(j)) > 0 && asc == true) || (c.compare(s.get(i), s.get(j)) < 0 && asc == false)) {
                    s_temp = s.get(i);
                    s.set(i, s.get(j));
                    s.set(j, s_temp);
                }
            }
        }
    }

    public void displayText() {
        String studentList = "";
        for(Student s: students) {
            studentList += s.toString() + "\n";
        }

        text.setText(studentList);
    }

    @Override
    public void start(Stage primaryStage) {
        students.add(new Student(10000, "John", "Doe",3.0));
        displayText();

        GridPane grid = new GridPane();
        VBox vb_button = new VBox(10);
        VBox vb_right = new VBox(10);
        Label space = new Label("");
        Text scenetitle = new Text("Sorting Students");

        grid.add(scenetitle, 0, 0, 2, 1);

        Scene scene = new Scene(grid, 1200, 500);
        primaryStage.setScene(scene);

        RadioButton toggle_ID = new RadioButton("ID");
        toggle_ID.setUserData("ID");
        toggle_ID.setToggleGroup(group);
        toggle_ID.setSelected(true);

        RadioButton toggle_name = new RadioButton("Name");
        toggle_name.setUserData("Name");
        toggle_name.setToggleGroup(group);

        RadioButton toggle_lastname = new RadioButton("Lastname");
        toggle_lastname.setUserData("Lastname");
        toggle_lastname.setToggleGroup(group);

        RadioButton toggle_GPA = new RadioButton("GPA");
        toggle_GPA.setUserData("GPA");
        toggle_GPA.setToggleGroup(group);

        vb_button.getChildren().add(toggle_ID);
        vb_button.getChildren().add(toggle_name);
        vb_button.getChildren().add(toggle_lastname);
        vb_button.getChildren().add(toggle_GPA);

        RadioButton asc_button = new RadioButton("Ascending");
        asc_button.setUserData("Ascending");
        asc_button.setToggleGroup(group_order);
        asc_button.setSelected(true);

        RadioButton desc_button = new RadioButton("Descending");
        desc_button.setUserData("Descending");
        desc_button.setToggleGroup(group_order);

        vb_button.getChildren().add(space);
        vb_button.getChildren().add(asc_button);
        vb_button.getChildren().add(desc_button);

        Button sorting_button = new Button("Sort");
        sorting_button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                g1 = group.getSelectedToggle().getUserData().toString();
                g2 = group_order.getSelectedToggle().getUserData().toString();

                if( g1.equals("ID") && g2.equals("Ascending") ) {
                    sort(students, Student.IDComparator, true);
                } else if( g1.equals("ID") && g2.equals("Descending") ) {
                    sort(students, Student.IDComparator, false);
                } else if( g1.equals("Name") && g2.equals("Ascending") ) {
                    sort(students, Student.nameComparator, true);
                } else if( g1.equals("Name") && g2.equals("Descending") ) {
                    sort(students, Student.nameComparator, false);
                } else if( g1.equals("Lastname") && g2.equals("Ascending") ) {
                    sort(students, Student.lastnameComparator, true);
                } else if( g1.equals("Lastname") && g2.equals("Descending") ) {
                    sort(students, Student.lastnameComparator, false);
                } else if( g1.equals("GPA") && g2.equals("Ascending") ) {
                    sort(students, Student.GPAComparator, true);
                } else if (g1.equals("GPA") && g2.equals("Descending") ) {
                    sort(students, Student.GPAComparator, false);
                }

                displayText();
            }
        });

        vb_button.getChildren().add(sorting_button);

        HBox add_student = new HBox();
        Label sID = new Label(" ID: ");
        final TextField sIDTextField = new TextField();
        Label sName = new Label(" Name: ");
        final TextField sNameTextField = new TextField();
        Label sLastname = new Label(" Last name: ");
        final TextField sLastnameTextField = new TextField();
        Label sGPA = new Label(" GPA: ");
        final TextField sGPATextField = new TextField();

        add_student.getChildren().addAll(sID, sIDTextField, sName, sNameTextField, sLastname, sLastnameTextField, sGPA, sGPATextField);

        Button addbtn = new Button("Add");
        addbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int ID = Integer.valueOf(sIDTextField.getText());
                String name = sNameTextField.getText();
                String lastname = sLastnameTextField.getText();
                double GPA = Double.valueOf(sGPATextField.getText());
                students.add(new Student(ID, name, lastname, GPA));

                displayText();
                sIDTextField.setText("");
                sNameTextField.setText("");
                sLastnameTextField.setText("");
                sGPATextField.setText("");
            }
        });

        HBox delete_student = new HBox(10);
        Label deleteID = new Label("Deleted ID: ");
        final TextField deleteTextField = new TextField();

        Button delete_button = new Button("Delete");
        delete_button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int deleted_ID = Integer.valueOf(deleteTextField.getText());
                for(Student s: students) {
                    if(s.getStudentID() == deleted_ID) {
                        students.remove(s);
                        break;
                    }
                }
                displayText();
                deleteTextField.setText("");
            }
        });

        delete_student.getChildren().addAll(deleteID, deleteTextField);

        vb_right.getChildren().addAll(text,add_student, addbtn, delete_student, delete_button);
        grid.add(vb_button,0,1);
//        grid.add(sorting_button,0,2);
        grid.add(vb_right, 2,1 );
        grid.setPadding(new Insets(10, 10, 10, 10));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


}
