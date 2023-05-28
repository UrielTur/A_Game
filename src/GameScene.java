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
    private InstructionsScreen instructionsScreen;




    public GameScene() {
        this.startingGame = new StartingGame();
        this.instructionsScreen = new InstructionsScreen();
        StartingGame.getButtonOfStart().addActionListener(e -> { //הכנה בשביל מאור
            startingGame.setVisible(false);
            instructionsScreen.setVisible(false);
        });
        this.revalidate();

        StartingGame.getButtonOfInstructions().addActionListener(e -> { //הכנה בשביל מאור
            startingGame.setVisible(false);
            instructionsScreen.setVisible(true);
            this.revalidate();
        });

        InstructionsScreen.getCloseTheInstructions().addActionListener(e -> {
            startingGame.setVisible(true);
            instructionsScreen.setVisible(false);
            this.revalidate();
        });
        this.add(startingGame);
        this.add(instructionsScreen);
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
        this.mainGameLoop();
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
        boolean startPlay = true;
            new Thread(() -> {
                int counterOfCollision = 0;
                while (startPlay) {
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
                                this.products[i].runMaxSpeed();
                                this.products[i].goingUp();
                                counterOfCollision++;
                            }
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
                            Thread.sleep(6);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


            }).start();
    }

    private boolean collision (Products products) {
        boolean collision = false;
        if (products.catchTheProducts().intersects(this.player.calculateRectangle())){
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