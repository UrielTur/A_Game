import javax.swing.*;

public class Window extends JFrame {

    public static  final int WINDOW_WIDTH = 650;
    public static final int WINDOW_HEIGHT = 625;

    public Window(){
        this.setResizable(false);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(new GameScene());
        this.setVisible(true);
    }

    public void showWindow () {
        this.setVisible(true);
    }
}
