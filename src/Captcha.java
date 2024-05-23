import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Captcha {
    BufferedImage image;
    static String captcha;

    Captcha() {
        Number();
    }

    BufferedImage getImage() {
        return image;
    }

    static String getCaptcha() {
        return captcha;
    }

    void Number() {
        Random random = new Random();
        int a = random.nextInt(9000) + 1000;
        captcha = String.valueOf(a);
        image = new BufferedImage(150, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 150, 50);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("snap itc", Font.BOLD, 30));
        g2d.drawString(captcha, 20, 35);
        g2d.dispose();
    }

    static String ImageGUI() {
        Captcha captcha = new Captcha();
        JLabel captchaLabel = new JLabel(new ImageIcon(captcha.getImage()));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("验证码:");
        panel.add(label);
        panel.add(captchaLabel);

        return (String) JOptionPane.showInputDialog(null, panel, "验证码", JOptionPane.PLAIN_MESSAGE, null, null, "");
    }
}
