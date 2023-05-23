import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Balls extends Thread {
    private int x;
    private int y;
    public static final int SIZE = 30;
    private Random random = new Random();

    public Balls() {
        Random random = new Random();
        this.x = random.nextInt(100,500);
        this.y = -(random.nextInt(300,1800));

    }

    public void run() {
            this.y += 1;
    }

    public void runDoubleSpeed() {
        this.y += 16;
    }

    public void runThirdSpeed() {
        this.y += 21;
    }

    public void runMaxSpeed() {
        this.y += 25;
    }





    public void paint(Graphics graphics, int i) {//מיכשולים

        if (i >= 2) {
            ImageIcon imageIcon = new ImageIcon("C:/Users/USER/IdeaProjects/A_Game/src/imageIcon/78.png");
            imageIcon.paintIcon(null, graphics, this.x, this.y);
        }
        if (i <= 2) {
            ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\A_Game\\src\\imageIcon\\במבה מוכן 1.png");
            imageIcon1.paintIcon(null, graphics, this.x, this.y);
        }
    }

    public Rectangle calculateRectangle() {
        return new Rectangle(this.x, this.y, SIZE, SIZE);
    }

    public Rectangle catchTheBalls() {
        return new Rectangle (this.x , this.y + 130 , 35, 1);
    }

    public void goingUp(){
        this.y = -250;
        this.x = random.nextInt(400);
    }
}