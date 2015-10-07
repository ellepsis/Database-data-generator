package Entity;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
public class User {
    private long id;
    private String userName;
    private String Password;
    private  long permissionsTypeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public long getPermissionsTypeId() {
        return permissionsTypeId;
    }

    public void setPermissionsTypeId(long permissionsTypeId) {
        this.permissionsTypeId = permissionsTypeId;
    }

}
