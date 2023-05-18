import javax.swing.*;

public class Window extends JFrame {

    public static  final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 710;

    public Window(){
        this.setResizable(false);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Ball Catching");
        this.setLocationRelativeTo(null);
        GameScene game = new GameScene();
        this.add(game);
        this.setVisible(true);
    }

    public void showWindow () {
        this.setVisible(true);
    }
}
