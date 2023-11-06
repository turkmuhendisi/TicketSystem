public class AuthService implements IAuthRegisterService, IAuthLoginService, IAuthLogoutService {
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
    public boolean logout() {
        // Logout validation
        return true;
    }
}
