package text;

import javax.swing.*;
import java.awt.*;

public class AllWord {
    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        JFrame frame = new JFrame("Available Fonts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        for (String fontName : fontNames) {
            JLabel label = new JLabel(fontName);
            label.setFont(new Font(fontName, Font.PLAIN, 14));
            panel.add(label);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}
