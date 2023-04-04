import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument.Content;

public class WaterPage1 {
    private Color color = new Color(226,218,196,255);
    private Color color1 = new Color(226, 188, 146,255);

    private Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 10);

    private Font font1 = new Font("Agency FB", Font.BOLD, 20);

    private int WaterIn = 0;
    private iconsetter seticon = new iconsetter();
    private JPanel panelMain = new JPanel();
    public WaterPage1(){
    }
    public JPanel waterPage1(JPanel page2,JLabel label,WaterPage2 waterPage2){

        JPanel panel = new JPanel();
        JPanel firstLabel = new JPanel();
        JPanel firsticon = new JPanel();
        JPanel buttonNext = new JPanel();

        panel.setBackground(color);
        firsticon.setBackground(color);
        buttonNext.setBackground(color);

        panel.setLayout(new BoxLayout( panel,BoxLayout.Y_AXIS));
        panelMain.setLayout(new BoxLayout( panelMain,BoxLayout.Y_AXIS));

        JLabel firstLa = new JLabel("Have you drunk enough water?");
        firstLa.setFont(font1);
        firstLabel.add(firstLa,SwingConstants.CENTER);
        firstLabel.setBackground(color);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(font);
        panel.add(ageLabel);

        JTextField ageTextField = new JTextField(20);
        panel.add(ageTextField);

        JLabel genderLabel = new JLabel("Gender (M/F):");
        genderLabel.setFont(font);
        panel.add(genderLabel);

        JTextField genderTextField = new JTextField(20);
        panel.add(genderTextField);

        JButton calculateButton = new JButton("Next");
        calculateButton.setFont(font);
        calculateButton.setBackground(color1);
        buttonNext.add(calculateButton);

        firsticon.add(seticon.getshowIconfirst());


        panelMain.add(firstLabel);
        panelMain.add(firsticon);
        panelMain.add(panel);
        panelMain.add(buttonNext);
        panelMain.setBackground(color);

        calculateButton.addActionListener(e->{
                int age = Integer.parseInt(ageTextField.getText());
                String gender = genderTextField.getText();
                try {
                    if(gender.equals("M") || gender.equals("F") ||gender.equals("m") || gender.equals("f") && age > 0 && age <120 ) {  //
                        checkAge checkAge = new checkAge();
                        double WaterIntake = checkAge.check(age, gender.charAt(0));
                        JOptionPane.showMessageDialog(panel,"Recommended daily water intake : " +(int)WaterIntake + " Mlliliter");
                        label.setText("Total water intake: 0 / "+(int)WaterIntake+" ml");
                        waterPage2.setml((int)WaterIntake);
                        panelMain.setVisible(false);
                        page2.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(panel, "Invalid input. Please enter a valid age and gender (M/F).", "Error", JOptionPane.ERROR_MESSAGE);
                    }

            }catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Invalid input. Please enter a valid age and gender (M/F).", "Error", JOptionPane.ERROR_MESSAGE);
                    }

    });
    return  panelMain;
  }

}

