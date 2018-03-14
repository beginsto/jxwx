package pers.jess.template.app.user.bean;

public class User {
    private Integer id;

    private String username;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User:{id:" + id + ", username: " + username + "}";
    }
}
