import com.sun.jdi.LongValue;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.scene.control.Button;



public class GameScene extends Scene {
    private Camera cam;
    private staticThing left = new staticThing(0, 0, "desert.png");
    private staticThing right = new staticThing(800, 0, "desert.png");
    private Hero hero = new Hero(0, 200, 250, "heros.png");
    private staticThing vie  = new staticThing(0, 0,"FUSEEMALADES.png" );

    public GameScene(Group root, double width, double height, boolean depthBuffer) {

        super(root, width, height, depthBuffer);
        cam = new Camera(0, 0,hero);

        longVal val = new longVal(System.nanoTime());

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long time) {

                double dt = (time - val.x) / 200000000.0;

                if (dt > 0.1) {
                    val.x=time;

                    if(hero.getMood()==0){
                        hero.update(dt);
                    }
                    if(hero.getMood()==1){
                        hero.jump(dt);
                    }
                    cam.update(dt);
                    update(dt);
                }
            }
        };
        timer.start();

        this.setOnMouseClicked((click) ->{
            System.out.println("JUMP");
            hero.setMood(1);
        });



        root.getChildren().add(left.getIm());
        root.getChildren().add(right.getIm());
        root.getChildren().add(hero.getAnime());
        root.getChildren().add(vie.getIm());
    }


    public void update(double time) {

        left.getIm().setViewport(new Rectangle2D(cam.getX()%800,0,800,400));
        right.getIm().setViewport(new Rectangle2D(0,0,800,400));
        right.getIm().setX(800-cam.getX()%800);
    }


    public staticThing getLeft() {
        return left;
    }

    public staticThing getRight() {
        return right;
    }




}


