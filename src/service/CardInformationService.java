package service;

import java.util.ArrayList;

public class CardInformationService {
    private static ArrayList<Object> cardList;

    private CardInformationService() {
        cardList = new ArrayList<>();
    }

    public static ArrayList<Object> getCardListInstance() {
        return cardList;
    }

    public static void setCardListInstance(Object data) {
        if (cardList!=null) {
            cardList.add(data);
        } else {
            cardList = new ArrayList<>();
            cardList.add(data);
        }
    }
}
