import javax.swing.*;

public class GarbageClassificationSystemGUI {
    private GarbageManagement management;
    private User currentUser;
    public GarbageClassificationSystemGUI() {
        management = new GarbageManagement();
    }
    public void showGUI() {
        JFrame chuangkou = new JFrame("垃圾分类宣传系统");
        chuangkou.setSize(400, 300);
        chuangkou.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        chuangkou.add(panel);
        zujian(panel);
        chuangkou.setVisible(true);
    }
    private void zujian(JPanel panel) {
        panel.setLayout(null);
        JLabel yonghumingLabel = new JLabel("用户名:");
        yonghumingLabel.setBounds(10, 20, 80, 25);
        panel.add(yonghumingLabel);
        JTextField yomghumingText = new JTextField(20);
        yomghumingText.setBounds(100, 20, 165, 25);
        panel.add(yomghumingText);
        JLabel mimaLabel = new JLabel("密码:");
        mimaLabel.setBounds(10, 50, 80, 25);
        panel.add(mimaLabel);
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton dengluButton = new JButton("登录");
        dengluButton.setBounds(10, 80, 80, 25);
        dengluButton.addActionListener(e -> login(yomghumingText.getText(), new String(passwordText.getPassword())));
        panel.add(dengluButton);
        JButton aboutButton = new JButton("制作者");
        aboutButton.setBounds(290, 200, 80, 25);
        aboutButton.addActionListener(e -> showAboutPage());
        panel.add(aboutButton);
    }

    public void login(String username, String password) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            currentUser = new User(username, password, UserType.ADMIN);
            showAdminGUI();
        } else {
            currentUser = new User(username, password, UserType.USER);
            showUserGUI();
        }
    }

    private void showAdminGUI() {

        JFrame adminFrame = new JFrame("管理员界面");
        adminFrame.setSize(400, 300);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        adminFrame.add(panel);
        panel.setLayout(null);
        JLabel nameLabel = new JLabel("垃圾名称:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);
        JLabel categoryLabel = new JLabel("垃圾分类:");
        categoryLabel.setBounds(10, 50, 80, 25);
        panel.add(categoryLabel);
        JTextField categoryText = new JTextField(20);
        categoryText.setBounds(100, 50, 165, 25);
        panel.add(categoryText);

        JButton addButton = new JButton("添加");
        addButton.setBounds(10, 80, 80, 25);
        addButton.addActionListener(e -> management.addGarbage(nameText.getText(), categoryText.getText()));
        panel.add(addButton);
        JButton deleteButton = new JButton("删除");
        deleteButton.setBounds(100, 80, 80, 25);
        deleteButton.addActionListener(e -> management.deleteGarbage(nameText.getText()));
        panel.add(deleteButton);
        JButton updateButton = new JButton("修改");
        updateButton.setBounds(190, 80, 80, 25);
        updateButton.addActionListener(e -> management.updateGarbage(nameText.getText(), categoryText.getText()));
        panel.add(updateButton);
        JButton queryButton = new JButton("查询");
        queryButton.setBounds(280, 80, 80, 25);
        queryButton.addActionListener(e -> {
            Garbage garbage = management.queryGarbage(nameText.getText());
            if (garbage != null) {
                JOptionPane.showMessageDialog(null, "垃圾分类：" + garbage.getCategory(), "查询结果", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "未找到该垃圾分类信息", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(queryButton);
        JButton logoutButton = new JButton("注销");
        logoutButton.setBounds(10, 120, 80, 25);
        logoutButton.addActionListener(e -> {
            currentUser = null;
            adminFrame.setVisible(false);

        });
        panel.add(logoutButton);
        adminFrame.setVisible(true);
    }

    private void showUserGUI() {
        JFrame userFrame = new JFrame("普通用户界面");
        userFrame.setSize(400, 300);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        userFrame.add(panel);
        panel.setLayout(null);
        JLabel nameLabel = new JLabel("垃圾名称:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);
        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);
        JButton queryButton = new JButton("查询");
        queryButton.setBounds(10, 50, 200, 25);
        queryButton.addActionListener(e -> {
            Garbage garbage = management.queryGarbage(nameText.getText());
            if (garbage != null) {
                JOptionPane.showMessageDialog(null, "垃圾分类：" + garbage.getCategory(), "查询结果", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "未找到该垃圾分类信息", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(queryButton);

        JButton promoteButton = new JButton("宣传垃圾分类信息");
        promoteButton.setBounds(10, 80, 200, 25);
        promoteButton.addActionListener(e -> {
            Garbage garbage = management.queryGarbage(nameText.getText());
            if (garbage != null) {
                JOptionPane.showMessageDialog(null, garbage.getName() + "属于" + garbage.getCategory(), "垃圾分类信息", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "未找到该垃圾分类信息", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(promoteButton);
        JButton logoutButton = new JButton("注销");
        logoutButton.setBounds(10, 120, 80, 25);
        logoutButton.addActionListener(e -> {
            currentUser = null;
            userFrame.setVisible(false);

        });
        panel.add(logoutButton);

        userFrame.setVisible(true);
    }
    private void showAboutPage() {
        JFrame aboutFrame = new JFrame("制作者信息");
        aboutFrame.setSize(300, 200);
        aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel aboutPanel = new JPanel();
        aboutFrame.add(aboutPanel);

        JLabel label = new JLabel("<html><div style='text-align: center;'>第六组<br>成员：<br>范家瑞<br>龙宇翔<br>张树珍<br>刘念念</div></html>");
        aboutPanel.add(label);

        aboutFrame.setVisible(true);
    }
    public static void main(String[] args) {
        GarbageClassificationSystemGUI gui = new GarbageClassificationSystemGUI();
        gui.showGUI();
    }
}
