package repository;

import model.Card;
import model.User;
import service.CardInformationService;
import service.IDatabaseService;
import service.UserInformationService;

import java.sql.*;

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
    public void cardDataInsert(Card card, int userID){
        try {
            databaseConnection();

            String query = "INSERT INTO cards (cardID,cardType,balance,userID) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(query);

            statement.setInt(1, card.getCardID());
            statement.setString(2, card.getCardType().toString());
            statement.setDouble(3, card.getBalance());
            statement.setInt(4, userID);

            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void userDataInsert(User user){

        try {
            databaseConnection();

            String query = "INSERT INTO accounts (userID,firstname,lastname,birthday,email) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(query);

            statement.setInt(1, user.getId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            // util.Date to sql.Date
            java.util.Date date = user.getBirthday();
            statement.setDate(4, new java.sql.Date(date.getTime()));
            statement.setString(5, user.getEmail());

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

            String query = "SELECT * FROM accounts WHERE email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserInformationService.setUserListInstance(resultSet.getInt(1));
                UserInformationService.setUserListInstance(resultSet.getString(2));
                UserInformationService.setUserListInstance(resultSet.getString(3));
                UserInformationService.setUserListInstance(resultSet.getString(4));
                UserInformationService.setUserListInstance(resultSet.getString(5));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getCardData(int userID) throws SQLException {
        try {
            databaseConnection();
            String query = "SELECT * FROM cards WHERE userID = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CardInformationService.setCardListInstance(resultSet.getInt(1));
                CardInformationService.setCardListInstance(resultSet.getString(2));
                CardInformationService.setCardListInstance(resultSet.getString(3));
                CardInformationService.setCardListInstance(resultSet.getInt(4));
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
