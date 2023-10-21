import java.sql.SQLException;
import java.util.Date;

public class CardCreation implements ICardCreationService {

    DatabaseTransactions databaseTransactions;

    public CardCreation() {
        databaseTransactions = new DatabaseTransactions();
    }

    @Override
    public void studentCardCreation(String firstName, String lastName, Date birthday) throws SQLException {
        Card studentCard = new StudentCard(CardType.STUDENT,0);
        User studentUser = new User(firstName, lastName,birthday);
        // Writing student card information to the database
        // Writing card balance information to the database
        databaseTransactions.cardDataInsert(studentCard, studentUser);
    }

    @Override
    public void standardCardCreation(String firstName, String lastName, Date birthday) throws SQLException {
        Card standardCard = new StudentCard(CardType.STANDARD, 0);
        User standardUser = new User(firstName, lastName, birthday);
        // Writing standard card information to the database
        // Writing card balance information to the database
        databaseTransactions.cardDataInsert(standardCard, standardUser);
    }

    @Override
    public void retiredCardCreation(String firstName, String lastName, Date birthday) throws SQLException {
        Card retiredCard = new RetiredCard(CardType.RETIRED);
        User retiredUser = new User(firstName, lastName, birthday);
        // Writing retired card information to the database
        // Writing card balance information to the database
        databaseTransactions.cardDataInsert(retiredCard, retiredUser);
    }
}
