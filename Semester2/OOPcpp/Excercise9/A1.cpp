#include <iostream>
#include <vector>

using namespace std;

template<typename T>
class Intervall{
    private:
    T first;
    T second;
    bool Valid;
    public:
    Intervall(){
        first = 0;
        second = 0;
        Valid = false;
    }
    Intervall(T a, T b){
        set(a,b);
    }
    Intervall(T n){
        first = n;
        second = n;
        Valid = true;
    }
    void set(T a, T b){
        if(a > b){
            swap(a,b);
        }
        first = a;
        second = b;
        Valid = true;
    }
    T* get(){
        if(Valid){
            T arr[2] = {first,second};  
            return arr;
        }
        return nullptr;
    }
    bool isValid(){
        return Valid;
    }
    void print(){
        cout << "[" << first << "," << second << "]\n";
    }
    virtual Intervall& operator+(Intervall<T> source){
        if(Valid && source.isValid()){
            first += source.first;
            second += source.second;
        }else{
            first = 0;
            second = 0;
            Valid = false;
        }
        return *this;
    }
    virtual Intervall& operator-(Intervall<T> source){
        if(Valid && source.isValid()){
            first -= source.first;
            second -= source.second;
        }else{
            first = 0;
            second = 0;
            Valid = false;
        }
        return *this;
    }
    virtual Intervall& operator-(){
        if(Valid){
            first *= -1;;
            second *= -1;
        }else{
            first = 0;
            second = 0;
            Valid = false;
        }
        return *this;
    }
    virtual Intervall& operator*(Intervall<T> source){
        if(Valid && source.isValid()){
            first *= source.first;
            second *= source.second;
        }else{
            first = 0;
            second = 0;
            Valid = false;
        }
        return *this;
    }
    virtual Intervall& operator/(Intervall<T> source){
        if(Valid && source.isValid() && source.first != 0 && source.second != 0){
                first /= source.first;
                second /= source.second;
        }else{
            first = 0;
            second = 0;
            Valid = false;
        }
        return *this;
    }
};

int main(void){
    Intervall <int> I1 (10,6);
    Intervall <int> I2 (5,3);
    Intervall <int> I3 = I1/I2;
    I3.print();
    return 0;
}