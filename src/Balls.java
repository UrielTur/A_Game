import java.awt.*;
import java.util.Random;

public class Balls extends Thread {
    private int x;
    private int y = -2;
    public static final int SIZE = 30;
    private boolean isDisappeared;

    public Balls() {
        Random random = new Random();
        this.x = random.nextInt(620);
        this.y = -10;
    }

    public void run() {
        Random random = new Random();
//        boolean goingDown = random.nextBoolean();
//        int speed = random.nextInt(5, 40);
        while (true) {
//            if (goingDown){
            y+=2;
            Utils.sleep(random.nextInt(5 , 35));
            if (this.y > Window.WINDOW_HEIGHT){
                this.y = -10;
                this.x = random.nextInt(600);
            }
        }
//            Utils.sleep(speed);
    }

    public void isDisappeared() {
        this.isDisappeared = true;
    }

    public void paint (Graphics graphics) {
        if (!this.isDisappeared) {
            graphics.setColor(Color.BLACK);
            graphics.fillOval(this.x, this.y, SIZE, SIZE);
        }
    }

    public Rectangle calculateRectangle () {
        return new Rectangle(this.x, this.y, SIZE, SIZE);
    }

    public void catchTheBalls () {

    }
}
