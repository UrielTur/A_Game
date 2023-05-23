import javax.swing.*;
import java.awt.*;

public class ScoreScreen extends JLabel {

    private  int counter = 0;


    public void PaintComponent(Graphics graphics){
        super.paintComponents(graphics);
        graphics.drawString(String.valueOf(counter) , 320 , 100);
        graphics.setFont(new Font("Arial", Font.BOLD, 24));

    }



}
