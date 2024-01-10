package service;

import java.sql.SQLException;

public interface IAuthCardService {
    boolean authCard(int userID) throws SQLException;
}
