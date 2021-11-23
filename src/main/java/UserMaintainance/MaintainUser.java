package UserMaintainance;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MaintainUser {
    private String path;
    private ArrayList<User> users;

    public MaintainUser(String path) {
        this.path = path;
        users = new ArrayList<>();
    }

    public boolean addUser(User user) throws Exception {
        CsvWriter writer = new CsvWriter(new FileWriter(path, true), ',');

        try {
            writer.write(user.getType());
            writer.write(user.getFname());
            writer.write(user.getLname());
            writer.write(user.getEmail());
            writer.write(user.getContactNo());
            writer.write(user.getAddress());
            writer.write(user.getUname());
            writer.write(user.getPassword());
            writer.write(user.getId());
            writer.write("0");      // 0 points for new user
            writer.write("0");      // 0 balance for new user
            writer.endRecord();
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Object[][] readDatabase() throws Exception {
        readDatabaseList();
        Object[][] output = new Object[users.size()][11];

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            output[i][0] = user.getType();
            output[i][1] = user.getFname();
            output[i][2] = user.getLname();
            output[i][3] = user.getEmail();
            output[i][4] = user.getContactNo();
            output[i][5] = user.getAddress();
            output[i][6] = user.getUname();
            output[i][7] = user.getPassword();
            output[i][8] = user.getId();
            output[i][9] = user.getPoints();
            output[i][10] = user.getBalance();
        }

        return output;
    }

    private ArrayList<User> readDatabaseList() throws Exception {
        FileReader fileReader = new FileReader(path);
        CsvReader reader = new CsvReader(fileReader);

        try {
            reader.readHeaders();
            while (reader.readRecord()) {
                String type = reader.get("Type");
                String fname = reader.get("FName");
                String lname = reader.get("LName");
                String email = reader.get("email");
                String contact = reader.get("Contact");
                String address = reader.get("Address");
                String uname = reader.get("Uname");
                String password = reader.get("Password");
                String id = reader.get("ID");
                String points = reader.get("Points");
                String balance = reader.get("Balance");

                User user = new User(type, fname, lname, email, contact, address, uname, password, id,
                        points, balance);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public boolean removeUser() {
        return false;
    }

    public boolean updateUser(User user) {
        return false;
    }
}
