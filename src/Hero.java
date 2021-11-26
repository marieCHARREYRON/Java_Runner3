import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;





public class Hero extends AnimatedThing{
    private  ImageView Anime;
    private int offset=12;
    private int index=0;
    private int index2=0;
    private int size=80;
    private double vx=80;
    private double vy=-40;
    private double x;
    private double y;
    double gravity=10;
    private boolean b;

    public Hero (int Mood,double x, double y, String fileName){

        super(Mood,x, y, fileName);
        Image spriteSheet = new Image(fileName);
        Anime = new ImageView(spriteSheet);
        Anime.setViewport(new Rectangle2D(20, 0, 75, 100));
        Anime.setX(x);
        Anime.setY(y);

        longVal val = new longVal(System.nanoTime());

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long time) {

                double dt = (time - val.x) / 200000000.0;

                if (dt > 0.5) {

                    if(Hero.super.getMood()==0) {
                        val.x = time;   //restabilise la valeur du time
                        Anime.setViewport(new Rectangle2D(offset + (size * index), 0, 75, 100));
                        index++;
                        if (index == 5) {
                            index = 0;
                        }
                    }
                    if(Hero.super.getMood()==1) {
                        if (vy > 0) {
                            index2 = 1;
                            Anime.setViewport(new Rectangle2D(offset + (size * index2), 160, 75, 100));
                        } else {
                            index2 = 0;
                            Anime.setViewport(new Rectangle2D(offset + (size * index2), 160, 75, 100));
                        }
                    }
                }
            }
        };
        timer.start();

    }

    public ImageView getAnime() {
        return Anime;
    }

    public void update(double time){
       this.x+=vx*time;
       this.y=240;
       this.Anime.setX(x);
       this.Anime.setY(y);


    }


    public void jump(double time){

        this.x+=vx*time;
        this.y+=vy*time;
        this.vy+=time*(gravity);


        if(y>=250){
            Hero.super.setMood(0);
            vy=-40;
        }
        this.Anime.setX(x);
        this.Anime.setY(y);

    }
    public double getX() {return x;}
    public double getY() {return y;}
}

