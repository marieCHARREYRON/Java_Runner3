import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;

abstract public class AnimatedThing {
    private double x;
    private double y;
    private int Mood=0;
    private double index=0;
    private double duration;
    private double indexMax;
    private double size=75;
    private double offset=25;

    public AnimatedThing(int Mood,double x,double y, String fileName){
        this.x = x;
        this.y = y;
        this.Mood = Mood;

    }

    public int getMood() {
        return Mood;
    }

    public void setMood(int mood) {
        Mood = mood;
    }

}
