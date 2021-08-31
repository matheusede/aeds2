#include <stdio.h>

//Função usada para calcular os anos em que o cometa passa.
int yearsCalculator(int input, int years){
    years = 1986;
    while(input >= years){
        years += 76; //Seleciona o ano mais próximo após o ano inserido.
    }
    return years;
}

int main(){
    int input = 1, years = 0, output;

    while(input != 0){
        scanf("%d", &input);
        if(input == 0)
            break;
        output = yearsCalculator(input, years);
        printf("%d\n", output);
    }
    return 0;
}