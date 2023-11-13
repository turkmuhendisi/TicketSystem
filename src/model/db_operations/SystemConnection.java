package model.db_operations;

import controller.account.UserInformationService;
import controller.mail.AuthService;

public class SystemConnection {
    AuthService authService;
    public SystemConnection() {
        authService = new AuthService();
    }

    void loginSystem(String email) {
        if (authService.login(email)) {
            System.out.println("Welcome dear "
                    + UserInformationService.getUserListInstance().get(1)
                    + " " + UserInformationService.getUserListInstance().get(2)
            );
        } else System.out.println("Failed to connect!");
    }
}
