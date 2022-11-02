package co.edu.escuelaing;

public class User {

    private String id;
    private String name;
    private String psw;

    public User(){}

    public User(String id, String name, String psw) {
        this.id = id;
        this.name = name;
        this.psw = psw;
    }

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

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public CharSequence getPassword() {
        return "a";
    }

    public Object getEmail() {
        Object object = null;
        return object;
    }
}
