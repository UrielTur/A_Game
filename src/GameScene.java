import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScene extends JPanel implements KeyListener {

    private Player player;
    private Products[] products;
    private static final int X_OF_PLAYER = 215;
    private static final int Y_OF_PLAYER = 600;
    private static final int TOTAL_PRODUCTS = 4;
    private boolean[] pressedKey;

    private Background background;
    private StartingGame startingGame;
    private GameOverScreen gameOverScreen;



    public GameScene() {
        this.startingGame = new StartingGame();
        this.gameOverScreen = new GameOverScreen();
        StartingGame.getButtonOfStart().addActionListener(e -> { //הכנה בשביל מאור
            startingGame.setVisible(false);
            this.mainGameLoop();
        });
        this.revalidate();
        this.add(startingGame);
        this.gameOverScreen = new GameOverScreen();
        this.pressedKey = new boolean[2];
        this.background = new Background();
        this.player = new Player(X_OF_PLAYER, Y_OF_PLAYER);
        this.products = new Products[TOTAL_PRODUCTS];
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocus();
        for (int i = 0; i < this.products.length; i++) {
            this.products[i] = new Products();
        }
        this.addKeyListener(this);


    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics); // כדי לא לדרוס דברים שהם הכרחיים מבהמחלקה הזאת
        this.background.paint(graphics);
        this.player.paint(graphics);

        for (int i = 0; i < this.products.length; i++) {
            this.products[i].paint(graphics, i);
        }
    }


    private void mainGameLoop() {
        new Thread(() -> {


            int counterOfCollision = 0;
            int fullCount = 0;
            boolean run = checkProducts();
            while (run) {
                run = fullCount<3;
                if (!run){
                    gameOverScreen.setVisible(true);
                    this.revalidate();
                    this.add(gameOverScreen);
                }
                repaint();
                updateBalls();
                updatePlayer();
                if (counterOfCollision <= 10) {
                    for (int i = 0; i < products.length; i++) {
                        if (this.collision(products[i])) {
                            this.products[i].run();
                            this.products[i].goingUp();
                            counterOfCollision++;
                        }
                    }
                }
                if (counterOfCollision > 10 && counterOfCollision <= 20) {
                    for (int i = 0; i < products.length; i++) {
                        if (this.collision(products[i])) {
                            this.products[i].runDoubleSpeed();
                            this.products[i].goingUp();
                            counterOfCollision++;
                        }
                    }
                }
                if (counterOfCollision > 20 && counterOfCollision <= 30) {
                    for (int i = 0; i < products.length; i++) {
                        if (this.collision(products[i])) {
                            this.products[i].runThirdSpeed();
                            this.products[i].goingUp();
                            counterOfCollision++;
                        }
                    }
                }
                if (counterOfCollision > 30) {
                    for (int i = 0; i < products.length; i++) {
                        if (this.collision(products[i])) {
                            this.products[i].runfourSpeed();
                            this.products[i].goingUp();
                            counterOfCollision++;
                        }
                    }
                }
                else {
                    for (int i = 0; i < products.length; i++) {
                        if (this.collision(products[i])) {
                            this.products[i].runMaxSpeed();
                            this.products[i].goingUp();
                            counterOfCollision++;
                        }
                    }
                }
                for (int i = 0; i < products.length; i++) {

                    if (this.products[i].inWindowHeight()) {
                        fullCount++;
                        this.products[i].goingUp();
                    }
                }
                int dx = 0;
                try {
                    if (pressedKey[0])
                        dx += 4;
                    if (pressedKey[1])
                        dx -= 4;
                    this.player.move(dx);
                    if (counterOfCollision <= 5) {
                        Thread.sleep(10);
                    } else if (5 < counterOfCollision && counterOfCollision <= 20) {
                        Thread.sleep(9);
                    } else if (20 < counterOfCollision) {
                        Thread.sleep(5);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();
    }

    private boolean checkProducts() {
        int counter = 0;
        for (int i = 0; i < this.products.length; i++) {
            if (!this.products[i].inLimit()) {
                counter++;
                if (counter == 3) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean collision(Products products) {
        boolean collision = false;
        if (products.catchTheProducts().intersects(this.player.calculateRectangle())) {
            collision = true;
        }

        return collision;
    }


    public void updatePlayer() {
        if (player.getX() < 0 || player.getX() > (Window.getWindowWidth() - player.getImageWidth())) {
            player.stopRun();
        }
    }


    private void updateBalls() {
        for (int i = 0; i < products.length; i++) {
            products[i].run();
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