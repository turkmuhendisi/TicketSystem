package service;

import java.sql.SQLException;

public interface IDatabaseService {
    void databaseConnection() throws SQLException;
    void cardDataInsert(Card card, int userID) throws SQLException;
    void userDataInsert(User user) throws SQLException;
    void getUserData(User user) throws SQLException;
    void getCardData(int userID) throws SQLException;
    void dataDelete();
    void cardDataUpdate(int setBalance, int cardID);
}
