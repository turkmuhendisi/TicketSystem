import java.sql.*;
import java.util.Optional;

public class DatabaseTransactions implements IDatabaseService {
    Connection connection;
    PreparedStatement statement;
    @Override
    public void databaseConnection() throws SQLException {
        final String url = "jdbc:mysql://localhost/ticketSystemDB";
        final String user = "root";
        final String password = "admin123";
        connection = DriverManager.getConnection(url, user, password);
    }

    @Override
    public void cardDataInsert(Card card, User user){
        try {
            databaseConnection();

            String query = "INSERT INTO cards (cardID,cardUser,cardType,balance) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(query);

            statement.setInt(1, card.getCardID());
            statement.setString(2, user.getFirstName() + " " + user.getLastName());
            statement.setString(3, card.getCardType().toString());
            statement.setDouble(4, card.getBalance());

            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void userDataInsert(User user, int cardID){

        try {
            databaseConnection();

            String query = "INSERT INTO accounts (userID,firstname,lastname,birthday,phone,cardID) VALUES (?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);

            statement.setInt(1, user.getId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            // util.Date to sql.Date
            java.util.Date date = user.getBirthday();
            statement.setDate(4, new java.sql.Date(date.getTime()));
            statement.setString(5, user.getPhoneNumber());
            statement.setInt(6, cardID);

            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getUserData(User user) {
        try {
            databaseConnection();

            String query = "SELECT * FROM accounts WHERE phone = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getPhoneNumber());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserInformationService.setUserListInstance(resultSet.getInt(1));
                UserInformationService.setUserListInstance(resultSet.getString(2));
                UserInformationService.setUserListInstance(resultSet.getString(3));
                UserInformationService.setUserListInstance(resultSet.getString(4));
                UserInformationService.setUserListInstance(resultSet.getString(5));
                UserInformationService.setUserListInstance(resultSet.getInt(6));
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dataDelete() {

    }

    @Override
    public void cardDataUpdate(int setBalance, int cardID) {
        try {
            databaseConnection();

            String query = "UPDATE cards SET balance = ? WHERE cardID = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, setBalance);
            statement.setInt(2, cardID);

            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
