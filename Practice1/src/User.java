public class User {
    private String ID;
    private String email;
    private String phoneNo;
    
    public User(String ID, String email, String phoneNo) {
        this.ID = ID;
        this.email = email;
        this.phoneNo = phoneNo;
    }
    
    public String getID() {
        return ID;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhoneNo() {
        return phoneNo;
    }
}
