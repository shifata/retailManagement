package UserMaintainance;

import com.csvreader.CsvReader;

import java.io.FileReader;

public class Login {
    private String path;

    public Login(String path) {
        this.path = path;
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

}
