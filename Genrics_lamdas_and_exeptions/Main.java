import java.util.ArrayList;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Gen<Double> ob1=new Gen<>(989.78);
        Gen<Integer> ob2=new Gen<>(3231);
        Gen<Boolean> ob3=new Gen<>(true);
        Gen<Float> obj4=new Gen<>(76.165757f);
        Gen<String> obj5=new Gen<>("beste re");
        System.out.println("\n");
        ArrayList<Gen> arr_gen= new ArrayList<Gen>();
        arr_gen.add(ob1);
        arr_gen.add(ob2);
        arr_gen.add(ob3);
        arr_gen.add(obj4);
        arr_gen.add(obj5);
        arr_gen.forEach((n) -> {
            System.out.println(n.toString());
        });
        System.out.println("\n\n");
            while (true){
                try{
                    int c;
                    System.out.println("1. Division by zero\n2. array out of bounds \n3. Bad in and lamda \n4.break");
                    Scanner ss=new Scanner(System.in);
                    c=ss.nextInt();
                    switch (c) {
                        case 1:
                            try {
                                int r2 = 43;
                                int r = r2 / 0;

                            } catch (Exception e1) {
                                System.out.println(e1.getMessage());
                                e1.printStackTrace();
                            }
                            break;
                        case 2:
                            try {
                                System.out.println(arr_gen.get(5).toString());
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            break;
                        case 3:
                            try {
                                System.out.println(ob1.toString() + "\n" + ob2.toString() + "\n" + ob3.toString() + "\n" + obj4.toString());
                                Value v1 = new Value(obj4);
                                System.out.println(v1.toString());


                            } catch (Exception e) {
                                System.out.println("\nyou messed up");
                                e.printStackTrace();
                            } finally {
                                System.out.println("\nLala lala Elmos world");

                            }
                            break;
                        case 4:
                            return;
                    }
                }
                catch (Exception r){r.printStackTrace();}

        }
    }
}