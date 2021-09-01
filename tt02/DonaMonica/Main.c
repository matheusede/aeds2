#include <stdio.h>

//Função para retornar a idade do irmão mais velho
int returnOlderBrother(int mother, int brother1, int brother2){
    int brother3, olderBrother = 0;
    
    brother3 = mother - brother2 - brother1;

    if( brother3 > brother1 && brother3 > brother2) 
        olderBrother = brother3; 

    else if( brother1 > brother3 && brother1 > brother2) 
            olderBrother = brother1; 

    else if( brother2 > brother3 && brother2 > brother1) 
        olderBrother = brother2; 

    return olderBrother;
}
int main() {

    int olderBrother, mother = 1, brother1, brother2;

    while(mother != 0){

    scanf("%d %d %d", &mother, &brother1, &brother2);

    if(mother == 0)
        break; 

    olderBrother = returnOlderBrother(mother, brother1, brother2);

    printf("%d\n", olderBrother);

    return 0;
    }
}