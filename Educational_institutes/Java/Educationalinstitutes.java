import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Educationalinstitutes {
    int Sr_no;
    String name,city,state,act,authority;
    public Educationalinstitutes(int sr_no,String name, String city, String state, String act, String authority) {
        this.name = name;
        Sr_no = sr_no;
        this.city = city;
        this.state = state;
        this.act = act;
        this.authority = authority;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Educationalinstitutes{" +
                "Sr_no=" + Sr_no +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", act='" + act + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
    public static void write(Educationalinstitutes[] institutes, String csvFilePath) {
        try (Writer writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            // Write header
            writer.write("Sr_no,name,city,state,act,authority\n");

            // Write data
            for (Educationalinstitutes institute : institutes) {
                writer.write(String.format("%d,%s,%s,%s,%s,%s\n",
                        institute.Sr_no,
                        institute.name,
                        institute.city,
                        institute.state,
                        institute.act,
                        institute.authority));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
