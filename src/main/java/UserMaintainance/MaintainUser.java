package UserMaintainance;

import Utils.IdGenerator;
import Utils.Sorter;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MaintainUser {
    private String path;
    private ArrayList<User> usersList;

    public MaintainUser(String path) {
        this.path = path;
        usersList = new ArrayList<>();
    }

    public Object[][] readDatabase() throws Exception {
        readDatabaseList();
        Object[][] output = new Object[usersList.size()][11];

        for (int i = 0; i < usersList.size(); i++) {
            User user = usersList.get(i);
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
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usersList;
    }

    public boolean writeToUser() throws Exception {
        CsvWriter writer = new CsvWriter(new FileWriter(path, false), ',');
        try {
            writer.write("Type");
            writer.write("FName");
            writer.write("LName");
            writer.write("email");
            writer.write("Contact");
            writer.write("Address");
            writer.write("Uname");
            writer.write("Password");
            writer.write("ID");
            writer.write("Points");
            writer.write("Balance");

            writer.endRecord();
            writer.flush();

            Sorter.sortUsersById(usersList);

            for (User u : usersList) {
                writer.write(u.getType());
                writer.write(u.getFname());
                writer.write(u.getLname());
                writer.write(u.getEmail());
                writer.write(u.getContactNo());
                writer.write(u.getAddress());
                writer.write(u.getUname());
                writer.write(u.getPassword());
                writer.write(u.getId());
                writer.write(u.getPoints());
                writer.write(u.getBalance());

                writer.endRecord();
                writer.flush();
            }
            writer.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public User getUserFromName(String uname) throws Exception {
        for (User u : readDatabaseList()) {
            if (u.getUname().equals(uname)) {
                return u;
            }
        }
        return null;
    }

    public boolean addUser(User user) {
        boolean exists = userExists(user);
        try {
            if (!exists) {
                user.setId(IdGenerator.getId(3));
                usersList.add(user);
                writeToUser();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean removeUser(User user) throws Exception {
        boolean exists = userExists(user);

        if (exists) {
            int index = getUserIndex(user);
            usersList.remove(index);
            writeToUser();
            return true;
        }

        return false;
    }

    public boolean updateUser(User user) throws Exception {
        boolean exists = userExists(user);

        if (exists) {
            for (int i = 0; i < usersList.size(); i++) {
                if (usersList.get(i).getId().equals(user.getId())) {
                    usersList.remove(i);
                }
            }
            usersList.add(user);
            writeToUser();
            return true;
        }
        return false;
    }

    private boolean userExists(User u) {
        for (User user : usersList) {
            if (user.getId().equals(u.getId())) {
                return true;
            }
        }
        return false;
    }

    private int getUserIndex(User u) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).equals(u)) {
                return i;
            }
        }
        return -1;
    }
}
