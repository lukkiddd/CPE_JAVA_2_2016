import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * Created by lukkiddd on 3/19/2017 AD.
 */
public class GamePractice extends Application {

    public static Pane canvas;

    public static void main(final String[] args) {
        launch(args);
    }

    public static int random(int maxRange) {
        return (int) Math.round((Math.random() * maxRange));
    }

    @Override
    public void start(final Stage primaryStage) {
        canvas = new Pane();
        final Scene scene = new Scene(canvas, 800, 600);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(50),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent t) {

                        for(int i = 0; i < canvas.getChildren().size(); i++) {
                            NCircle circle = (NCircle) canvas.getChildren().get(i);

                            circle.setLayoutX(circle.getLayoutX() + circle.deltaX);
                            circle.setLayoutY(circle.getLayoutY() + circle.deltaY);

                            final Bounds bounds = canvas.getBoundsInLocal();
                            final boolean atRightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
                            final boolean atLeftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
                            final boolean atBottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
                            final boolean atTopBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());

                            if(atRightBorder || atLeftBorder) { circle.deltaX *= -1; }
                            if(atBottomBorder || atTopBorder) { circle.deltaY *= -1; }
                        }

                    }
                }));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();

        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                System.out.println("mouse click detected!" + mouseEvent.getSource());
            }
        });

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.PRIMARY) {
                    System.out.println("REMOVE");
                    canvas.getChildren().remove(0);
                } else if(event.getButton() == MouseButton.SECONDARY) {
                    NCircle circle = new NCircle(15, Color.rgb(random(255),random(255),random(255)));
                    circle.relocate(random(800),random(600));
                    canvas.getChildren().add(circle);
                }
            }
        });

    }

}
