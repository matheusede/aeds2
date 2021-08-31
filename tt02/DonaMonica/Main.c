#include <stdio.h>

int calculateOlderBrother(int youngerBrother, int middleBrother, int mother){
    int olderBrother = 0;

    olderBrother = (mother - youngerBrother - middleBrother);

    return olderBrother;
}

int main(){
    int olderBrotherAge = 0, youngerBrotherAge = 0,
    middleBrotherAge = 0, motherAge = 0;

    while (motherAge != 0)
    {
        scanf("%d, %d, %d", &motherAge, &youngerBrotherAge, &middleBrotherAge);
        if(motherAge == 0)
            break;
        olderBrotherAge = calculateOlderBrother(youngerBrotherAge, middleBrotherAge, motherAge);
        printf("%d", olderBrotherAge);
    }
    

    return 0;
}