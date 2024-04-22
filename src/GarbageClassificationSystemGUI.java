import javax.swing.*;

// GUI界面类
public class GarbageClassificationSystemGUI {
    private GarbageManagement management; // 垃圾管理系统对象
    private User currentUser; // 当前用户对象

    public GarbageClassificationSystemGUI() {
        management = new GarbageManagement(); // 创建垃圾管理系统实例
    }

    // 示例GUI界面
    public void showGUI() {
        JFrame frame = new JFrame("垃圾分类宣传系统"); // 创建顶层窗口
        frame.setSize(400, 300); // 设置窗口大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作

        JPanel panel = new JPanel(); // 创建面板
        frame.add(panel); // 将面板添加到窗口

        // 添加组件到面板
        placeComponents(panel);

        frame.setVisible(true); // 设置窗口可见
    }

    // GUI界面组件
    private void placeComponents(JPanel panel) {
        panel.setLayout(null); // 使用空布局管理器

        // 添加用户名标签和文本框
        JLabel usernameLabel = new JLabel("用户名:");
        usernameLabel.setBounds(10, 20, 80, 25);
        panel.add(usernameLabel);

        JTextField usernameText = new JTextField(20);
        usernameText.setBounds(100, 20, 165, 25);
        panel.add(usernameText);

        // 添加密码标签和密码框
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // 添加登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(e -> login(usernameText.getText(), new String(passwordText.getPassword())));
        panel.add(loginButton);

        // 添加制作者按钮到登录面板的右下角
        JButton aboutButton = new JButton("制作者");
        aboutButton.setBounds(290, 200, 80, 25);
        aboutButton.addActionListener(e -> showAboutPage());
        panel.add(aboutButton);
    }

    // 登录方法
    public void login(String username, String password) {
        // 这里可以根据实际情况进行验证，这里简化为直接匹配用户名和密码
        if ("admin".equals(username) && "admin123".equals(password)) {
            currentUser = new User(username, password, UserType.ADMIN); // 创建管理员用户对象
            showAdminGUI(); // 显示管理员界面
        } else {
            currentUser = new User(username, password, UserType.USER); // 创建普通用户对象
            showUserGUI(); // 显示普通用户界面
        }
    }

    // 显示管理员界面
    private void showAdminGUI() {
        // 实现管理员界面，包括增删改查垃圾分类信息等功能
        JFrame adminFrame = new JFrame("管理员界面"); // 创建管理员界面窗口
        adminFrame.setSize(400, 300); // 设置窗口大小
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作

        JPanel panel = new JPanel(); // 创建面板
        adminFrame.add(panel); // 将面板添加到窗口
        panel.setLayout(null); // 使用空布局管理器

        // 添加垃圾名称标签和文本框
        JLabel nameLabel = new JLabel("垃圾名称:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        // 添加垃圾分类标签和文本框
        JLabel categoryLabel = new JLabel("垃圾分类:");
        categoryLabel.setBounds(10, 50, 80, 25);
        panel.add(categoryLabel);

        JTextField categoryText = new JTextField(20);
        categoryText.setBounds(100, 50, 165, 25);
        panel.add(categoryText);

        // 添加添加、删除、修改、查询按钮
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
            currentUser = null; // 清空当前用户信息
            adminFrame.setVisible(false); // 隐藏管理员界面窗口

        });
        panel.add(logoutButton);


        adminFrame.setVisible(true); // 显示管理员界面窗口
    }

    // 显示普通用户界面
    private void showUserGUI() {
        // 实现普通用户界面，包括查询和宣传垃圾分类信息等功能
        JFrame userFrame = new JFrame("普通用户界面"); // 创建普通用户界面窗口
        userFrame.setSize(400, 300); // 设置窗口大小
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作

        JPanel panel = new JPanel(); // 创建面板
        userFrame.add(panel); // 将面板添加到窗口
        panel.setLayout(null); // 使用空布局管理器

        // 添加垃圾名称标签和文本框
        JLabel nameLabel = new JLabel("垃圾名称:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        // 添加查询和宣传垃圾分类信息按钮
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
            currentUser = null; // 清空当前用户信息
            userFrame.setVisible(false); // 隐藏普通用户界面窗口

        });
        panel.add(logoutButton);

        userFrame.setVisible(true); // 显示普通用户界面窗口
    }
    // 显示制作者信息页面

    private void showAboutPage() {
        JFrame aboutFrame = new JFrame("制作者信息");
        aboutFrame.setSize(300, 200);
        aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 设置为释放当前窗口的默认关闭操作

        JPanel aboutPanel = new JPanel();
        aboutFrame.add(aboutPanel);

        JLabel label = new JLabel("<html><div style='text-align: center;'>第六组<br>成员：<br>范家瑞<br>龙宇翔<br>张树珍<br>刘念念</div></html>");
        aboutPanel.add(label);

        aboutFrame.setVisible(true);
    }

    public static void main(String[] args) {
        GarbageClassificationSystemGUI gui = new GarbageClassificationSystemGUI();
        gui.showGUI(); // 显示GUI界面
    }
}
