package service;

import model.User;
import java.sql.SQLException;
import repository.DatabaseTransactions;

public class AuthService implements IAuthRegisterService, IAuthLoginService, IAuthLogoutService, IAuthCardService {
    DatabaseTransactions databaseTransactions;

    public AuthService() {
        databaseTransactions = new DatabaseTransactions();
    }

    @Override
    public boolean register() {
        // Register validation

        return true;
    }


    @Override
    public boolean login(String email) {
        // Login validation
        User user = new User(email);
        databaseTransactions.getUserData(user);
        return UserInformationService.getUserListInstance() != null;
    }
    @Override
    public boolean authCard(int userID) throws SQLException {
        databaseTransactions.getCardData((int) UserInformationService.getUserListInstance().get(0));
        return CardInformationService.getCardListInstance() != null;
    }


    @Override
    public boolean logout() {
        // Logout validation
        return true;
    }
}
