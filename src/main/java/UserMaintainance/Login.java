package UserMaintainance;

import com.csvreader.CsvReader;

import java.io.FileReader;

public class Login {
    private String path;
    private User user;
    Login login;

    public Login() {

    }

    public Login(String path) {
        this.path = path;
        user = new User();
    }

    public Login(Login login) {
        this(login.path);
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getUserType(String uname, String pass) throws Exception {
        return getCurrentUser(uname, pass).getType();
    }

    public String getAddress() {
        return user.getAddress();
    }

    public void setUserType(String type) {
        user.setType(type);
    }

    public boolean verify(String uname, String password) throws Exception {
        FileReader fileReader = new FileReader(path);
        CsvReader reader = new CsvReader(fileReader);

        try {
            reader.readHeaders();
            while (reader.readRecord()) {
                String inputUName = reader.get("Uname");
                String inputPassword = reader.get("Password");
                /*
                // for debugging
                System.out.println(inputUName);
                System.out.println(inputPassword);
                 */
                boolean verified = uname.equals(inputUName) && password.equals(inputPassword);

                if (verified) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("FILE PATH ERROR");
            e.printStackTrace();
        }

        return false;
    }

    public String getPath() {
        return path;
    }

    public String getUName() {
        return user.getUname();
    }

    public String getPass() {
        return user.getPassword();
    }

    public User getCurrentUser(String uname, String pass) throws Exception {
        FileReader fileReader = new FileReader(path);
        CsvReader reader = new CsvReader(fileReader);

        try {
            reader.readHeaders();
            while (reader.readRecord()) {
                String type = reader.get("Type");
                String inputUName = reader.get("Uname");
                String inputPassword = reader.get("Password");
                String fName = reader.get("FName");
                String lName = reader.get("LName");
                String email = reader.get("email");
                String contact = reader.get("Contact");
                String address = reader.get("Address");
                String id = reader.get("ID");
                String points = reader.get("Points");
                String balance = reader.get("Balance");
                String province = reader.get("Province");

                boolean verified = uname.equals(inputUName) && pass.equals(inputPassword);

                if (verified) {
                    user = new User(type, fName, lName, email, contact, address, inputUName,
                            inputPassword, id, points, balance, province);
                    return user;
                }
            }
        } catch (Exception e) {
            System.out.println("FILE PATH ERROR");
            e.printStackTrace();
        }

        return null;
    }


}
