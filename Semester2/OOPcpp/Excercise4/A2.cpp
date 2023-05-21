#include <iostream>
#include <string>
#include <vector>

using namespace std;

int stringToInt(const string &s){
    int ret = 0;
    int fak = 1;
    for(int i = s.length() -1; i >= 0; i--){
        ret += fak * ((int)s[i] - 48);
        fak *= 10;
    }
    return ret;
}

bool isZiffer(char c){
    if(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0'){
        return true;
    }
    return false;
}

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

int convert(const string &s){
    string ret = "";
    vector<string> strings = splitString(s, ' ');
    for(string str:strings){
        bool isZiff = isZiffer(str[0]);
        for(char c: str){
            if(isZiffer(c) != isZiff){
                return -1;
            }
        }
        if(isZiff){
            ret += str;
        }
    }
    return stringToInt(ret);
}


int main(){
    string input;
    getline(cin,input);
    cout << convert(input)<< "\n";
    return 0;
}