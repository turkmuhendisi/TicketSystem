package controller.card;

import java.sql.SQLException;
import java.util.Date;

public interface ICardCreationService {
    void studentCardCreation(String firstName, String lastName, Date birthday) throws SQLException;
    void standardCardCreation(String firstName, String lastName, java.util.Date birthday) throws SQLException;
    void retiredCardCreation(String firstName, String lastName, java.util.Date birthday) throws SQLException;
}
