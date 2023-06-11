#include <iostream>
#include <vector>

using namespace std;

class IntMenge{
    private:
        vector<bool> valid;
        int max;
        int min;
    public:
        IntMenge(int miN, int maX){
            max = maX;
            min = miN;
            for(miN; miN <= maX; miN++){
                valid.push_back(false);
            }
        }

        virtual ~IntMenge(){};

        bool isValid(int i){
            if(i <= max && i >= min){
                return true;
            }
            return false;
        }

        bool contains(int i){
            for(int j = 0; j < valid.size(); j++){
                if(valid[j] && (j + min == i)){
                    return true;
                }
            }
            return false;
        }

        void add(int i){
            if(!contains(i) && isValid(i)){
                valid[i - min] = true;
            }
        }

        void remove(int i){
            if(contains(i) && isValid(i)){
                valid[i - min] = false;
            }
        }

        int getSize(){
            int i = 0;
            for(bool e:valid){
                if(e){
                    i++;
                }
            }
            return i;
        }

        bool isEmpty(){
            if(getSize() == 0){
                return true;
            }
            return false;
        }

        vector<int> getElements(){
            vector<int> ret;
            for(int j = 0; j < valid.size(); j++){
                if(valid[j]){
                    ret.push_back(min + j);
                }
            }
            return ret;
        }

        void print(){
            cout << "[";
            for(int j = 0; j < valid.size(); j++){
                if(valid[j]){
                    cout << min + j << ",";
                }
            }
            cout << "]\n";
        }   
};


int main(){
    IntMenge m(10,100);
    int input;
    std::cin >> input ;
    while ( input != 0 )
    {
        if ( m.isValid(input) )
            m.add(input);
        std::cout << "Menge enth¨alt " << m.getSize() << " Elemente:" << std::endl;
        m.print();
        std::cin >> input;
    }
    std::vector<int> intv = m.getElements();
    for ( int i=0; i<intv.size(); i++ )
        m.remove(intv[i]);
    std::cout << (m.isEmpty() ? "Menge ist leer" : "Menge ist nicht leer") << std::endl;
}