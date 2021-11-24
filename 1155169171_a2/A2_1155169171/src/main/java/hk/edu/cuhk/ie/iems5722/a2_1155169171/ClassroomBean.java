package hk.edu.cuhk.ie.iems5722.a2_1155169171;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClassroomBean {
    private String status;
    private List<ClassBean> data;

    public ClassroomBean() {
    }

    public ClassroomBean(String status, List<ClassBean> data) {
        this.status = status;
        this.data = data;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ClassBean> getData() {
        return data;
    }

    public void setData(List<ClassBean> data) {
        this.data = data;
    }

    public static class ClassBean {
        public ClassBean() {
        }

        public ClassBean(String id, String name) {
            this.id = id;
            this.name = name;
        }
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

