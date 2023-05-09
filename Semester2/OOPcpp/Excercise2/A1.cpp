#include <iostream>
#include <cstdlib>
#include <time.h>

int main(){
    bool guesed = false;
    int max;
    int guess;
    int guesses = 0;
    std::cout << "bitte gib dein Maximum ein:"<< '\n';
    std::cin >> max;
    srand(time(NULL));
    int toGuess = rand() % (max+1);   
    while (!guesed)
    {
        guesses++;
        std::cout << "bitte gib deine geratene Zahl ein:"<< '\n';
        std::cin >> guess;
        if (guess == toGuess){
            break;
        }else if (guess<toGuess){
            std::cout << "deine geratene Zahl war kleiner, als die zu ratenen Zahl"<< '\n';
        }else if (guess>toGuess){
            std::cout << "deine geratene Zahl war größer, als die zu ratenen Zahl"<< '\n';
        } 
    }
    std::cout << "du hast " << guesses << " versuche gebraucht um die zahl: " << toGuess << " bei einem maximalwert von: " << max << " zu erraten" << '\n';
    
}