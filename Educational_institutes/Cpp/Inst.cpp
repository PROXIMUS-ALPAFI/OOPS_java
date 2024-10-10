/*Name : Devarsh Naik
#Rollno: 10
#start 24/07/2024
#
*/
#include<iostream>
#include<string>
using namespace std;
class Inst
{
    public:
        int srno;
        string name;
        string city;
        string state;
        string act;
        string ministry;
        Inst(int s,string x,string y,string z,string m,string n){
            srno = s;
            name = x;
            city = y;
            state = z;
            act = m;
            ministry = n;
        }
        string tostring(){
            cout <<"\n"<< this->srno <<"\t" << this->name <<"\t" << this->city <<"\t" << this->state <<"\t" << this->act <<"\t" << this->ministry <<"\t";
        }
    
};
int main(){
    Inst inst1(1,"Aligarh Muslim University","Aligarh","Uttar Pradesh","Entry No. 63 Union list - The 7th schedule under Article 246 of the Constitution of India","Ministry of Education");
    inst1.tostring();
    
}