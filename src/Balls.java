import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Balls extends Thread {
    private int x;
    private int y;
    public static final int SIZE = 30;
    private boolean isDisappeared;
    private Random random = new Random();
    private boolean whatToPrint;

    public Balls() {
        //   this.whatToPrint = true;
        Random random = new Random();
        this.x = random.nextInt(50,500);
        this.y = -(random.nextInt(250,1200));

    }

    public void run() {
            y +=1;
            if (this.y > Window.WINDOW_HEIGHT) {
                this.y = -250;
                this.x = random.nextInt(400);
            }
    }


    public void paint(Graphics graphics, int i) {//מיכשולים

        if (i >= 2) {
            if (!this.isDisappeared) {
                ImageIcon imageIcon = new ImageIcon("C:/Users/USER/IdeaProjects/A_Game/src/imageIcon/78.png");
                imageIcon.paintIcon(null, graphics, this.x, this.y);
            }
        }
        if (i <= 2) {
            if (!this.isDisappeared) {
                ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\A_Game\\src\\imageIcon\\במבה מוכן 1.png");
                imageIcon1.paintIcon(null, graphics, this.x, this.y);
            }
        }
        //    if (i <= 4) {
          //   if (!this.isDisappeared) {
            //    ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\A_Game\\src\\imageIcon\\חלב מוכן.png");
              //  imageIcon1.paintIcon(null, graphics, this.x, this.y);
           // }
        //}
    }
    public Rectangle calculateRectangle() {
        return new Rectangle(this.x, this.y, SIZE, SIZE);
    }

    public void catchTheBalls() {

    }
}
