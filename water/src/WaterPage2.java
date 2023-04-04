import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class WaterPage2 {
    private double totalIntake;
    private int waterml;
    private Font font = new Font("Agency FB", Font.BOLD, 20);

    private Font font1 = new Font("Arial Rounded MT Bold", Font.BOLD, 10);
    private ArrayList<String> list = new ArrayList<>();
    private Color color = new Color(226,218,196,255);
    private Color color1 = new Color(226, 188, 146,255);

    private iconsetter seticon = new iconsetter();
    private JLabel totalIntakeLabel = new JLabel("Total water intake: 0 / ml");

    private JPanel panelMain1 = new JPanel();

    public JLabel getIntakeLabel(){
        return  totalIntakeLabel;
    }
    public void setml(int ml){
        this.waterml = ml;
    }
    public int getml(){
        return this.waterml;
    }
    public JPanel waterPage2(JPanel page1){
        totalIntake = 0;

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panelforholdIcon = new JPanel();
        JPanel panelforTextField = new JPanel();


        panel.setBackground(color);
        panel1.setBackground(color);
        panel2.setBackground(color);
        panelMain1.setBackground(color);
        panelforTextField.setBackground(color);
        panelforholdIcon.setBackground(color);

        panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
        panelMain1.setLayout(new BoxLayout(panelMain1,BoxLayout.Y_AXIS));

        panelforholdIcon.add(seticon.getshowIconsecond());

        totalIntakeLabel.setFont(font);
        panel.add(totalIntakeLabel);

        JTextField textField1 = new JTextField("100", 10);
        textField1.setEditable(false);
        textField1.setBackground(Color.WHITE);
        panelforTextField.add(textField1);

        JButton editButton1 = createEditButton(textField1);
        editButton1.setBackground(color1);
        panel1.add(editButton1);
        panel1.add(Box.createRigidArea(new Dimension(10,0)));

        JButton addButton1 = createAddButton(textField1, totalIntakeLabel,page1);
        addButton1.setBackground(color1);
        panel1.add(addButton1);

        JButton resetButton = reSetButton(totalIntakeLabel);
        panel2.add(resetButton);

        JButton historyButton = historyButton();
        panel2.add(historyButton);

        JButton saveButton = new JButton("Save");
        saveButton.setFont(font1);
        saveButton.setBackground(color1);
        saveButton.addActionListener(e -> {
            saveHistory();
        });
        panel2.add(saveButton);


        panelMain1.add(panelforholdIcon);
        panelMain1.add(panel);
        panelMain1.add(panelforTextField);
        panelMain1.add(panel1);
        panelMain1.add(Box.createRigidArea(new Dimension(10,50)));
        panelMain1.add(panel2);


        return panelMain1;
    }

    private JButton createEditButton(JTextField textField) {
        JButton editButton = new JButton("Edit");
        editButton.setFont(font1);

        editButton.addActionListener(e -> {
            textField.setEditable(true);
            textField.requestFocus();
        });
        return editButton;
    }
    private JButton createAddButton(JTextField textField, JLabel totalIntakeLabel,JPanel page1) {
        JButton addButton = new JButton("Add");
        addButton.setFont(font1);
        addButton.addActionListener(e -> {
            double intake = Double.parseDouble(textField.getText());
            totalIntake += intake;
            totalIntakeLabel.setText("Total water intake: " + (int) totalIntake + " / " + getml() + " ml");
            textField.setEditable(false);
            page1.setVisible(false);
        });
        return addButton;
    }

    private JButton reSetButton(JLabel totalIntakeLabel){
        JButton resetButton = new JButton("reset");
        resetButton.setFont(font1);
        resetButton.setBackground(color1);
        resetButton.addActionListener(e ->{
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDate = dateFormat.format(c.getTime());
            if(totalIntake<getml()){
                JOptionPane.showMessageDialog(panelMain1,"Today you did not drink enough to meet the prescribed amount.","Water",JOptionPane.INFORMATION_MESSAGE);
            }
            list.add("Total Intake: " + totalIntake + " ml at " + currentDate);
            totalIntake = 0;
            totalIntakeLabel.setText("Total water intake: 0 / "+ getml() +" ML");

        });
        return resetButton;
    }

    private JButton historyButton() {
        JButton historyButton = new JButton("History");
        historyButton.setFont(font1);
        historyButton.setBackground(color1);
        historyButton.addActionListener(e -> {
            StringBuilder history = new StringBuilder("Water Intake History:\n\n");
            for (String entry : list) {
                history.append(entry).append("\n");
            }
            JOptionPane.showMessageDialog(null, history.toString(), "Water Intake History", JOptionPane.INFORMATION_MESSAGE);
        });

        return historyButton;
    }

    private void saveHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("water_history.txt"))) {
            for (String entry : list) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
