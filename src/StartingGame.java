import javax.swing.*;
import java.awt.*;

public class StartingGame extends JPanel {


    private JLabel textOfWelcome;
    private JLabel textOfSomeText;
    private final Color myColor =  new Color(199 , 58 , 82);


    public static JButton buttonOfStart;
    public static JButton buttonOfInstructions; //כפתור בשביל ההוראות


    public StartingGame() {
        setLayout(null); // מבטל את הפרישה האוטומטית של מיקום הרכיבים בפאנל
        setPreferredSize(new Dimension(640, 710)); // מגדיר גודל רצוי לפאנל
        this.setBackground(myColor);


        // הוספת הרכיבים לפאנל
        textOfWelcome = new JLabel("ברוכים הבאים לשפע יששכר!");
        textOfWelcome.setBounds(65, 100, 550, 50); // מגדיר מיקום וגודל לתווית
        textOfWelcome.setFont(new Font("Arial" , Font.BOLD , 45));
        add(textOfWelcome);

        textOfSomeText = new JLabel("''קופה ראשית'' - המשחק");
        textOfSomeText.setBounds(180, 150, 400, 50); // מגדיר מיקום וגודל לתווית
        textOfSomeText.setFont(new Font("Arial" , Font.ITALIC , 26));
        add(textOfSomeText);

        buttonOfStart = new JButton("התחל");
        buttonOfStart.setBounds(235, 250, 150, 50); // מגדיר מיקום וגודל לכפתור
        buttonOfStart.setFont(new Font("Arial" , Font.BOLD , 20));
        add(buttonOfStart);


        buttonOfInstructions = new JButton("הוראות");
        buttonOfInstructions.setBounds(235, 350, 150, 50); // מגדיר מיקום וגודל לכפתור
        buttonOfInstructions.setFont(new Font("Arial" , Font.BOLD , 20));
        add(buttonOfInstructions);


    }

//    public boolean ifVisible



    }
