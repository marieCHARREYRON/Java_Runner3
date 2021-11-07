import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing{
    public Hero (int Mood,double x, double y, String fileName){

        super(Mood,x, y, fileName);

        this.setOnMouseClicked( (event)->{
            System.out.println("Jump");
            Hero.jump();
        });
    }
}
