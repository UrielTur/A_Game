import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScene extends JPanel implements KeyListener {

    private Player player;
    private Balls[] balls;
    private static final int X_OF_PLAYER = 215;
    private static final int Y_OF_PLAYER = 600;
    public static final int TOTAL_PRODUCTS = 5;
    private boolean[] pressedKey;

    private Background background;
    private ScoreScreen scoreScreen;


    public GameScene() {
        this.pressedKey = new boolean[2];
        this.background = new Background();
        this.player = new Player(X_OF_PLAYER, Y_OF_PLAYER);
        this.balls = new Balls[TOTAL_PRODUCTS];
        //  this.scoreScreen = new ScoreScreen();
        //    this.add(scoreScreen);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocus();
        for (int i = 0; i < this.balls.length; i++) {
            this.balls[i] = new Balls();
        }
        this.mainGameLoop();
        this.addKeyListener(this);

    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics); // כדי לא לדרוס דברים שהם הכרחיים מבהמחלקה הזאת
        this.background.paint(graphics);
//        this.scoreScreen.paint(graphics);
        this.player.paint(graphics);

        for (int i = 0; i < this.balls.length; i++) {
            this.balls[i].paint(graphics, i);
        }
    }



    private void mainGameLoop() {
        new Thread(() -> {
            int counterOfCollision = 0;
            while (true) {
                repaint();
                updateBalls();
                updatePlayer();
                if (counterOfCollision <= 10){
                for (int i = 0; i < balls.length; i++) {
                    if (this.collision(balls[i])) {
                        this.balls[i].run();
                        this.balls[i].goingUp();
                        counterOfCollision++;
                    }
                }
                }
                if (counterOfCollision > 10){
                    for (int i = 0; i < balls.length; i++) {
                        if (this.collision(balls[i])) {
                            this.balls[i].runDoubleSpeed();
                            this.balls[i].goingUp();
                            counterOfCollision++;
                    }
                    }
                }
                int dx = 0;
                try {
                    if (pressedKey[0])
                        dx += 3;
                    if (pressedKey[1])
                        dx -= 3;
                    this.player.move(dx);
                    if (counterOfCollision <= 10) {
                        Thread.sleep(11);
                    } else {
                        Thread.sleep(9);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();
    }

    private boolean collision (Balls balls) {
        boolean collision = false;
        if (balls.catchTheBalls().intersects(this.player.calculateRectangle())){
            collision = true;
        }

        return collision;
    }

    public void updatePlayer() {
        if (player.getX() < 0 || player.getX() > Window.WINDOW_WIDTH - this.player.getImageWidth()) {
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
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pressedKey[0] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pressedKey[1] = true;
        }
    }


    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pressedKey[0] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pressedKey[1] = false;
        }

    }
}