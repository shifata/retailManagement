package UserMaintainance;

public class User {
    private String fname, lname, email, contactNo, address, uname, password, id, points, balance;

    User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", address='" + address + '\'' +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", points='" + points + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public User(String fname, String lname, String email, String contactNo, String address, String uname, String password, String id, String points, String balance) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.contactNo = contactNo;
        this.address = address;
        this.uname = uname;
        this.password = password;
        this.id = id;
        this.points = points;
        this.balance = balance;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
