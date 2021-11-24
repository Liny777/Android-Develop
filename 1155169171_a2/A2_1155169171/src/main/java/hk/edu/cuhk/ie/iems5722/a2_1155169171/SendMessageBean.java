package hk.edu.cuhk.ie.iems5722.a2_1155169171;

public class SendMessageBean {
    String chatroom_id;
    String user_id;
    String name;
    String message;
    public SendMessageBean(){

    }
    public SendMessageBean(String chatroom_id,String user_id,String name,String message){
        this.chatroom_id = chatroom_id;
        this.user_id = user_id;
        this.name = name;
        this.message = message;
    }

    public String getChatroom_id() {
        return chatroom_id;
    }

    public void setChatroom_id(String chatroom_id) {
        this.chatroom_id = chatroom_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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
}
