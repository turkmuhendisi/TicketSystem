package view;

import controller.JPanelGeneralController;
import service.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

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
    private JRadioButton standardRadioButton;
    private JRadioButton studentRadioButton;
    private JRadioButton retiredRadioButton;
    private JPanel cardTypeSelectionPanel;
    private JPanel cardInformationPanel;
    private JButton createCardButton;
    private JLabel card1Label;
    private JLabel card2Label;
    private JLabel card3Label;


    public MainPage()
    {
        JPanelGeneralController.setVisibility( new ArrayList<>(Arrays.asList(
                cardTypeSelectionPanel,
                cardInformationPanel,
                createCardButton,
                cardPanel)),
                false);


        if (CardInformationService.getCardListInstance()!=null) {
            card1Label.setText((String) CardInformationService.getCardListInstance().get(0));
        }

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
        addCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardTypeSelectionPanel.setVisible(true);

            }
        });

        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem() == standardRadioButton) {
                        studentRadioButton.setSelected(false);
                        retiredRadioButton.setSelected(false);
                    } else if (e.getItem() == studentRadioButton) {
                        standardRadioButton.setSelected(false);
                        retiredRadioButton.setSelected(false);
                    } else if (e.getItem() == retiredRadioButton) {
                        standardRadioButton.setSelected(false);
                        studentRadioButton.setSelected(false);
                    }
                }
            }
        };

        // Attach the ItemListener to the radio buttons
        standardRadioButton.addItemListener(itemListener);
        studentRadioButton.addItemListener(itemListener);
        retiredRadioButton.addItemListener(itemListener);
        createCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ICardCreationService cardCreation = null;
                AuthService authService = null;
                if (standardRadioButton.isSelected()) {
                    try {
                        cardCreation = new CardCreation();
                        cardCreation.standardCardCreation();
                        authService = new AuthService();
                        authService.authCard((int) UserInformationService.getUserListInstance().get(0));
                        cardPanel.setVisible(true);
                        card1Label.setText(String.valueOf(CardInformationService.getCardListInstance().get(0)));
                        cardTypeSelectionPanel.setVisible(false);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (studentRadioButton.isSelected()) {
                    try {
                        cardCreation = new CardCreation();
                        cardCreation.studentCardCreation();
                        authService = new AuthService();
                        authService.authCard((int) UserInformationService.getUserListInstance().get(0));
                        cardPanel.setVisible(true);
                        card1Label.setText(String.valueOf(CardInformationService.getCardListInstance().get(0)));
                        cardTypeSelectionPanel.setVisible(false);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (retiredRadioButton.isSelected()) {
                    try {
                        cardCreation = new CardCreation();
                        cardCreation.retiredCardCreation();
                        authService = new AuthService();
                        authService.authCard((int) UserInformationService.getUserListInstance().get(0));
                        cardPanel.setVisible(true);
                        card1Label.setText(String.valueOf(CardInformationService.getCardListInstance().get(0)));
                        cardTypeSelectionPanel.setVisible(false);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Lütfen oluşturmak istediğiniz kart tipini seçiniz.");
                }
            }
        });
    }
}
