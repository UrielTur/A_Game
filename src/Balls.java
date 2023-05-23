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
        this.x = random.nextInt(250,350);
        this.y = -(random.nextInt(250,1100));

    }

    public void run() {
            this.y += 2;
    }

    public void runDoubleSpeed() {

        this.y += 3;
    }

    public void runThirdSpeed() {
        this.y += 4;
    }

    public void runMaxSpeed() {
        this.y += 5;
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
        this.x = random.nextInt(125,425);
        this.y = -(random.nextInt(200 , 1000));
    }

}