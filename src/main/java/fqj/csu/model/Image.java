package fqj.csu.model;

import java.util.Date;

public class Image {
    private int id;
    private int userId;
    private String name;
    private String path;
    private Date createdDate;
    private int predict;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPredict() {
        return predict;
    }

    public void setPredict(int predict) {
        this.predict = predict;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}

