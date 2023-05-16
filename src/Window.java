import javax.swing.*;

public class Window extends JFrame {

    public static  final int WINDOW_WIDTH = 550;
    public static final int WINDOW_HEIGHT = 800;

    public Window(){
        this.setResizable(false);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        GameScene game = new GameScene();
        this.add(game);
        this.setVisible(true);
    }

    public void showWindow () {
        this.setVisible(true);
    }
}
