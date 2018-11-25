package id.sikogrup.level_app;

public abstract class User {
    private static Integer i = 1;
    private String id,password,username,email;

    public User(){

    }

    public User (String username, String email, String password)
    {
        this.id = (String) "User_"+i;
        i++;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the id
     */

    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the name to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
