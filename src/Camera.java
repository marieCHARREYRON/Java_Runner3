import org.w3c.dom.html.HTMLImageElement;

public class Camera {
    private int x;
    private int y;
    private double Vx=10;
    private double ax;
    private double dVx;
    private double dx;
    private Hero hero;


    public Camera (int x, int y, Hero hero){

        this.x = x;
        this.y = y;
        this.hero=hero;

    }

    public int getX() {
        return x;
    }

    public int getY() {

        return y;
    }

    public String toString(){
        return "x : "+x+", y : "+y+"";
    }

    public void update(double time ) {

        this.ax= (hero.getX()-this.x)-1.2*Vx;
        this.Vx+=ax*time;
        this.x+=Vx*time;

        hero.getAnime().setX(hero.getAnime().getX()-this.x+100);



    }
}

