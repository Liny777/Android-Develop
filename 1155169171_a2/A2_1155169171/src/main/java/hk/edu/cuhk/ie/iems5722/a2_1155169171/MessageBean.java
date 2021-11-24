package hk.edu.cuhk.ie.iems5722.a2_1155169171;

import java.util.ArrayList;
import java.util.List;

public class MessageBean {
    private String status;
    private DataBean data;
    public MessageBean(){
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public MessageBean(String status, DataBean data){
        this.status = status;
        this.data = data;
    }
    public static class DataBean{
        private String current_page;
        private List<Msg> messages;
        private String total_pages;
        public DataBean(){

        }
        public DataBean(String current_page,List<Msg> messages,String total_pages){
            this.current_page = current_page;
            this.messages = messages;
            this.total_pages = total_pages;
        }

        public String getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(String current_page) {
            this.current_page = current_page;
        }

        public List<Msg> getMessages() {
            return messages;
        }

        public void setMessages(List<Msg> messages) {
            this.messages = messages;
        }

        public String getTotal_page() {
            return total_pages;
        }

        public void setTotal_page(String total_page) {
            this.total_pages = total_page;
        }
    }
}
