import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Barchart extends JApplet {

    private JTextField[] courseFields = new JTextField[5];
    private int[] passPercentages = new int[5];

    public void init() {
        setLayout(new FlowLayout());

        for (int i = 0; i < 5; i++) {
            courseFields[i] = new JTextField(5);
            courseFields[i].setHorizontalAlignment(JTextField.CENTER);
            add(new JLabel("Course " + (i + 1) + ":"));
            add(courseFields[i]);
        }

        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 5; i++) {
                    try {
                        passPercentages[i] = Integer.parseInt(courseFields[i].getText());
                    } catch (NumberFormatException ex) {
                        passPercentages[i] = 0;
                    }
                }
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);

        int x = 50;
        int y = 50;
        int barWidth = 20;
        int maxPercentage = getMaxPercentage();

        for (int i = 0; i < 5; i++) {
            int barHeight = (passPercentages[i] * 100) / maxPercentage;
            g.setColor(Color.blue);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.black);
            g.drawRect(x, y, barWidth, barHeight);
            g.drawString("Course " + (i + 1), x, y + barHeight + 15);
            x += 60;
        }
    }

    private int getMaxPercentage() {
        int max = passPercentages[0];
        for (int percentage : passPercentages) {
            if (percentage > max) {
                max = percentage;
            }
        }
        return max;
    }
}

/*
 <applet code="PassPercentageChart" width =300 height=100>
 </applet>*/