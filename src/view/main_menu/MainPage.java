package view.main_menu;

import javax.swing.*;

public class MainPage extends JFrame{
    private JPanel mainPage;
    private JLabel usernameLabel;
    private JButton addCard;
    private JButton addBalance;
    private JLabel cardHeaderLabel;
    private JLabel balanceTitle;
    private JLabel cardTypeTitle;
    private JLabel cardTypeLabel;
    private JLabel balanceLabel;
    private JPanel cardPanel;


    public MainPage()
    {
        setContentPane(mainPage);
        setTitle("Main Page");
        setSize(600,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addCard.setFocusPainted(false);
        addBalance.setFocusPainted(false);
        setResizable(false);
        usernameLabel.setText(
                "Welcome dear " +
                UserInformationService.getUserListInstance().get(1)
                + " " +
                UserInformationService.getUserListInstance().get(2)
        );
        setVisible(true);
    }
}
