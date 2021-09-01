import java.util.Scanner;

public class Main
{
    //Função para retornar a idade do irmão mais velho
    public static int returnOlderBrother(int mother, int brother1, int brother2){
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
    public static void main(String[] args) {

       Scanner keyboard = new Scanner(System.in);

       int olderBrother, mother = 1, brother1, brother2;

       while(mother != 0){

        mother = keyboard.nextInt();

        if(mother == 0)
            break; 

        brother1 = keyboard.nextInt();

        brother2 = keyboard.nextInt();

        olderBrother = returnOlderBrother(mother, brother1, brother2);

        System.out.println(olderBrother);
       }


    }
}