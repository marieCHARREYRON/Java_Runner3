import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;





public class Hero extends AnimatedThing{
    private  ImageView Anime;
    private int offset=12;
    private int index=0;
    private int size=80;
    private double vx=80;
    private double vy=80;
    private double x;
    private double y;
    private double ay=10;
    double gravity=10;

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
                    val.x=time;   //restabilise la valeur du time
                    Anime.setViewport(new Rectangle2D(offset+(size*index),0,75,100));
                    Anime.setX(200);
                    Anime.setY(250);
                    index++;
                    if(index==5){
                        index=0;
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
       this.vy+=time*(gravity);
       this.y= vy*time;
       Anime.setX(x);

       if((Hero.super.getMood())==1){
           jump(time);
       }
    }

    public void jump(double time){

        this.x+=vx*time;
        this.y+=vy*time;

        this.vy+=time*(gravity);
        //this.vx+=time*(gravity);

        Anime.setX(x);
        Anime.setY(y);

        if(y>150){

        }

    }

    public double getX() {
        return x;
    }
}

