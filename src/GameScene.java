import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class GameScene extends Scene {
    private Camera cam;
    private staticThing left = new staticThing(0, 0, "desert.png");
    private staticThing right = new staticThing(800, 0, "desert.png");
    private Hero hero = new Hero(0, 200, 300, "heros.png");

    public GameScene(Group root, double width, double height, boolean depthBuffer) {

        super(root, width, height, depthBuffer);
        cam = new Camera(300, 200);
        timer.start();
        root.getChildren().add(left.getIm());
        root.getChildren().add(right.getIm());
        root.getChildren().add(AnimatedThing.getAnime());



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

    public void update () throws Exception{
        method();
    }
    private void method(){


    }



    AnimationTimer timer = new AnimationTimer() {
        public void handle(long time) {
            hero.update(200);
            cam.update(time);
            GameScene.update(time);
        }
    };


    public staticThing getLeft() {return left;}
    public staticThing getRight() {return right;}

    }

