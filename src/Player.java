import javax.swing.*;
import java.awt.*;

public class Player {
    private int x = 350;
        private int y = 520;
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
            imageIcon.paintIcon(null, graphics, this.x, this.y);
            imageIcon.getIconWidth();
        }

        public void kill () {
            this.alive = false;
        }

//    public void revive () {
//        this.x = 0;
//        this.y = 0;
//        this.alive = true;
//    }

        public void move(int dx, int dy) {
            this.x += dx;
            this.y += dy;
        }


        public Rectangle calculateRectangle () {
            return new Rectangle(this.x, this.y, Size, Size + Size);
        }

        public boolean isAlive () {
            return this.alive;
        }

//    public boolean isClose() {
//        boolean isColse = true;
//        if (this.x >= 850 || this.x <= 250) {
//            isColse = false;
//        }
//        return isColse;
//    }
//
//    public int fromBack() {
//        if (this.x == 850) {
//            this.x = 849;
//        }
//        if (this.x == 250) {
//            this.x = 251;
//        }
//        return this.x;
//    }
}
