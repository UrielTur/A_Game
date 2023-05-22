import javax.swing.*;
import java.awt.*;

public class ScoreScreen extends JLabel {

    private  int counter = 0;

    public ScoreScreen (){
        JLabel scoreScreen = new JLabel(String.valueOf(counter));
        scoreScreen.setBounds(320,100,50,30);
        scoreScreen.setFont(new Font("Arial", Font.BOLD, 24));
        scoreScreen.setForeground(Color.black);
//        scoreScreen.setVisible(true);
    }



}
