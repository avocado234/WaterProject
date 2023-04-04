import javax.swing.*;
import java.awt.*;

public class iconsetter {
    private Color color = new Color(226,218,196,255);

    public JPanel getshowIconfirst(){
        JPanel panelShowIcon1 = new JPanel();
        ImageIcon tIcon = new ImageIcon(new ImageIcon("C:\\Users\\avocado\\Desktop\\water\\images\\1.png").getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH));
        JLabel label1 = new JLabel(tIcon);
        panelShowIcon1.setLayout(new BoxLayout(panelShowIcon1,BoxLayout.Y_AXIS));
        panelShowIcon1.add(label1);
        panelShowIcon1.setBackground(color);
        return panelShowIcon1;
    }

    public JPanel getshowIconsecond(){
        JPanel panelShowIcon2 = new JPanel();
        ImageIcon tIcon1 = new ImageIcon(new ImageIcon("C:\\Users\\avocado\\Desktop\\water\\images\\2.png").getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));

        JLabel label2 = new JLabel(tIcon1);
        panelShowIcon2.setLayout(new BoxLayout(panelShowIcon2,BoxLayout.Y_AXIS));
        panelShowIcon2.add(label2);
        panelShowIcon2.setBackground(color);

        return panelShowIcon2;
    }
}
