/*Name : Devarsh Naik
#Rollno: 10
#start 24/07/2024
#
*/
class Institute
{
    public int srno
    public string name,city,state,act,ministry;
    public Institute(int sr,string name,string city,string state,string act,string ministry){
        this.srno=sr;
        this.name=name;
        this.city=city;
        this.state=state;
        this.act=act;
        this.ministry=ministry;
    }
    static void Main(string[] args){
        Institute ins1=new Institute(1,"Aligarh Muslim University","Aligarh","Uttar Pradesh","Entry No. 63 Union list - The 7th schedule under Article 246 of the Constitution of India","Ministry of Education");
        Console.WriteLine(ins1.srno+""+ins1.name+""+ins1.city+""+ins1.state+""+ins1.act+""+ins1.ministry);
    }
}   