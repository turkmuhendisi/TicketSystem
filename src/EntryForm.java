import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private static int authCode;
    private static int second = 120;
    private static Timer timer;

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
        loginFormButton.setEnabled(false);
        codeField.setEnabled(false);
        timerLabel.setVisible(false);
        setVisible(true);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AuthService authService = new AuthService();
                if(authService.login(emailField.getText())) {
                    RandomDigitGenerator random = new RandomDigitGenerator();
                    int code = random.digitGenerator();
                    GmailSender.sendEmail(emailField.getText(), "Authentication Code", String.valueOf(code));
                    authCode = code;
                    loginFormButton.setEnabled(true);
                    codeField.setEnabled(true);
                    // 2 minutes timer
                    timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            second--;
                            timerLabel.setText(getTime());

                            if (second == 0) {
                                timer.stop();
                                second = 120;
                                loginFormButton.setEnabled(false);
                                codeField.setEnabled(false);
                                JOptionPane.showMessageDialog(null,"İlgili e-posta adresine gelen doğrulama kodunu belirtilen süre içerisinde giriniz.");
                            }
                        }
                    });
                    timer.start();
                    timerLabel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Mail geçerli değil!");
                }
            }
        });
        loginFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFormButton.setEnabled(true);
                codeField.setEnabled(true);
                if(codeField.getText().equals(String.valueOf(authCode))) {
                    SystemConnection connection = new SystemConnection();
                    connection.loginSystem(emailField.getText());
                    JOptionPane.showMessageDialog(null,"Giriş yapılıyor.");
                    MainPage mainPage = new MainPage();
                } else {
                    JOptionPane.showMessageDialog(null,"Geçersiz kod!");
                }
            }
        });
    }
    private static String getTime() {
        int min = second / 60;
        int sec = second % 60;
        return new SimpleDateFormat("mm:ss").format(new Date(0,0,0,0,min,sec));
    }

}
