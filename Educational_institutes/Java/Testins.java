import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Testins {
    public static void main(String[] args) {
        try {
            Path file = Paths.get("Institutes.csv");
            long count = Files.lines(file).count(); // Counting lines in the file
            Educationalinstitutes[] ins = new Educationalinstitutes[(int) count];

            FileInputStream fis = new FileInputStream("Institutes.csv");
            Scanner sc = new Scanner(fis);
            String line;
            int iter = 0;

            String previousAct = "";
            String previousAuthority = "";

            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] flds = line.split(",", -1);

                int no = Integer.parseInt(flds[0].trim());
                String name = flds[1].trim();
                String city = flds[2].trim();
                String state = flds[3].trim();

                String act = flds.length > 4 ? flds[4].trim() : previousAct;
                String ministry = flds.length > 5 ? flds[5].trim() : previousAuthority;


                if (flds.length > 4 && !flds[4].trim().isEmpty()) {
                    previousAct = flds[4].trim();
                }
                if (flds.length > 5 && !flds[5].trim().isEmpty()) {
                    previousAuthority = flds[5].trim();
                }

                ins[iter] = new Educationalinstitutes(no, name, city, state, act, ministry);

                iter++;
            }

            sc.close();


            for (Educationalinstitutes institute : ins) {
                if (institute != null) {
                    System.out.println(institute);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

