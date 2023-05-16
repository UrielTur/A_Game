import java.awt.*;
import java.util.Random;

public class Balls extends Thread {
    private int x, speed;
    private int y = -2;
    public static final int SIZE = 30;
    private boolean isDisappeared;
    private Random random = new Random();

    public Balls(int speed) {
        Random random = new Random();
        this.x = random.nextInt(620);
        this.y = -(random.nextInt(300,1000));
        this.speed = speed;
    }

    public void run() {
            y = y+1;
            if (this.y > Window.WINDOW_HEIGHT) {
                this.y = -150;
                this.x = random.nextInt(600);
            }
    }

    public void isDisappeared() {
        this.isDisappeared = true;
    }

    public void paint(Graphics graphics) {
        if (!this.isDisappeared) {
            graphics.setColor(Color.BLACK);
            graphics.fillOval(this.x, this.y, SIZE, SIZE);
        }
    }

    public Rectangle calculateRectangle() {
        return new Rectangle(this.x, this.y, SIZE, SIZE);
    }

    public void catchTheBalls() {

    }
}
