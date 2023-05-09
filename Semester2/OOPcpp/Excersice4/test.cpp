#include <vector>
#include <iostream>

using namespace std;

int main(){
    vector<int> i(0);
    cout << i.size() << "\n";
    i.push_back(6);
    cout << i.size() << "\n";


    return 0;
}