import javax.swing.*;
import java.awt.*;

public class StartingGame extends JPanel {


    private JLabel textOfWelcome;
    private JLabel textOfSomeText;
    private final Color myColor =  new Color(199 , 58 , 82);
    private JLabel instruction = new JLabel("<html>ytfkuvuybi<br>hgbnnk<br>mnkj");


    private static JButton buttonOfStart;
    private static JButton buttonOfInstructions; //כפתור בשביל ההוראות
    private ImageIcon image;


    public StartingGame() {
        setLayout(null); // מבטל את הפרישה האוטומטית של מיקום הרכיבים בפאנל
        setPreferredSize(new Dimension(640, 710)); // מגדיר גודל רצוי לפאנל
        this.setBackground(myColor);
        JLabel instruction = new JLabel("<html><br>ברוכים הבאים לסופר!<br> עליכם לתפוס את המוצרים בעזרת עגלת הקניות.  <br> במקרה ותפספסו 3 מוצרים המשחק ייגמר. <br> קצב המשחק עולה לאחר כל 5 תפיסת מוצרים. <br> היעזרו במקשים 'ימינה' ו-'שמאלה' כדי לתפוס את המוצרים. <br> בהצלחה!");
        instruction.setBounds(150, 220, 640, 200); // מגדיר מיקום וגודל לתווית
        instruction.setFont(new Font("Arial" , Font.CENTER_BASELINE , 20));
        add(instruction);


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
        buttonOfStart.setBounds(235, 450, 150, 50); // מגדיר מיקום וגודל לכפתור
        buttonOfStart.setFont(new Font("Arial" , Font.BOLD , 20));
        add(buttonOfStart);


    }

//     public void paintComponent(Graphics graphics){
//        graphics.drawImage(image, 200, 400, null);
//    }

    public static JButton getButtonOfStart() {
        return buttonOfStart;
    }

    public static JButton getButtonOfInstructions() {
        return buttonOfInstructions;
    }

}
