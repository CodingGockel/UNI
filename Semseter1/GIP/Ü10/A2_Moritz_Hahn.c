#include <stdio.h>
void generateMagicSquare(int n, int square[n][n]) {
    int x = n / 2;
    int y = n - 1;

    for (int i = 1; i <= n * n; i++) {
        int k=0;
        while(k==0){
            if(square[y][x]==0){
                square[y][x] = i;
                printf("x:%d y:%d i:%d square[x][y]:%d\n",x,y,i,square[x][y]);
                break;
            }
            int nextX = x - 1;
            int nextY = y + 1;
            if(nextX>=n){
                x=0;
            }
            else if(nextX<0){
                x=n-1;
            }
            else{
                x--;
            }
            if(nextY>=n){
                y=0;
            }
            else if(nextY<0){
                y=n-1;
            }else{
                y++;
            }
        }
        int nextX = x + 1;
        int nextY = y + 1;
        if(nextX>=n){
            x=0;
        }
        else if(nextX<0){
            x=n-1;
        }
        else{
            x++;
        }
        if(nextY>=n){
            y=0;
        }
        else if(nextY<0){
            y=n-1;
        }
        else{
            y++;
        }
    }
}

int main(){
    int n = 3;
    int square[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            square[i][j]=0;
        }
        printf("\n");
    }
    generateMagicSquare(n, square);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", square[i][j]);
        }
        printf("\n");
    }
    return 0;
}


