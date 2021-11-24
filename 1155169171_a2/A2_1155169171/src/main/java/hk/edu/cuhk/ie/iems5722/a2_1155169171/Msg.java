package hk.edu.cuhk.ie.iems5722.a2_1155169171;

import com.google.gson.annotations.SerializedName;

public class Msg {

    @SerializedName("message_time")
    String message_time;
    @SerializedName("name")
    String name;
    @SerializedName("message")
    String message;
    @SerializedName("user_id")
    String user_id;
    private int type ;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    Msg(String message, String name, String message_time, String user_id) {
        this.message = message;
        this.name = name;
        this.message_time = message_time;
        this.user_id = user_id;
    }

    public String getMessage_time() {
        return message_time;
    }

    public void setMessage_time(String message_time) {
        this.message_time = message_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}

