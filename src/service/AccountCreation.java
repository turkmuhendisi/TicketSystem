package service;

import model.User;
import repository.DatabaseTransactions;

import java.sql.SQLException;
import java.util.Date;

public class AccountCreation {
    DatabaseTransactions databaseTransactions;
    public AccountCreation() {
        databaseTransactions = new DatabaseTransactions();
    }

    void accountCreator(String firstName, String lastName, Date birthday,String phoneNumber) throws SQLException {
        User user = new User(firstName, lastName, phoneNumber, birthday);
        databaseTransactions.userDataInsert(user);
    }
}
