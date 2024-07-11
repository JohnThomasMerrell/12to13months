import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
   private int count =0;
    private JFrame frame;
    private  JButton button;
    private JLabel label;
    private JPanel panel;
    public  GUI()
    {
        frame = new JFrame();
        button = new JButton("Clicker");
        button.addActionListener(this);
        label = new JLabel("Num of clicks:"+count);
        panel = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setBorder(BorderFactory.createEmptyBorder((int) screenSize.getHeight(), (int) screenSize.getWidth(),(int)screenSize.getHeight(),(int)screenSize.getWidth()));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Gregorian Calendar to 13 Month Calendar Converter");
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Num of clicks: "+count);
    }
}
