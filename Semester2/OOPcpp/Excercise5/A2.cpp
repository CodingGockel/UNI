#include <iostream>
#include <vector>

using namespace std;

void sort(vector<string *> &list){
    for(int i = list.size() - 1; i > 0; --i){
        for(int j = 0; j < i; ++j){
            if(*list[j] > *list[j + 1]){
                string *h = list[j];
                list[j] = list[j+1];
                list[j+1] = h;
            }
        }
    }
}

int main(){
    vector<string *> list;
    string arr[100];
    string input;
    int i = 0;
    cout << "bitte gebe deine zeichenkette ein. Gebe einen '.' ein um die sortierte eichenkette zu bekommen" << "\n";
    while(true){
        getline(cin,input);
        if(input == "."){
            break;
        }
        arr[i] = input;
        i++;
    }
    int k = 0;
    while(k < i){
        list.push_back(&arr[k]);
        k++;
    }
    sort(list);
    for(string *e:list){
        cout << *e << "; ";
    }
    return 0;
}