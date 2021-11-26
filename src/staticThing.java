import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {
    private ImageView G;
    private double x;
    private double y;

    public staticThing(double x, double y, String fileName){
        this.x = x;
        this.y = y;
        Image staticImage = new Image(fileName);
        G = new ImageView(staticImage);
        G.setX(x);
        G.setY(y);
    }

    public ImageView getIm() {
        return G;
    }
}
