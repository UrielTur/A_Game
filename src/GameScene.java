import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameScene extends JPanel implements KeyListener {

    private  Player player;
    private Balls[] balls;
    public static final int TOTAL_BALLS = 3;


    public GameScene() {
        this.setBackground(Color.cyan);
        this.player = new Player( 350 , 520);
        this.balls = new Balls[TOTAL_BALLS];
//        Random random = new Random();
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocus();
        for (int i = 0; i < this.balls.length; i++) {
            //  int sleepTime = random.nextInt(5)+2;
            this.balls[i] = new Balls(8);
        }
        this.mainGameLoop();
        this.addKeyListener(this);
    }

    public void paintComponent (Graphics g){
        super.paintComponent(g); // כדי לא לדרוס דברים שהם הכרחיים מבהמחלקה הזאת
        this.player.paint(g);
        for (int i = 0; i < this.balls.length; i++) {
            this.balls[i].paint(g);
        }


    }


    private void mainGameLoop () {
        new Thread(() -> {
            while (true) {
                repaint();
                updateBalls();
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();
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
        switch (e.getKeyCode()){
            case  KeyEvent.VK_RIGHT -> this.player.move(7);
            case  KeyEvent.VK_LEFT -> this.player.move(-7);
        }
    }

    public void keyReleased(KeyEvent e) {

    }

}
