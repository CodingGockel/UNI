#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

double max(const vector<double> &v){
    if(v.size() == 0){
        return 0;
    }
    double max = v[0];
    for(double e:v){
        if(e > max){
            max = e;
        }
    }
    return max;
}

bool allPositiv(const vector<double> &v){
    for(double e:v){
        if(e < 0){
            return false;
        }
    }
    return true;
}

double product(const vector<double> &v1, const vector<double> &v2){
    if(v1.size() == v2.size()){
        double ret = 0;
        for(int i = 0; i < v1.size(); i++){
            ret += v1[i] * v2[i];
        }
        return ret;
    }
    return 0;
}

vector<double> product(const vector<double> &v, double f){
    vector<double> ret(v);
    for(double &e:ret){
        e *= f;
    }
    return ret;
}

double norm(const vector<double> &v){
    if(v.size() != 0){
        double ret = 0;
        for(double e:v){
            ret += e*e;
        }
        return sqrt(ret);
    }
    return 0;
}

void normalize(vector<double> &v){
    v = product(v,1/norm(v));  
}

int main(){
    int l;
    cout << "bitte gebe die länge deines ersten Testvektores ein: " <<"\n";
    cin >> l;
    vector<double> v(l);
    for(int i = 0; i < l; i++){
        cout << "bitte gebe den wert für den index " << i << " ein" << "\n";
        cin >> v[i];
    }
    cout << "maximalwert: " << max(v) <<"\n";
    cout << "all Positive?: " << allPositiv(v) <<"\n";
    int l2;
    cout << "bitte gebe die länge deines zweiten Testvektores ein: " <<"\n";
    cin >> l2;
    vector<double> v2(l2);
    for(int i = 0; i < l2; i++){
        cout << "bitte gebe den wert für den index: " << i << "ein" << "\n";
        cin >> v2[i];
    }
    cout << "Produkt mit Testvektor 2: " << product(v,v2) <<"\n";
    double f;
    cout << "bitte gebe einen faktor ein: " << "\n";
    cin >> f;
    //cout << "produKt mit " << f << ": " << product(v,f) << "\n";
    cout << "produkt mit " << f << ":" <<"\n";
    for(double e: product(v,f)){
        cout << e << " ";
    }
    cout << "\n";
    cout << "norm von testvektor 1: " << norm(v) <<"\n";
    cout << "dein testvektor 1 nach dem normalisieren: " << "\n";
    normalize(v);
    for(double e:v){
        cout << e << " ";
    }
    cout << "\n";
    return 0;
}