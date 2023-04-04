
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainframe extends JFrame{

    JFrame frame = new JFrame("Drink water");
    private Color color = new Color(226,218,196,255);
    private JPanel panelFirst = new JPanel();
    private JPanel panelSecond = new JPanel();

    private  JPanel panelThird = new JPanel();
    private  WaterPage1 waterPage1 = new WaterPage1();
    private  WaterPage2 waterPage2 = new WaterPage2();

public mainframe () {
     setFirst();
     setSecond();
    createJFrame();
}
private void createJFrame(){
    frame.setLocation(700, 300);
    frame.setSize(400,400);
    frame.getContentPane().setBackground(color);
    frame.setResizable(false);
    frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    this.frame.setBackground(color);
}
private void setFirst(){
    panelFirst.setLayout(new BoxLayout(panelFirst,BoxLayout.Y_AXIS));
    panelFirst.add(waterPage1.waterPage1(panelSecond,waterPage2.getIntakeLabel(), waterPage2));
    panelFirst.setBackground(color);
    frame.add(panelFirst);
}
private void setSecond(){
    panelSecond.setLayout(new FlowLayout());
    panelSecond.add(waterPage2.waterPage2(panelFirst));
    panelSecond.setBackground(color);
    frame.add(panelSecond);
    panelSecond.setVisible(false);

}

    public static void main(String[] args) {
        new mainframe();
       }
    }

