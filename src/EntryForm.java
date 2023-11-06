import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryForm extends JFrame{

    private JButton loginButton;
    private JButton registerButton;
    private JTextField emailField;
    private JTextField codeField;
    private JButton loginFormButton;
    private JButton sendButton;
    private JPanel entryPanel;
    private JLabel emailLabel;
    private JLabel codeLabel;
    private JLabel timerLabel;

    public EntryForm() {
        setContentPane(entryPanel);
        setTitle("Entry Form");
        setSize(600,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        loginButton.setFocusPainted(false);
        registerButton.setFocusPainted(false);
        loginFormButton.setFocusPainted(false);
        sendButton.setFocusPainted(false);
        setVisible(true);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomDigitGenerator random = new RandomDigitGenerator();
                GmailSender.sendEmail(emailField.getText(),"Authentication Code", String.valueOf(random.digitGenerator()));
            }
        });
    }
}
