/*Name : Devarsh Naik
#Rollno: 10
#start 10/07/2024
#last modified : 17/07/2024

description:: the code below takes a csv file as a input and converts it into an array of objects of type Institutes
*/
/**
 * @author: Devarsh
 * @version : 1.0.1`
 * @Rollno: 10
 * @start 10/07/2024
 * @last modified : 17/07/2024
 */

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
            long count = Files.lines(file).count();
            Educationalinstitutes[] ins = new Educationalinstitutes[(int)count];

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

                String act;
                act = flds.length > 4 ? flds[4].trim() : previousAct;
                String ministry;
                ministry= flds.length > 5 ? flds[5].trim() : previousAuthority;



                ins[iter] = new Educationalinstitutes(no, name, city, state, act, ministry);

                iter++;
            }

            sc.close();
            while(true){
                System.out.println("\n\n\nOPTIONS: 1: IIITs ,2: IIM's, 3:ISER ,4: IIEST ,5 NITs, 6 IITs, 7 Architecture colleges , 8 :AiIMS , 9 : NIPEs 10 ISD , 11: all the institutes , 12 : exit");
                Scanner scanner=new Scanner(System.in);
                int op=scanner.nextInt();
                switch (op){
                    case 1:
                        System.out.println("All the iiits in Existance under The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments  of the ministry of Education :");
                        for (Educationalinstitutes institute : ins) {
                            if (institute != null && institute.Sr_no> 6 && institute.Sr_no<29) {
                                System.out.println(institute);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("All the IIms in Existance under Indian Institutes of Management Act, 2017 of the ministry of Education are :");
                        for (Educationalinstitutes institute : ins) {
                            if (institute != null && institute.Sr_no>28  && institute.Sr_no<49) {
                                System.out.println(institute);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("All the iser in Existance under National Institutes of Technology, Science Education and Research Act, 2007 and its subsequent amendments of Ministry of education are :");
                        for (Educationalinstitutes institute : ins) {
                            if (institute != null && institute.Sr_no>48  && institute.Sr_no<56) {
                                System.out.println(institute);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("All the IIest in Existance under National Institutes of Technology, Science Education and Research Act, 2007 and its subsequent amendments of Ministry of education are :");
                        for (Educationalinstitutes institute : ins) {
                            if (institute != null && institute.Sr_no==56) {
                                System.out.println(institute);
                            }
                        }
                        break;
                    case 5:
                        System.out.println("All the NIT in Existance under National Institutes of Technology, Science Education and Research Act, 2007 and its subsequent amendments of Ministry of education are :");
                        for (Educationalinstitutes institute : ins) {
                            if (institute != null && institute.Sr_no>56  && institute.Sr_no<88) {
                                System.out.println(institute);
                            }
                        }
                        break;
                    case 6:
                        System.out.println("All the IITs in Existance under  are Institutes of Technology Act, 1961 and its subsequent amendments of the ministry of Education are :");
                        for (Educationalinstitutes institute : ins) {
                            if (institute != null && institute.Sr_no>87  && institute.Sr_no<112) {
                                System.out.println(institute);
                            }
                        }
                        break;
                    case 7:
                        System.out.println("All the Archtecture colleges in Existance under School of Planning and Architecture Act, 2014 under ministry of education are :");
                        for (Educationalinstitutes institute : ins) {
                            if (institute != null && institute.Sr_no>111  && institute.Sr_no<115) {
                                System.out.println(institute);
                            }
                        }
                        break;
                    case 8:
                        System.out.println("All the Aiims in Existance under the  All India Institute of Medical Sciences Act, 1956' and its subsequent amendments under Ministry of Health & Family Welfare are :");
                        for (Educationalinstitutes institute : ins) {
                            if (institute != null && institute.Sr_no>117  && institute.Sr_no<133) {
                                System.out.println(institute);
                            }
                        }
                        break;
                    case 9:
                        System.out.println("All the NIPEs in Existance under National Institute of Pharmaceutical Education and Research Act. 1998 and subsequent amendment of the Department of Pharmaceuticals, Ministry of Chemicals & Fertilizersare :");
                        for (Educationalinstitutes institute : ins) {
                            if (institute != null && institute.Sr_no>136  && institute.Sr_no<144) {
                                System.out.println(institute);
                            }
                        }
                        break;
                    case 10:
                        System.out.println("All the BDES under National Institute of Design Act, 2014 and subsequent amendment of the Ministry of Commerce and Industry in Existance are :");
                        for (Educationalinstitutes institute : ins) {
                            if (institute != null && institute.Sr_no>144  && institute.Sr_no<150) {
                                System.out.println(institute);
                            }
                        }
                        break;
                    case 11:
                        System.out.println("All the institutes");
                        for (Educationalinstitutes institute : ins) {
                            if (institute != null ) {
                                System.out.println(institute);
                            }
                        }
                        break;
                    case 12:
                        return;

                }
            }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

