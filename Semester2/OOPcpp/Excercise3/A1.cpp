#include <iostream>

int ggT(int a, int b){
    if(a%b==0){
        return b;
    }
    return ggT(b, a%b);
}

void normalizeFraction(int a ,int b){
    if(b==0){
        std::cout << "kein valider Bruch" << "\n";
    }else if(a==0){
        std::cout << "Der gekürze Bruch ist: " << a << "/" << b << "\n";
    }else if((a < 0 && b < 0) || (a > 0 && b < 0)){
        a= a* -1;
        b= b* -1;
        std::cout << "Der gekürze Bruch ist: " << a/ggT(a,b) << "/" << b/ggT(a,b) << "\n";
    }else{
        std::cout << "Der gekürze Bruch ist: " << a/ggT(a,b) << "/" << b/ggT(a,b) << "\n";
    }
}

int main(){
    int a,b;
    while(true){
        std::cout << "bitte gib den Zähler ein: " << "\n";
        std::cin >> a;
        std::cout << "bitte gib den Nenner ein: " << "\n";
        std::cin >> b;
        normalizeFraction(a,b);  
        std::cout << "möchtest du einen weiteren Bruch eingeben? (1=ja, 0=nein)" << "\n";
        std::cin >> b;
        if(b==0){
            break;
        }
    }
    return 0;
}