package hk.edu.cuhk.ie.iems5722.a2_1155169171;

import com.google.gson.annotations.SerializedName;

public class receiveBean {
    @SerializedName("status")
    String status;
    public receiveBean(){

    }
    public receiveBean(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
