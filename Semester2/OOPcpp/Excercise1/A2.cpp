#include <iostream>
#include <limits>

int main() {
    std::cout
        << "Typ\t\t\t\t│ größe (in byte)\t│ Minimum\t\t\t\t│ Maximum\n"
        << "---------------------------------------------------------------------------------\n"
        << "char\t\t\t│ "
        << sizeof(unsigned char) << "\t\t\t\t\t│ "
        << +std::numeric_limits<unsigned char>::min() << "\t\t\t\t\t\t│ "
        << +std::numeric_limits<unsigned char>::max() << '\n'
        << "short int\t\t│ "
        << sizeof(short int) << "\t\t\t\t\t│ "
        << std::numeric_limits<short int>::min() << "\t\t\t\t│ "
        << std::numeric_limits<short int>::max() << '\n'
        << "int\t\t\t\t│ "
        << sizeof(int) << "\t\t\t\t\t│ "
        << std::numeric_limits<int>::min() << "\t\t\t│ "
        << std::numeric_limits<int>::max() << '\n'
        << "long int\t\t│ "
        << sizeof(long int) << "\t\t\t\t\t│ "
        << std::numeric_limits<long int>::min() << "\t│ "
        << std::numeric_limits<long int>::max() << '\n'
        << "long long int\t│ "
        << sizeof(long long int)<< "\t\t\t\t\t│ "
        << std::numeric_limits<long long int>::min() << "\t│ "
        << std::numeric_limits<long long int>::max() << '\n';
    return 0;
}