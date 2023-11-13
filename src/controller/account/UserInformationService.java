package controller.account;

import java.util.ArrayList;

public class UserInformationService {
    /**
     * Singleton design pattern for
     */
    private static ArrayList<Object> userList;

    private UserInformationService() {
        userList = new ArrayList<>();
    }

    public static ArrayList<Object> getUserListInstance() {
        return userList;
    }

    public static void setUserListInstance(Object data) {
        if(userList!=null)
        userList.add(data);
        else{
            userList = new ArrayList<>();
            userList.add(data);
        }
    }


}
