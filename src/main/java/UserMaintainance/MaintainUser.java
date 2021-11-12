package UserMaintainance;

import com.csvreader.CsvWriter;

import java.io.FileWriter;

public class MaintainUser {
    private String path;

    public MaintainUser() {

    }

    public MaintainUser(String path) {
        this.path = path;
    }

    public boolean addUser(User user) throws Exception {
        CsvWriter writer = new CsvWriter(new FileWriter(path, true), ',');
        System.out.println("here");
        try {
            writer.write(user.getFname());
            writer.write(user.getLname());
            writer.write(user.getEmail());
            writer.write(user.getContactNo());
            writer.write(user.getAddress());
            writer.write(user.getUname());
            writer.write(user.getPassword());
            writer.endRecord();
//            writer.write("\n");
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removeUser() {
        return false;
    }

    public boolean updateUser() {
        return false;
    }
}
