#include <stdio.h>
#include <string.h>
#include <stdbool.h>

//Função que finaliza o programa
bool returnEnd(char fim []){
    bool result;

    result = (strlen(fim) == 4 && fim[0] == 'F' && fim[1] == 'I' && fim[2] == 'M');

    return result;
}

//Funçaõ que chama a recursiva
int verifyPalindrome(char input[]){
    return verifyPalidrome(input, 0, strlen(input) - 2);
}

//Função que verifica se é palindromo
int verifyPalidrome(char input [], int i, int j) {
    
    int result = 1;
    if (i < j)
        if (input[i] == input[j])
            result = verifyPalidrome(input, i + 1, j - 1);
    else
        result = 0;

    return result;

}

int main(){
    char input[200];
    int output = 1;
    do{
        fflush(stdin);
        fgets(input, 200, stdin);
        output = verifyPalindrome(input);
        if(output == 1)
            printf("SIM\n");
        else
            printf("NAO\n");
    }while(returnEnd(input) == false);
    
    return 0;
}