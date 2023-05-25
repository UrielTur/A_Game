import javax.swing.*;
import java.awt.*;

public class InstructionsScreen extends JPanel {

    public static JButton closeTheInstructions;


    public InstructionsScreen() {
        setLayout(null); // מבטל את הפרישה האוטומטית של מיקום הרכיבים בפאנל
        setPreferredSize(new Dimension(640, 710)); // מגדיר גודל רצוי לפאנל
        this.setBackground(Color.red);

        closeTheInstructions = new JButton("סגור הוראות");
        closeTheInstructions.setBounds(235, 600, 150, 50); // מגדיר מיקום וגודל לכפתור
        closeTheInstructions.setFont(new Font("Arial", Font.BOLD, 20));
        add(closeTheInstructions);


    }
}
