import javax.swing.*;
import java.awt.*;

public class Player {

    private static final int X_OF_PLAYER = 215;
    private static final int Y_OF_PLAYER = 600;

    private int imageWidth = 113;
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
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\USER\\OneDrive\\תמונות\\iconPRo.png");
//            imageIcon.getIconWidth();
            imageIcon.paintIcon(null, graphics, this.x, this.y);
        }

        public void kill () {
            this.alive = false;
        }

//    public void revive () {
//        this.x = 0;
//        this.y = 0;
//        this.alive = true;
//    }

        public void move(int dx) {
                this.x += dx;
        }

        public void stopRun() {
            if (this.x < 0){
                this.x = 0;
            }
            if (this.x >= Window.WINDOW_WIDTH - imageWidth){
                this.x = Window.WINDOW_WIDTH - imageWidth;
            }
        }


        public Rectangle calculateRectangle () {
            return new Rectangle(this.x, this.y, Size, Size + Size);
        }

        public boolean isAlive () {
            return this.alive;
        }

    public int getImageWidth() {
        return imageWidth;
    }

}
