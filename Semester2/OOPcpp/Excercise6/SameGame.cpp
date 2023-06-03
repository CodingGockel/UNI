#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>

using namespace std;

const int BOARD_SIZE = 9;
const char COLORS[] = {'R', 'G', 'B', 'Y', 'O'};

void initializeBoard(vector<vector<char>> &board) {
    srand(time(0));
    for (int i = 0; i < BOARD_SIZE; i++) {
        for (int j = 0; j < BOARD_SIZE; j++) {
            int randomColor = rand() % 5;
            board[i][j] = COLORS[randomColor];
        }
    }
}

void printBoard(const vector<vector<char>>& board) {
    cout << "  A B C D E F G H I\n";
    for (int i = 0; i < BOARD_SIZE; i++) {
        cout << i+1 << " ";
        for (int j = 0; j < BOARD_SIZE; j++) {
            char color = board[i][j];
            string colorCode;
            if (color == 'R') {
                colorCode = "\033[31m"; 
                cout << colorCode << "#" << " ";
            } else if (color == 'G') {
                colorCode = "\033[32m"; 
                cout << colorCode << "#" << " ";
            } else if (color == 'B') {
                colorCode = "\033[34m"; 
                cout << colorCode << "#" << " ";
            } else if (color == 'Y') {
                colorCode = "\033[33m"; 
                cout << colorCode << "#" << " ";
            } else if (color == 'O') {
                colorCode = "\033[35m"; 
                cout << colorCode << "#" << " ";
            } else {
                colorCode = "\033[0m";
                cout << colorCode << " " << " ";
            }
            
        }
        cout << "\033[0m" << i+1 <<  endl;
    }
    cout << "  A B C D E F G H I\n";
}

void findGroup(vector<vector<char>>& board, vector<vector<bool>> &visited, int row, int col, char color, vector<pair<int, int>> &group) {
    if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE){
        return;
    }
    if (visited[row][col] || board[row][col] != color){
        return;
    }
    visited[row][col] = true;
    group.push_back(make_pair(row, col));

    findGroup(board, visited, row - 1, col, color, group);
    findGroup(board, visited, row + 1, col, color, group); 
    findGroup(board, visited, row, col - 1, color, group); 
    findGroup(board, visited, row, col + 1, color, group);
}

void removeGroup(vector<vector<char>> &board, const vector<pair<int, int>> &group) {
    for (const auto& tile : group) {
        board[tile.first][tile.second] = ' ';
    }
}

void slideDown(vector<vector<char>>& board) {
    for (int j = 0; j < BOARD_SIZE; j++) {
        int emptyRow = BOARD_SIZE - 1;
        for (int i = BOARD_SIZE - 1; i >= 0; i--) {
            if (board[i][j] != ' ') {
                board[emptyRow][j] = board[i][j];
                emptyRow--;
            }
        }
        for (int i = emptyRow; i >= 0; i--) {
            board[i][j] = ' ';
        }
    }
}
void shiftColumns(vector<vector<char>>& board) {
    int emptyCol = 0;
    for (int j = 0; j < BOARD_SIZE; j++) {
        bool emptyColumn = true;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][j] != ' ') {
                emptyColumn = false;
                break;
            }
        }
        if (!emptyColumn) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                board[i][emptyCol] = board[i][j];
                if (emptyCol != j) {
                    board[i][j] = ' ';
                }
            }
            emptyCol++;
        }
    }
}
int calculateScore(const vector<pair<int, int>>& group) {
    int groupSize = group.size();
    return groupSize * (groupSize - 1);
}
void makeMove(vector<vector<char>>& board, int *s) {
    int row, col;
    cout << "Geben Sie die Koordinaten des Steins ein (z.B. C3): ";
    char input[3];
    cin >> input;

    col = input[0] - 'A';
    row = input[1] - '1';

    vector<vector<bool>> visited(BOARD_SIZE, vector<bool>(BOARD_SIZE, false));
    vector<pair<int, int>> group;

    findGroup(board, visited, row, col, board[row][col], group);

    if (group.size() > 1) {
        int score = calculateScore(group);
        *s += score;
        removeGroup(board, group);
        slideDown(board);
        shiftColumns(board);
        cout << "Gruppe entfernt! Punkte: " << score << " Score gesamt: " << *s << endl;
    } else {
        cout << "Keine Gruppe gefunden!" << endl;
    }
}

bool hasPossibleMoves(const vector<vector<char>>& board) {
    for (int i = 0; i < BOARD_SIZE; i++) {
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (board[i][j] != ' ') {
                if ((i - 1 >= 0 && board[i][j] == board[i - 1][j]) ||
                    (i + 1 < BOARD_SIZE && board[i][j] == board[i + 1][j]) ||
                    (j - 1 >= 0 && board[i][j] == board[i][j - 1]) ||
                    (j + 1 < BOARD_SIZE && board[i][j] == board[i][j + 1])) {
                    return true;
                }
            }
        }
    }
    return false;
}

int main() {
    vector<vector<char>> board(BOARD_SIZE, vector<char>(BOARD_SIZE, ' '));

    initializeBoard(board);
    printBoard(board);
    int score = 0;
    while (hasPossibleMoves(board)) {
        makeMove(board, &score);
        printBoard(board);
    }

    cout << "Spiel beendet! Score: " << score << "\n";

    return 0;
}
