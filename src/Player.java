import javax.swing.*;
import java.awt.*;

public class Player {

    private static final int X_OF_PLAYER = 215;
    private static final int Y_OF_PLAYER = 600;

    private int imageWidth = 180;//113
    private int x;
    private int y;
    public static final int Size = 50;
    private boolean alive;


    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void paint(Graphics graphics) {
        ImageIcon imageIcon = new ImageIcon("C:/Users/USER/IdeaProjects/A_Game/src/imageIcon/nufi1.png");
//            imageIcon.getIconWidth();
        imageIcon.paintIcon(null, graphics, this.x, this.y - 100);
    }

    public void move(int dx) {
        this.x += dx;
    }

    public void stopRun() {
        if (this.x < 0) {
            this.x = 0;
        }
        if (this.x >= Window.WINDOW_WIDTH - imageWidth) {
            this.x = Window.WINDOW_WIDTH - imageWidth;
        }
    }


    public Rectangle calculateRectangle() {
        return new Rectangle(this.x, this.y, Size, Size + Size);
    }

    public boolean isAlive() {
        return this.alive;
    }

    public int getImageWidth() {
        return imageWidth;
    }
}