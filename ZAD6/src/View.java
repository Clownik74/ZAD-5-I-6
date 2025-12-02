import javax.swing.*;

public class View extends JFrame {

    JTextField loginField;
    JPasswordField hasloField;
    JButton loginButton;
    JLabel statusLabel;

    public View() {

        setTitle("System logowania");
        setSize(350, 220);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(30, 20, 80, 25);

        loginField = new JTextField();
        loginField.setBounds(120, 20, 160, 25);

        JLabel hasloLabel = new JLabel("Hasło:");
        hasloLabel.setBounds(30, 60, 80, 25);

        hasloField = new JPasswordField();
        hasloField.setBounds(120, 60, 160, 25);

        loginButton = new JButton("Zaloguj");
        loginButton.setBounds(120, 100, 100, 30);

        statusLabel = new JLabel("");
        statusLabel.setBounds(30, 140, 280, 25);

        add(loginLabel);
        add(loginField);
        add(hasloLabel);
        add(hasloField);
        add(loginButton);
        add(statusLabel);
    }
}
