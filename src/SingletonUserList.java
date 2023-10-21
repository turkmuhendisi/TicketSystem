import java.util.ArrayList;

public class SingletonUserList {
    /**
     * Singleton design pattern for
     */
    private static ArrayList<Object> userList;

    private SingletonUserList() {
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
