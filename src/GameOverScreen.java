import javax.swing.*;
import java.awt.*;

public class GameOverScreen extends JPanel {
    private JLabel textOfWelcome;
    private JLabel textOfSomeText;
    private final Color myColor =  new Color(199 , 58 , 82);





    public GameOverScreen() {
        setLayout(null); // מבטל את הפרישה האוטומטית של מיקום הרכיבים בפאנל
        setPreferredSize(new Dimension(640, 710)); // מגדיר גודל רצוי לפאנל
        this.setBackground(myColor);


        // הוספת הרכיבים לפאנל
        textOfWelcome = new JLabel("המשחק נגמר!");
        textOfWelcome.setBounds(180, 200, 550, 50); // מגדיר מיקום וגודל לתווית
        textOfWelcome.setFont(new Font("Arial" , Font.BOLD , 45));
        add(textOfWelcome);


    }
}


