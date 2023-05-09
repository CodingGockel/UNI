#include <iostream>
#include <cmath> 

int main(){
    int a,b,c;
    double x1,x2;
    std::cout << "bitte gebe a ein: " << '\n';
    std::cin >> a;
    std::cout << "bitte gebe b ein: " << '\n';
    std::cin >> b;
    std::cout << "bitte gebe c ein: " << '\n';
    std::cin >> c;

    if((pow(b,2)-(4*a*c)/(2*a))<0){
        std::cout << "deine Gleichung hat keine Lösung" << '\n';
    }else{
        x1= ((-b)+sqrt(pow(b,2)-(4*a*c)))/(2*a);
        x2= ((-b)-sqrt(pow(b,2)-(4*a*c)))/(2*a);
        if(x1==x2){
            std::cout << "deine Gleichung hat eine Lösung: " << x1 <<'\n';
        }else{
            std::cout << "deine Gleichung hat zwei Lösungen: " << x1 << ", " << x2 << '\n';
        }
    } 
}

