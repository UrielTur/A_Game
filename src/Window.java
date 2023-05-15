import javax.swing.*;

public class Window extends JFrame {

    public static  final int WINDOW_WIDTH = 650;
    public static final int WINDOW_HEIGHT = 625;

    public Window(){
        this.setResizable(false);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setSize( WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        GameScene gameScene = new GameScene();
        this.add(gameScene);


    }

    public void showWindow () {
        this.setVisible(true);
    }
}
