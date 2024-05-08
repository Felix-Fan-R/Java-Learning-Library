import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.io.*;


// GUI界面类
public class Team6GUI {
    private final GarbageManagement management;
    private static final String USER_FILE = "users.txt";
    public Team6GUI() {
        management = new GarbageManagement();
    }

    // 示例GUI界面
    public void showGUI() {
        JFrame frame = new JFrame("垃圾分类宣传系统");
        JPanel panel = new JPanel();

        frame.setSize(400, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        showOtherGUI(panel);
        centerWindow(frame);
        frame.setVisible(true);
    }

    private void showOtherGUI(JPanel panel) {//登录
        panel.setLayout(null);
        JLabel usernameLabel = new JLabel("用户名:");
        JTextField usernameText = new JTextField(20);
        JLabel passwordLabel = new JLabel("密码:");
        JButton registerButton = new JButton("注册");
        JPasswordField passwordText = new JPasswordField(20);
        JButton loginButton = new JButton("登录");
        JButton forgotPasswordButton = new JButton("忘记密码");
        JButton aboutButton = new JButton("制作者");

        usernameLabel.setBounds(10, 20, 80, 25);
        usernameText.setBounds(100, 20, 165, 25);
        passwordLabel.setBounds(10, 50, 80, 25);
        registerButton.setBounds(290, 50, 80, 25);
        passwordText.setBounds(100, 50, 165, 25);
        loginButton.setBounds(10, 80, 80, 25);
        forgotPasswordButton.setBounds(290, 80, 80, 25);
        aboutButton.setBounds(290, 200, 80, 25);

        registerButton.addActionListener(e -> showRegister());
        loginButton.addActionListener(e -> login(usernameText.getText(), new String(passwordText.getPassword())));
        forgotPasswordButton.addActionListener(e -> forgotPassword());
        aboutButton.addActionListener(e -> showAboutPage());

        panel.add(usernameLabel);
        panel.add(usernameText);
        panel.add(passwordLabel);
        panel.add(registerButton);
        panel.add(passwordText);
        panel.add(loginButton);
        panel.add(forgotPasswordButton);
        panel.add(aboutButton);
    }
    private void showRegister() {//注册
        JDialog registerDialog = new JDialog((JFrame) null, "注册", true);
        JLabel usernameLabel = new JLabel("用户名:");
        JLabel passwordLabel = new JLabel("密码:");
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton registerButton = new JButton("注册");
        JPanel panel = new JPanel();
        panel.setLayout(null);

        registerDialog.setSize(300, 200);
        usernameLabel.setBounds(10, 20, 80, 25);
        usernameField.setBounds(100, 20, 160, 25);
        passwordLabel.setBounds(10, 50, 80, 25);
        passwordField.setBounds(100, 50, 160, 25);
        registerButton.setBounds(120, 80, 80, 30);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (registerUser(username, password)) {
                JOptionPane.showMessageDialog(registerDialog, "注册成功！");
                registerDialog.dispose(); // 关闭注册窗口
            } else {
                JOptionPane.showMessageDialog(registerDialog, "用户名已存在，请重新输入！");
            }
        });

