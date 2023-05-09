#include <iostream>
#include <cstdlib>
#include <ctime>
# include <string>

using namespace std;

int main() {
    int start, end, guess;
    string response;
    cout << "Geben Sie die untere Grenze des Zahlenbereichs ein: ";
    cin >> start;
    cout << "Geben Sie die obere Grenze des Zahlenbereichs ein: ";
    cin >> end;
    srand(time(NULL)); 
    guess = rand() % (end - start + 1) + start;
    cout << "Ist " << guess << " die gesuchte Zahl? (ja/nein): ";
    cin >> response;
    while (response != "ja") {
        if (response == "nein") {
            cout << "Ist die gesuchte Zahl größer oder kleiner als " << guess << "? (größer/kleiner): ";
            cin >> response;
            if (response == "größer") {
                
                start = guess + 1;
            } else if (response == "kleiner") {
                
                end = guess - 1;
            }
            guess = rand() % (end - start + 1) + start;
            cout << "Ist " << guess << " die gesuchte Zahl? (j/n): ";
            cin >> response;
        } else {
            cout << "Bitte geben Sie j oder n ein: ";
            cin >> response;
        }
    }
    cout << "Gesucht Zahl gefunden! Die Zahl ist " << guess << endl;
    return 0;
}
