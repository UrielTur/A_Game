import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameScene extends JPanel implements KeyListener {

    private  Player player;
    private Balls[] balls;
    public static final int TOTAL_BALLS = 5;


    public GameScene() {
        this.setBackground(Color.cyan);
        this.player = new Player( 350 , 520);
        this.balls = new Balls[TOTAL_BALLS];
        Random random = new Random();
        int sleepTime = random.nextInt(10000);
        for (int i = 0; i < this.balls.length; i++) {
            try {
                Thread.sleep(sleepTime);
                Balls balls = new Balls();
                this.balls[i] = balls;
                balls.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.mainGameLoop();
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);
    }

    public void paintComponent (Graphics graphics){
        super.paintComponent(graphics); // כדי לא לדרוס דברים שהם הכרחיים מבהמחלקה הזאת
        this.player.paint(graphics);
        for (int i = 0; i < this.balls.length; i++) {
            this.balls[i].paint(graphics);
        }

    }


    private void mainGameLoop () {
        new Thread(() -> {
////            int waitBeforeRevive = 0;
            while (true) {
////                int dx = 0;
////                int dy = 0;
////                this.player.move(dx, dy);
////                Rectangle playerRect = this.player.calculateRectangle();
////                for (int i = 0; i < this.balls.length; i++) {
////                    Rectangle ballsRect = this.balls[i].calculateRectangle();
////                    if (Utils.checkCollision(playerRect, ballsRect)) {
////                        this.player.kill();
////                    }
////                }
////                if (!this.player.isAlive()) {
////                    waitBeforeRevive++;
////                    if (waitBeforeRevive > 300) {
////                        this.player.revive();
////                        waitBeforeRevive = 0;
////                    }
//
//                }

                Utils.sleep(3);
                repaint();
            }

        }).start();
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int dx = 0;
        int dy = 0;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = 14;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = -14;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            dy = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            dy = -0;
        }
        this.player.move(dx, dy);
    }

    public void keyReleased(KeyEvent e) {

    }

}
