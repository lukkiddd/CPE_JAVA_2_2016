import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by lukkiddd on 3/20/2017 AD.
 */
public class NCircle extends Circle {

    public int deltaX = 0;
    public int deltaY = 0;

    public NCircle(int radius, Color color) {
       super(radius, color);
       deltaX = (int) (Math.random() * 20 + 5);
       deltaY = (int) (Math.random() * 20 + 5);
    }
}
