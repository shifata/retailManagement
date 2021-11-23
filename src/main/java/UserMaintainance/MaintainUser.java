package UserMaintainance;

import com.csvreader.CsvWriter;

import java.io.FileWriter;

public class MaintainUser {
    private String path;

    public MaintainUser(String path) {
        this.path = path;
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
//            writer.write("\n");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removeUser() {
        return false;
    }

    public boolean updateUser(User user) {
        return false;
    }
}