        centerWindow(registerDialog);
        registerDialog.add(panel);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);
        registerDialog.setVisible(true);
    }
    private void showAdminGUI() {//管理员
        JFrame adminFrame = new JFrame("管理员界面");
        JPanel panel = new JPanel();
        JLabel nameLabel = new JLabel("垃圾名称:");
        JTextField nameText = new JTextField(20);
        JButton addButton = new JButton("添加");
        JButton deleteButton = new JButton("删除");
        JButton overviewButton = new JButton("总览");
        JButton logoutButton = new JButton("退出");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"可回收垃圾", "厨房垃圾", "有害垃圾", "医疗废物", "其他垃圾"});

        adminFrame.setSize(400, 300);
        nameLabel.setBounds(10, 20, 80, 25);
        nameText.setBounds(100, 20, 165, 25);
        addButton.setBounds(10, 80, 80, 25);
        deleteButton.setBounds(100, 80, 80, 25);
        logoutButton.setBounds(290, 80, 80, 25);
        overviewButton.setBounds(10, 230, 80, 25);
        typeComboBox.setBounds(10, 110, 165, 25);

        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        overviewButton.addActionListener(e -> showGarbage());
        addButton.addActionListener(e -> showAdd());
        deleteButton.addActionListener(e -> {
            String garbageName = nameText.getText();
            Garbage garbage = management.queryGarbage(garbageName);
            if (garbage != null) {
                showDelete(garbage);
            } else {
                JOptionPane.showMessageDialog(null, "未找到该垃圾信息", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        adminFrame.add(panel);
        panel.setLayout(null);
        panel.add(nameLabel);
        panel.add(overviewButton);
        panel.add(nameText);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(logoutButton);

        centerWindow(adminFrame);
        adminFrame.setVisible(true);

    }
    private void showUserGUI() {//用户
        JFrame userFrame = new JFrame("普通用户界面");
        JLabel nameLabel = new JLabel("垃圾名称:");
        JTextField nameText = new JTextField(20);
        JButton queryButton = new JButton("查询");
        JButton promoteButton = new JButton("宣传垃圾分类信息");
        JButton logoutButton = new JButton("退出");
        JButton overviewButton = new JButton("总览");
        JPanel panel = new JPanel();

        overviewButton.setBounds(10, 160, 80, 25);
        nameLabel.setBounds(10, 20, 80, 25);
        nameText.setBounds(100, 20, 165, 25);
        queryButton.setBounds(10, 50, 200, 25);
        userFrame.setSize(400, 300);
        promoteButton.setBounds(10, 80, 200, 25);
        logoutButton.setBounds(10, 120, 80, 25);

        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        overviewButton.addActionListener(e -> showGarbage());
        queryButton.addActionListener(e -> {
            Garbage garbage = management.queryGarbage(nameText.getText());
            if (garbage != null) {
                JOptionPane.showMessageDialog(null, "垃圾分类：" + garbage.getType().name(), "查询结果", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "未找到该垃圾分类信息", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        promoteButton.addActionListener(e -> {
            Garbage garbage = management.queryGarbage(nameText.getText());
            if (garbage != null) {
                JOptionPane.showMessageDialog(null, garbage.getName() + "属于" + garbage.getType().name(), "垃圾分类信息", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "未找到该垃圾分类信息", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        logoutButton.addActionListener(e -> userFrame.setVisible(false));

        userFrame.add(panel);
        panel.setLayout(null);
        panel.add(overviewButton);
        panel.add(nameText);
        panel.add(nameLabel);
        panel.add(promoteButton);
        panel.add(logoutButton);
        panel.add(queryButton);

        centerWindow(userFrame);
        userFrame.setVisible(true);
    }
    private void showAboutPage() {//作者
        JFrame aboutFrame = new JFrame("制作者信息");
        JPanel aboutPanel = new JPanel();
        JLabel label = new JLabel("<html><div style='text-align: center;'>第六组<br>成员：<br>范家瑞<br>龙宇翔<br>张树珍<br>刘念念</div></html>");

        aboutFrame.add(aboutPanel);
        aboutFrame.setSize(300, 200);
        aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        aboutPanel.add(label);
        centerWindow(aboutFrame);
        aboutFrame.setVisible(true);
    }
    public void login(String username, String password) {//登录
        Map<String, String> users = loadUsersFromFile();
        String storedPassword = users.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            showUserGUI();
        } else if ("admin".equals(username) && "admin123".equals(password)) {
            showAdminGUI();
        } else {
            JOptionPane.showMessageDialog(null, "用户名或密码错误！", "登录失败", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void showGarbage() {//垃圾信息总览
        JDialog overviewDialog = new JDialog((JFrame) null, "垃圾信息总览", true);
        JPanel overviewPanel = new JPanel();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> garbageList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(garbageList);

        overviewDialog.setSize(400, 300);

        centerWindow(overviewDialog);
        overviewPanel.setLayout(new BorderLayout());

        for (Garbage garbage : management.getGarbageList()) {
            listModel.addElement(garbage.toString());
        }
        overviewPanel.add(scrollPane, BorderLayout.CENTER);

        overviewDialog.add(overviewPanel);
        overviewDialog.setVisible(true);
    }
    private void showDelete(Garbage garbage) {//删除
        JDialog deleteDialog = new JDialog((JFrame) null, "确认删除", true);
        JPanel panel = new JPanel();
        JLabel messageLabel = new JLabel("确定要删除垃圾信息吗？");
        JButton confirmButton = new JButton("确认删除");
        JButton cancelButton = new JButton("取消");

        deleteDialog.setSize(300, 150);
        messageLabel.setBounds(10, 20, 280, 25);
        confirmButton.setBounds(50, 60, 100, 30);
        cancelButton.setBounds(160, 60, 100, 30);

        confirmButton.addActionListener(e -> {
            management.deleteGarbage(garbage.getName());
            deleteFromDatabase(garbage.getName()); // 删除文件中的内容
            JOptionPane.showMessageDialog(deleteDialog, "删除成功！");
            deleteDialog.dispose();
        });

        cancelButton.addActionListener(e -> deleteDialog.dispose());

        panel.setLayout(null);
        panel.add(messageLabel);
        panel.add(confirmButton);
        panel.add(cancelButton);
        deleteDialog.add(panel);

        centerWindow(deleteDialog);
        deleteDialog.setVisible(true);
    }
    private List<String> database = new ArrayList<>();
    private void deleteFromDatabase(String garbageName) {
        List<String> updatedDatabase = new ArrayList<>(); // 创建一个临时列表来保存更新后的数据库信息
        for (String line : database) {
            String[] parts = line.split(":");
            if (!parts[0].equals(garbageName)) {
                updatedDatabase.add(line);
            }
        }
        database = updatedDatabase;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt"))) {
            for (String line : updatedDatabase) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showAdd() {//添加
        JDialog addGarbageDialog = new JDialog((JFrame) null, "添加垃圾信息", true);
        JLabel nameLabel = new JLabel("垃圾名称:");
        JLabel categoryLabel = new JLabel("垃圾分类:");
        JTextField nameField = new JTextField(20);
        JComboBox<String> categoryComboBox = new JComboBox<>(new String[]{"可回收垃圾", "厨房垃圾", "有害垃圾", "医疗废物", "其他垃圾"});
        JButton confirmButton = new JButton("确认");
        JPanel panel = new JPanel();
        panel.setLayout(null);

        addGarbageDialog.setSize(300, 200);
        nameLabel.setBounds(10, 20, 80, 25);
        nameField.setBounds(100, 20, 160, 25);
        categoryLabel.setBounds(10, 50, 80, 25);
        categoryComboBox.setBounds(100, 50, 160, 25);
        confirmButton.setBounds(120, 80, 80, 30);

        confirmButton.addActionListener(e -> {
            String name = nameField.getText();
            String category = (String) categoryComboBox.getSelectedItem();
            GarbageType type = null;
            if (category != null) {
                type = GarbageType.valueOf(category.toUpperCase().replace(" ", "_"));
            }
            if (type != null) {
                management.addGarbage(name, type);
                JOptionPane.showMessageDialog(addGarbageDialog, "添加成功！");
                addGarbageDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(addGarbageDialog, "无效的垃圾分类！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        centerWindow(addGarbageDialog);
        addGarbageDialog.add(panel);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(categoryLabel);
        panel.add(categoryComboBox);
        panel.add(confirmButton);
        addGarbageDialog.setVisible(true);
    }
    private void centerWindow(Window window) {//窗口居中
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = window.getSize();
        window.setLocation((screenSize.width - windowSize.width) / 2,
                (screenSize.height - windowSize.height) / 2);
    }

    private void forgotPassword() {//忘记密码
        String username = JOptionPane.showInputDialog(null, "请输入您的用户名以找回密码:", "忘记密码", JOptionPane.QUESTION_MESSAGE);
        if (username != null && !username.isEmpty()) {
            Map<String, String> users = loadUsersFromFile();
            String password = users.get(username);
            if (password != null) {
                JOptionPane.showMessageDialog(null, "您的密码是: " + password, "密码找回", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "该用户名不存在。", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void saveUsersToFile(Map<String, String> users) {//保存用户信息
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean registerUser(String username, String password) {//注册
        Map<String, String> users = loadUsersFromFile();
        if (!users.containsKey(username)) {
            users.put(username, password);
            saveUsersToFile(users);
            return true;
        }
        return false;
    }
    private Map<String, String> loadUsersFromFile() {//读取用户信息
        Map<String, String> users = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Team6GUI gui = new Team6GUI();
            gui.showGUI();
        });
    }

}