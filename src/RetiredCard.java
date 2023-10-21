public class RetiredCard extends Card{
    public RetiredCard(CardType cardType) {
        super(cardType);
    }

    @Override
    public int getCardID() {
        return super.getCardID();
    }

    @Override
    public void setCardID(int cardID) {
        super.setCardID(cardID);
    }

    @Override
    public CardType getCardType() {
        return super.getCardType();
    }

    @Override
    public void setCardType(CardType cardType) {
        super.setCardType(cardType);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public void setBalance(double balance) {
        super.setBalance(balance);
    }
}
