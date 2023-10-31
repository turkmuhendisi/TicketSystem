public class SystemConnection {
    AuthService authService;
    public SystemConnection() {
        authService = new AuthService();
    }

    void loginSystem(String phoneNumber) {
        if (authService.login(phoneNumber)) {
            System.out.println("Welcome dear "
                    + UserInformationService.getUserListInstance().get(1)
                    + " " + UserInformationService.getUserListInstance().get(2)
            );
        } else System.out.println("Failed to connect!");
    }
}
