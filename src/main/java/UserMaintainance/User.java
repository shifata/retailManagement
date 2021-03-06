package UserMaintainance;


public class User {
    private String type;
    private String fname;
    private String lname;
    private String email;
    private String contactNo;
    private String address;
    private String uname;
    private String password;
    private String id;
    private String points;
    private String balance;
    private String province;

    public User() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "type='" + type + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", address='" + address + '\'' +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", points='" + points + '\'' +
                ", balance='" + balance + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public String getProvince() {
        return province;
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


    public User(String type, String fname, String lname, String email, String contactNo, String address, String uname,
                String password, String id, String points, String balance, String province) {
        this.type = type;
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
        this.province = province;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User other = (User) o;

        return other.type.equals(type) && other.fname.equals(fname) &&
                other.lname.equals(lname) && other.email.equals(email) &&
                other.contactNo.equals(contactNo) && other.address.equals(address) &&
                other.uname.equals(uname) && other.password.equals(password) &&
                other.points.equals(points) && other.balance.equals(balance);

    }
}
