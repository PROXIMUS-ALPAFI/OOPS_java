import java.util.Random;
import java.util.Scanner;

/**
 *THis is a palm cricket game which you may play with the computer the game is in test format where in the bowling and batting side guesses numbers between 1 and 6; if the numbers are the same then batter out which results in  the end of the innings , otherwise the score gets add to the score
 * @author Devarsh Naik
 * @version 1.0.1
 * @lastmodified 21/08/2024
 * @startdate 14/08/2024
 */

public class Palmcric {
    public int rand_num;
    public int user_in;
    public  int score_usr = 0;
    public int score_sys = 0;
    public boolean outflag = false;
    public boolean batflag;


    public void setRand_num() {
        Random random = new Random();
        this.rand_num = random.nextInt((6 - 1) + 1) + 1;
        System.out.println("\nSystem chose  " + rand_num);
    }

    public void setUser_in() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nenter number");
        int in = sc.nextInt();
        if (in < 0 || in > 6) {
            System.out.println("invalid input ,  ... system shall chose for you randomly");
            Random r2 = new Random();
            this.user_in = r2.nextInt((6 - 1) + 1) + 1;
            System.out.println(this.user_in);
        }
        else {
            this.user_in = in;
        }
    }

    public void choice() {
        System.out.println("\nChose 1.heads or 2.tails:\n");
        Scanner ss = new Scanner(System.in);
        int ch = ss.nextInt();
        switch (ch) {
            case 1:
                System.out.println("\nheads is the call");
                break;
            case 2:
                System.out.println("\ntails is the call");
                break;
            default:
                ch = 2;
                System.out.println("\ntails");
                break;
        }
        int range = 2 - 1; // calculate our range:  5
        double randomDouble = Math.random(); // returns a double: 0.3
        double calc = (randomDouble * range) + 1; // calculation returns 6.5
        long number = Math.round(calc); // 6.5 is rounded up to 7
        int tv = (int) number;
        if (tv == ch) {
            System.out.println("\nyou have won the toss: please select 1:batting or 2:bowling");
            int c;
            Scanner s4 = new Scanner(System.in);
            c = s4.nextInt();

            if (c == 1) {
                System.out.println("\nyou have choosen to bat first");
                this.batflag = true;
            } else {
                System.out.println("\n you have chosen to bowl");
                this.batflag = false;
            }
        }
        else {
            System.out.println("you have lost the toss : the system chooses to bowl first");
                this.batflag=true;
        }
    }

    public void innings() {
        if (this.batflag) {
            System.out.println("\n 1st innings user batting");
            int count=1;
            while (!outflag) {
                System.out.println(count+"\t ball");
                this.setUser_in();
                this.setRand_num();
                if (user_in == rand_num) {
                    outflag = true;
                    System.out.println("\nuser Innings over , your score is :"+this.score_usr);
                } else {
                    this.score_usr += user_in;

                }
                count++;
            }
            outflag = false;
            count=1;
            System.out.println("\n2nd innings system batting");
            while (!outflag) {
                System.out.println(count+"\t ball");
                this.setUser_in();
                this.setRand_num();
                if (user_in == rand_num) {
                    outflag = true;
                    System.out.println("\nsystem Innings over , System score is :"+this.score_sys);
                } else {
                    this.score_sys += rand_num;
                }
                if(this.score_sys>score_usr){
                    outflag=true;
                }
                count++;
            }
        }
        else {
            int count=1;
            System.out.println("\n 1st innings system batting");
            while (!outflag) {
                System.out.println(count+"\t ball");
                this.setUser_in();
                this.setRand_num();
                if (user_in == rand_num) {
                    outflag = true;
                    System.out.println("\nsystemInnings over , System score is :"+this.score_sys);
                } else {
                    this.score_sys += rand_num;
                }
                count++;
            }
            outflag = false;
            count=1;
            System.out.println("\n2nd innings user batting");
            while (!outflag) {
                System.out.println(count+"\t ball");
                this.setUser_in();
                this.setRand_num();
                if (user_in == rand_num) {
                    outflag = true;
                    System.out.println("\n user Innings over , your score is :"+this.score_usr);
                } else {
                    this.score_usr += user_in;
                }
                if(this.score_sys<score_usr){
                    outflag=true;
                }
                count++;
            }
        }
    }
    public void results(){
        System.out.println("\nyou scored  "+this.score_usr+"  system scored "+score_sys);
        if(this.score_sys>this.score_usr){

            System.out.println("\nyou lost.....");
        }
        else{
            System.out.println("\nyou win....");
        }
    }
}
