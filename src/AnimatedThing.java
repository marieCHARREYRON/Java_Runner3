import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract public class AnimatedThing {
    private double x;
    private double y;
    private static ImageView Anime;
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

            Image spriteSheet = new Image("heros.png");
            Anime = new ImageView(spriteSheet);
            Anime.setViewport(new Rectangle2D(20, 0, 75, 100));
            Anime.setX(x);
            Anime.setY(y);
    }

    public static ImageView getAnime() {
        return Anime;
    }

    public int getMood() {
        return Mood;
    }

    public void update(long time){
        this.Anime.setViewport(new Rectangle2D(offset+(size*index),0,75,100));
        this.Anime.setX(200);
        this.Anime.setY(300);

        index++;
        if(index==5){
            index=0;
        }

    }
}
