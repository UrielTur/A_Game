import javax.swing.*;

public class Window extends JFrame {

    private static int WINDOW_WIDTH = 640;//רוחב
    private static int WINDOW_HEIGHT = 710;//גובה

    public Window(){
        this.setResizable(false);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Super Sall");
        this.setLocationRelativeTo(null);
        GameScene game = new GameScene();
        this.add(game);


    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public void showWindow () {
        this.setVisible(true);
    }


}