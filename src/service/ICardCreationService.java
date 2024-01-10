package service;

import java.sql.SQLException;

public interface ICardCreationService {
    void studentCardCreation() throws SQLException;
    void standardCardCreation() throws SQLException;
    void retiredCardCreation() throws SQLException;
}
