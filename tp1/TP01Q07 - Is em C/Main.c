#include <stdio.h>
#include <string.h>
#include <stdbool.h>


//Função que finaliza o programa
bool returnEnd(char fim []){
    bool result;

    result = (strlen(fim) == 4 && fim[0] == 'F' && fim[1] == 'I' && fim[2] == 'M');

    return result;
}

//Função que verifica a string, procurando apenas vogáis
bool verifyVogals(char input[]){
    bool result = false;

    for(int i = 0; i < strlen(input) - 1; i++){

        if(input[i] > 64 && input [i] < 91 || input[i] > 96 && input[i] < 123){
            if(input[i] == 'A' || input[i] == 'E' || input[i] == 'I' ||input[i] == 'O' || input[i] == 'U' || 
            input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u'){
                result = true;
            }
            else{
                result = false;
                break;
            }
        }

        else{
            result = false;
            break;
        }
    }
    return result;
}

//Função que verifica a string, procurando apenas consoantes.
bool verifyConsonants(char input[]){
    bool result = false ;

    for(int i = 0; i < strlen(input) - 1; i++){

        if(input[i] > 64 && input [i] < 91 || input[i] > 96 && input[i] < 123){
            if(input[i] != 'A' && input[i] != 'E' && input[i] != 'I' &&input[i] != 'O' && input[i] != 'U' && 
            input[i] != 'a' && input[i] != 'e' && input[i] != 'i' && input[i] != 'o' && input[i] != 'u'){
                result = true;
            }
            else{
                result = false;
                break;
            }
        }
        else{
            result = false;
            break;
        }
    }
    return result;
}

//Função que verifica a string, procurando apenas números inteiros
bool verifyInteger(char input[]){
    bool result = false ;

    for(int i = 0; i < strlen(input) -1; i++){
        if(input[i] > 47 && input[i] < 58){
            result = true;
        }
        else{
            result = false;
            break;
        }
    }
    return result;
}

//Função que verifica a string, procurando apenas números reais.
bool verifyReal(char input[]){
    bool result = false;
    int counter = 0;


    for(int i = 0; i < strlen(input) - 1; i++){
        if(input[i] > 47 && input[i] < 58  || input[i] == 46 || input[i] == 44){
            if (input[i] == 46 || input[i] == 44){
                counter++;
            }
            result = true;
        }
        else{
            result = false;
            break;
        }
    }

    if (counter == 0)
        result = false;
    else if(counter > 1){
        result = false;
    }
    return result;
}

//Metódo main
int main() {
    char in [200];

    do{
        fflush(stdin);
        fgets(in, 200, stdin);

        if (verifyVogals(in) == true){
            printf("SIM ");
        }
        else
            printf("NAO ");

        if (verifyConsonants(in) == true){
            printf("SIM ");
        }
        else
            printf("NAO ");

        if (verifyInteger(in) == true){

            printf("SIM ");
        }
        else
            printf("NAO ");
        
        if (verifyReal(in) == true){
        printf("SIM\n");
        }
        else
            printf("NAO\n");
     

    } while (returnEnd(in) == false);

    return 0;
}
