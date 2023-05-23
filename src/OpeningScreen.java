import javax.swing.*;
import java.awt.*;

public class OpeningScreen {
    private ImageIcon background;
    private final JLabel backgroundsLabel;
    private final JPanel titlePale;
    private final JButton startButton;

    public  OpeningScreen (JFrame jFrame, int OPENING_SCREEN_WIDTH, int OPENING_SCREEN_HEIGHT){
        backgroundsLabel = new JLabel(new ImageIcon("C:/Users/USER/IdeaProjects/A_Game/src/imageIcon/רקע מכולת מוכן0.png"));
        backgroundsLabel.setSize(800,800);

        titlePale = new JPanel();
        titlePale.setBounds(OPENING_SCREEN_WIDTH / 8, OPENING_SCREEN_HEIGHT / 6,OPENING_SCREEN_WIDTH / 4 * 3,OPENING_SCREEN_HEIGHT / 4);
        titlePale.setBackground(Color.BLUE.brighter());
        JLabel titleNameLabel = new JLabel("SUPER_SALL");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(new Font("Time New Romen", Font.PLAIN, 90));
        titleNameLabel.add(titleNameLabel);

        JPanel startButtonPanel = new JPanel();
        startButtonPanel.setBounds(OPENING_SCREEN_WIDTH / 8 * 3, OPENING_SCREEN_WIDTH / 6 * 4, OPENING_SCREEN_WIDTH / 4, OPENING_SCREEN_HEIGHT / 8);
        startButtonPanel.setBackground(Color.GREEN.brighter());

        startButton = new JButton("START");
        startButton.setBackground(Color.GRAY.brighter());

        startButton.setBackground(Color.BLACK);
        startButton.setFont(new Font("Times New Romen" , Font.PLAIN, 55));
        startButtonPanel.add(startButton);
        titlePale.add(startButtonPanel);

        jFrame.add(titlePale);
    }
    public JPanel getPanel(){
        return titlePale;
    }
    public JButton getStartButton(){
        return startButton;
    }
}