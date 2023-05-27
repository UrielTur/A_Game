import javax.swing.*;
import java.awt.*;

public class Background {

    private static int X = 0;
    private static final int Y = 0;

    public Background(){

    }
    public void paint(Graphics graphics){
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\A_Game\\src\\imageIcon\\רקע מכולת מוכן0.png");
        backgroundImage.paintIcon(null,graphics,X,Y);

    }
}
