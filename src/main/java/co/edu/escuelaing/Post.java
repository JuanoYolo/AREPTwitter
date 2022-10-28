package co.edu.escuelaing;



public class Post {

    private String id;
    private User user;
    private String message;

    public Post(){}
    public Post(String id, User user, String message) {
        this.id = id;
        this.user = user;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
