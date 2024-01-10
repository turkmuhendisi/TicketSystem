package service;

import model.Card;
import model.CardType;
import model.RetiredCard;
import model.StudentCard;
import repository.DatabaseTransactions;

import java.sql.SQLException;

public class CardCreation implements ICardCreationService {

    DatabaseTransactions databaseTransactions;

    public CardCreation() {
        databaseTransactions = new DatabaseTransactions();
    }


    @Override
    public void standardCardCreation() throws SQLException {
        Card standardCard = new StudentCard(CardType.STANDARD, 0);
        // Writing standard card information to the database
        // Writing card balance information to the database
        databaseTransactions.cardDataInsert(standardCard, (int) UserInformationService.getUserListInstance().get(0));
    }
    @Override
    public void studentCardCreation() throws SQLException {
        Card studentCard = new StudentCard(CardType.STUDENT, 0);
        // Writing student card information to the database
        // Writing card balance information to the database
        databaseTransactions.cardDataInsert(studentCard, (int) UserInformationService.getUserListInstance().get(0));
    }

    @Override
    public void retiredCardCreation() throws SQLException {
        Card retiredCard = new RetiredCard(CardType.RETIRED);
        // Writing retired card information to the database
        // Writing card balance information to the database
        databaseTransactions.cardDataInsert(retiredCard, (int) UserInformationService.getUserListInstance().get(0));
    }
}
