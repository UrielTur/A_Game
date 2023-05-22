import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public static  final int WINDOW_WIDTH = 640;//רוחב
    public static final int WINDOW_HEIGHT = 710;//גובה
    //    private  Image a =("C:/Users/USER/IdeaProjects/A_Game/src/imageIcon/רקע 1 שלם.png") ;
    public Window(){
        //Image image = new Image("C:/Users/USER/IdeaProjects/A_Game/src/imageIcon/רקע 1 שלם.png");
        this.setResizable(false);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Ball Catching");
        this.setLocationRelativeTo(null);
        GameScene game = new GameScene();
        this.add(game);
        this.setVisible(true);


    }
    public void PaintComponent(Graphics graphics){
        super.paintComponents(graphics);
        //   this.setBackground(this.color);
    }

    public void showWindow () {
        this.setVisible(true);
    }
}