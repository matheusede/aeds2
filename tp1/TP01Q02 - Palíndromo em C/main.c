#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool returnEnd(char fim [200]){
    bool result;

    result = (strlen(fim) == 2 && fim[0] == 'F' && fim[1] == 'I' && fim[2] == 'M');

    return result;
}

char verifyPalidrome (char input[200]){
    int i = 0;
    int j = strlen(input);
    char result [] = "SIM";

    while (i < j){
        if(input[i] != input[j])
            result = "NAO";
        i++;
        j--;
    }   
    return result;
}

int main(void){

    char in [1000] [200];
    char out [1000] [200];
    int inputNumber = 0;

    do{
        fgets(in[inputNumber], strlen(in[inputNumber]), stdin);
        out[inputNumber] [200] = verifyPalidrome(in[inputNumber]);
        printf("%s", out[inputNumber]);
    } while (returnEnd(in[inputNumber++]) == false);

    return 0;
}