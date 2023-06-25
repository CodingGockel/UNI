#include <iostream>
#include <time.h>
#include <string>
#include <fstream>
#include <vector>

using namespace std;

class Position{
    protected:
    double länge;
    double breite;
    double höhe;
    public:
    Position(){
        länge = 0.f;
        breite = 0.f;
        höhe = 0.f;
    }
    Position(double l, double b, double h){
        länge = l;
        breite = b;
        höhe = h;
    }
    Position(const Position &p){
        länge = p.länge;
        breite = p.breite;
        höhe = p.höhe;
    }
    double getLänge(){
        return länge;
    }
    double getBreite(){
        return breite;
    }
    double getHöhe(){
        return höhe;
    }
    void print(){
        cout << länge << " " << breite << " " << höhe;
    }

};

class Wegpunkt:public Position{
    protected:

    string beschreibung;

    public:

    Wegpunkt(){
        beschreibung = "";
    }
    
    Wegpunkt(double l, double b, double h, string s):Position(l,b,h){
        beschreibung = s;
    }

    Wegpunkt(const Wegpunkt &w):Position(w){
        beschreibung = w.beschreibung;
    }

    string getBeschreibung(){
        return beschreibung;
    }

    void print(){
        Position::print();
        cout << " " << beschreibung << "\n";
    }
};

class Trackpunkt:public Position{
    private:
    time_t TimeFromYMD(int year, int month, int day){
        struct tm tm = {0};
        tm.tm_year = year - 1900;
        tm.tm_mon = month - 1;
        tm.tm_mday = day;
        return mktime(&tm);
    }
    protected:
    int t;
    public:
    Trackpunkt(){
        t = (int) difftime(time(NULL),TimeFromYMD(1980,1,5));
    }
    Trackpunkt(double l,double b, double h):Position(l,b,h){
         t = (int) difftime(time(NULL),TimeFromYMD(1980,1,5));
    }
    Trackpunkt(double l,double b, double h,int time):Position(l,b,h){
        t = time;
    }
    Trackpunkt(const Trackpunkt &tp):Position(tp){
        t = tp.t;
    }
    int getTime(){
        return t;
    }
        void print(){
        Position::print();
        cout << " " << t << "\n";
    }
    
};

class Track{
    private:
    vector<Trackpunkt> track;
    vector<string> splitString(const string &str, char c){
        vector<string> ret(0);
        string push = "";
        for(int i = 0; i < str.length(); i++){
            if(str[i] == c && push.length() != 0){
                ret.push_back(push);
                push = "";
            }else{
                if(str[i] != c){
                    push.push_back(str[i]);
                }
            }
        }
        if(push.length() != 0){
            ret.push_back(push);
        }
        return ret;
    }
    public:
    Track(){}
    Track(vector<Trackpunkt> tr){
        track = tr;
    }
    Track(const Track &tr){
        track = tr.track;
    }
    void addTrackpunkt(Trackpunkt tp){
        track.push_back(tp);
    }
    void print(){
        for(Trackpunkt tr:track){
            tr.print();
        }
    }
    double mittlereHöhe(){
        double ret = 0;
        int count = 0;
        if(track.size() != 0){
            for(Trackpunkt tp:track){
                ret += tp.getHöhe();
                count++;
            }
        }else{
            return -1.f;
        }
        return (ret/count);
    }
    void write(string file){
        ofstream out(file);
        for(Trackpunkt tp:track){
            out << tp.getLänge() << " " << tp.getBreite() << " " << tp.getHöhe() << " " << tp.getTime() << "\n"; 
        }
        out.close();
    }
    void read(string file){
    ifstream in(file);
    track.clear();
    if(in.is_open()){
        string line;
        while(getline(in,line)){
            vector<string> l = splitString(line, ' ');
            if(l.size() == 4){
                Trackpunkt tr(stod(l[0]),stod(l[1]),stod(l[2]),stoi(l[3]));
                track.push_back(tr);
            }else{
                cout << "Fehlerhafte Datei\n"; 
            }
        }   	
        in.close();
    }else{
        cout << "File not exist" << endl;
    }
}
};

int main(void){
    Position p(123.023,1245.76,5678.98);
    Wegpunkt wp(123.023,1245.76,5678.98,"test");
    Trackpunkt tp(123.023,1245.76,5678.98);
    Track t;
    Track t2;
    p.print();
    cout << "\n";
    wp.print();
    tp.print();
    t.addTrackpunkt(tp);
    t.print();
    t.write("test.txt");
    t2.read("track.txt");
    cout << "Mittlere Höhe: " << t2.mittlereHöhe();
    return 0;
}
