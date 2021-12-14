import java.util.Scanner;

public class Main{

    public static boolean c(int a){
        return(a == 1 );
    }

    public static String substituiBooleano(String s, char A, char B, char C){
        return substituiBooleano(s, A, B, C, 0); 
    }
    
    public static String substituiBooleano(String s, char A, char B, char C, int i){
        if(s.length() == 1) 
            return s; 

        if(s.charAt(0) == '0' || s.charAt(0) == '1')
            return s;
        else{
            s = s.replace(" ", "");
            s = s.replace('A', A);
            s = s.replace('B', B);
            s = s.replace('C', C);
            s = s.replace("not(0)", "1");
            s = s.replace("not(1)", "0");
            s = s.replace("or(1,0)", "1");
            s = s.replace("or(0,1)", "1");
            s = s.replace("or(1,1)", "1");
            s = s.replace("or(0,0)", "0");
            s = s.replace("or(1,0,0)", "1");
            s = s.replace("or(1,0,1)", "1");
            s = s.replace("or(1,1,1)", "1");
            s = s.replace("or(0,0,1)", "1");
            s = s.replace("or(0,1,1)", "1");
            s = s.replace("or(0,1,0)", "1");
            s = s.replace("or(1,1,0)", "1");
            s = s.replace("or(0,0,0)", "0");
            s = s.replace("or(0,0,0,0)", "0");
            s = s.replace("or(0,0,0,1)", "1");
            s = s.replace("or(0,0,1,0)", "1");
            s = s.replace("or(0,0,1,1)", "1");
            s = s.replace("or(0,1,0,0)", "1");
            s = s.replace("or(0,1,0,1)", "1");
            s = s.replace("or(0,1,1,0)", "1");
            s = s.replace("or(0,1,1,1)", "1");
            s = s.replace("or(1,0,0,0)", "1");
            s = s.replace("or(1,0,0,1)", "1");
            s = s.replace("or(1,0,1,0)", "1");
            s = s.replace("or(1,0,1,1)", "1");
            s = s.replace("or(1,1,0,0)", "1");
            s = s.replace("or(1,1,0,1)", "1");
            s = s.replace("or(1,1,1,0)", "1");
            s = s.replace("or(1,1,1,1)", "1");
            s = s.replace("and(1,0)", "0");
            s = s.replace("and(0,1)", "0");
            s = s.replace("and(0,0)", "0");
            s = s.replace("and(1,1)", "1");
            s = s.replace("and(1,0,0)", "0");
            s = s.replace("and(1,0,1)", "0");
            s = s.replace("and(1,1,1)", "1");
            s = s.replace("and(0,0,1)", "0");
            s = s.replace("and(0,1,1)", "0");
            s = s.replace("and(0,1,0)", "0");
            s = s.replace("and(1,1,0)", "0");
            s = s.replace("and(0,0,0)", "0");
            s = s.replace("and(0,0,0,0)", "0");
            s = s.replace("and(0,0,0,1)", "0");
            s = s.replace("and(0,0,1,0)", "0");
            s = s.replace("and(0,0,1,1)", "0");
            s = s.replace("and(0,1,0,0)", "0");
            s = s.replace("and(0,1,0,1)", "0");
            s = s.replace("and(0,1,1,0)", "0");
            s = s.replace("and(0,1,1,1)", "0");
            s = s.replace("and(1,0,0,0)", "0");
            s = s.replace("and(1,0,0,1)", "0");
            s = s.replace("and(1,0,1,0)", "0");
            s = s.replace("and(1,0,1,1)", "0");
            s = s.replace("and(1,1,0,0)", "0");
            s = s.replace("and(1,1,0,1)", "0");
            s = s.replace("and(1,1,1,0)", "0");
            s = s.replace("and(1,1,1,1)", "1");
            return substituiBooleano(s, A, B, C, i + 1); 
        }
    }

    public static int entrada(int i){ 
        String entrada = MyIO.readLine();
        if(entrada.length() == 1) 
            return 0;
        if(entrada.charAt(0) == '0')
            return 0; 
        if(entrada.charAt(1) == '0')
            return 0; 
        int omega = entrada.charAt(0) - 48;
        char A, B, C;
        A = entrada.charAt(2);
        B = entrada.charAt(4); 
        C = entrada.charAt(6);

        String string;
        string = entrada.substring(omega*2 + 2); 
        MyIO.println(substituiBooleano(string, A, B, C));
        return entrada(i + 1);
    }

	public static void main(String[] args) {
        entrada(0);
	}
}
