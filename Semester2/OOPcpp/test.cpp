#include <string>
#include <iostream>

using namespace std;

string binToDecString(int dec){
    string ret = "";
    while(dec > 0){
        ret += to_string(dec%2);
        dec/=2;
    }
    return ret;
}

int binToDecInteger(int dec){
    int ret = 0;
    int mult = 1;
    int test = dec;
    while((test / 10) >= 10){
        
    }
    while(dec > 0){
        ret += dec%2 * mult;
        dec /= 2;
        mult *= 10;
    }
    return ret;
}

int decToBin(){
    return 0;
}

int main(){
    int ergeb = binToDecInteger(6);
    cout << ergeb << "\n";
}

