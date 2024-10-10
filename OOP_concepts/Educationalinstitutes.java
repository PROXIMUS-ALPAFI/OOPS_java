/*
 /*Name : Devarsh Naik
#Rollno: 10
#start 10/07/2024
#last modified : 17/07/2024

description:: the code below takes a csv file as a input and converts it into an array of objects
*/
enum insttitute {
    IITs,IIMs,ISERs,NITs;
}
public class Educationalinstitutes implements Create{
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

    public Educationalinstitutes() {

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
        return "\n-----------------------------------------------------------------------------------------------------------------\n" +
                " Sr_no=" + Sr_no +'\n'+
                " name='" + name + '\'' +'\n'+
                " city='" + city + '\'' +'\n'+
                " state='" + state + '\'' +'\n'
                ;
    }

    @Override
    public void create_ins() {

    }

    @Override
    public void setname(String name) {
        this.name=name;
    }

    @Override
    public void setaddress() {

    }
}
