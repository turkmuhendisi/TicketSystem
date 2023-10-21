public class AuthService implements IAuthRegisterService, IAuthLoginService, IAuthLogoutService {
    DatabaseTransactions databaseTransactions;

    public AuthService() {
        databaseTransactions = new DatabaseTransactions();
    }

    @Override
    public boolean register() {
        // Kayıt doğrulama işlemi yapıyorum.

        return true;
    }

    @Override
    public boolean login(String phoneNumber) {
        // Giriş doğrulama işlemi yapıyorum
        User user = new User(phoneNumber);
        databaseTransactions.getUserData(user);
        return SingletonUserList.getUserListInstance() == null ? false : true;
    }

    @Override
    public boolean logout() {
        // Çıkış doğrulama işlemi yapıyorum
        return true;
    }
}
