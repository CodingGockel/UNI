#include <iostream>
#include <string>

using namespace std;

class Time{
    private:
        int min;

    public:
        Time(){
            min = 0;
            cout << "Standard-Konstruktor" << endl; 
        }

        Time(int m){
            min = m;
            cout << "Integer-Konstruktor" << endl; 
        }

        Time(int m, int h){
            min = m + (h*60);
            cout << "Min/Stunde-Konstruktor" << endl; 
        }

        Time (const Time &t){
            min = t.min; 
            cout << "Kopier-Konstruktor" << endl; 
        }

        virtual ~Time(){
            cout << "destruktor" << endl; 
        }

        virtual void set(int h,int m){
            min = m + (h*60);
        }

        virtual void get(int &h,int &m) const{
            m = min % 60;
            h = (min - m)/60;
        }

        virtual void inc(){
            min++;
        }
};

void print(Time t){
    int h, m;
    t.get(h, m);
    cout << h << ":" << m << endl;
}

Time input(){
    Time result;
    int h, m;
    cout << "Uhrzeit eingeben - Stunde: " ;
    cin >> h ;
    cout << " Minute: " ;
    cin >> m ;
    result.set(h, m);
    return result;
}

int main(int argc, char* argv[]){
    Time t1(10, 10);
    Time t2;
    t2 = input();
    t2.inc();
    print(t2);
    print(1234);
    return 0;
}
/*
Output:
Min/Stunde-Konstruktor       --> da Die Klasse Time mit 2 intEger werten Instanziert wird
Standard-Konstruktor         --> da die KLasse Time Ohne einen Wert Instanziert wird
Standard-Konstruktor         --> da bei dem Methoden aufruf input eine neue klasse Time ohne Parameter Instanziert wird
Uhrzeit eingeben - Stunde: 2 
 Minute: 50
destruktor                   --> da die Methode input zuende ist und somit die Instnzierte Klasse Time destroyed wird, da sie auserhalb des scopes ist
Kopier-Konstruktor           --> da bei dem aufruf der print methode eine Time instanz übergeben wird, wird für das scope der print methode eine neue time instanz erstellt mit dem kopier konstruktor
2:51
destruktor                   --> am ende der print methode wird die neue instanz destructed
Integer-Konstruktor          --> die print methode erstellt eine neue instanz der Time klasse mit dem übergebene Integer Parameter als Parameter für den Konstruktor
20:34
destruktor                   --> am ende der print methode wird die neue instanz desctructed
destruktor                   --> die main methode ist am ende und ruft von der Time instanz die desctructer methoden auf
destruktor                   --> die main methode ist am ende und ruft von der Time instanz die desctructer methoden auf
*/
