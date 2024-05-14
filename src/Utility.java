import javax.swing.*;
import java.awt.*;

public class Utility {
    public static void makeButton(JButton button) {
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        button.setBackground(new Color(0, 0, 0, 0));
        button.setBorderPainted(false);
    }

    public static class JPanelWithBackground extends JPanel {
        private final Image backgroundImage;

        public JPanelWithBackground(String fileName) {
            backgroundImage = new ImageIcon(fileName).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }

    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
