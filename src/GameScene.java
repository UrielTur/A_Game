import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameScene extends JPanel implements KeyListener {

    private  Player player;
    private Balls[] balls;
    private static final int X_OF_PLAYER = 215;
    private static final int Y_OF_PLAYER = 600;
    public static final int TOTAL_BALLS = 4;


    public GameScene() {
        this.setBackground(Color.cyan);
        this.player = new Player( X_OF_PLAYER , Y_OF_PLAYER);
        this.balls = new Balls[TOTAL_BALLS];
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocus();
        for (int i = 0; i < this.balls.length; i++) {
            this.balls[i] = new Balls(7);
        }
        this.mainGameLoop();
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
            while (true) {
                repaint();
                updateBalls();
                updatePlayer();
                try {
                    Thread.sleep(9);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();
    }
    public void updatePlayer() {
        if (player.getX() < 0 || player.getX() > Window.WINDOW_WIDTH - this.player.getImageWidth()){
            player.stopRun();
        }
    }


    private void updateBalls() {
        for (int i = 0; i < balls.length; i++) {
            balls[i].run();
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int dx = 0;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = 17;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = -17;
        }
        this.player.move(dx);
        }


    public void keyReleased(KeyEvent e) {

    }

}
