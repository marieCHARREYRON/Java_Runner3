import org.w3c.dom.html.HTMLImageElement;

public class Camera {
    private int x;
    private int y;

    public Camera (int x, int y ){
        this.x = x;
        this.y = y;

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

    public void update(long time) throws Exception{
        method();}
    private void method(){

        int N = 16;
        double[] S = new double[N+1];
        double[] I = new double[N+1];
        double[] R = new double[N+1];

        S[0] = /* initial value */

                I[0] = /* initial value */

                        R[0] = /* initial value */

        double dt = time / N;

        for (int i = 0; i < 16; ++i)
        {
            double t = i*dt;
            double l = /* compute l here */
            double g = /* compute g here */

            /* calculate derivatives */
            double dSdt = - I[i] * S[i];
            double dIdt = I[i] * S[i] - g * I[i];
            double dRdt = g * I[i];

            /* now integrate using Euler */
            S[i+1] = S[i] + dSdt * dt;
            I[i+1] = I[i] + dIdt * dt;
            R[i+1] = R[i] + dRdt * dt;
        }
    }
}
