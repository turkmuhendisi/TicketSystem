import java.sql.SQLException;

public interface IDatabaseService {
    void databaseConnection() throws SQLException;
    void cardDataInsert(Card card, User user) throws SQLException;
    void userDataInsert(User user, int card) throws SQLException;
    void getUserData(User user) throws SQLException;
    void dataDelete();
    void cardDataUpdate(int setBalance, int cardID);
}
