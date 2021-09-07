import java.io.*;
import java.net.*;

class Main {

   //Função que finaliza o programa
   public static boolean returnEnd(String fim) {
      boolean result;

      result = (fim.length() == 3 && fim.charAt(0) == 'F' && fim.charAt(1) == 'I' && fim.charAt(2) == 'M');

      return result;
   }

   //Função que transforma uma string em um vetor de char.
   public static char[] stringToChar(String input) {

      char[] characters = new char[input.length()];

      for (int i = 0; i < input.length(); i++) {
         char aux = (char)(input.charAt(i));
         characters[i] = aux;
      }

      return characters;
   }

   //Função que retorna o HTML da página, retirada do Github de Aed2
   public static String getHtml(String link) {
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(link);
         is = url.openStream(); // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }

   //função que retorna a
   public static int returnA(char character) {
      int result = 0;
      if (character == 'a')
         result++;

      return result;
   }

   //função que retorna e
   public static int returnE(char character) {
      int result = 0;
      if (character == 'e')
         result++;

      return result;
   }

   //função que retorna i
   public static int returnI(char character) {
      int result = 0;
      if (character == 'i')
         result++;

      return result;
   }

   //função que retorna o
   public static int returnO(char character) {
      int result = 0;
      if (character == 'o')
         result++;

      return result;
   }

   //função que retorna u
   public static int returnU(char character) {
      int result = 0;
      if (character == 'u')
         result++;

      return result;
   }

   //função que retorna á
   public static int returnAcuteA(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna é
   public static int returnAcuteE(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna í
   public static int returnAcuteI(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna ó
   public static int returnAcuteO(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna ú
   public static int returnAcuteU(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna à
   public static int returnGraveA(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna è
   public static int returnGraveE(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna ì
   public static int returnGraveI(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna ò
   public static int returnGraveO(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna ù
   public static int returnGraveU(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna ã
   public static int returnTildeA(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna õ
   public static int returnTildeO(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   //função que retorna õ
   public static int returnCircumflexA(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   public static int returnCircumflexE(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   public static int returnCircumflexI(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   public static int returnCircumflexO(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }

   public static int returnCircumflexU(char character) {
      int result = 0;
      if (character == '�')
         result++;

      return result;
   }
   //Função que verifica a string, procurando apenas consoantes.
   public static int verifyConsonants(char character) {
      int result = 0;

      if (character > 96 && character < 123) {
         if (character != 'A' && character != 'E' && character != 'I' && character != 'O' && character != 'U' &&
            character != 'a' && character != 'e' && character != 'i' && character != 'o' && character != 'u') {
            result++;
         }
      }
      return result;
   }

   //função que retorna o resultado
   public static void returnFinalString(String html, String nome) {

      int[] chars = new int[23];

      char[] htmlArray = stringToChar(html);

      for (int counter = 0; counter < html.length(); counter++) {
         chars[0] += returnA(htmlArray[counter]);
         chars[1] += returnE(htmlArray[counter]);
         chars[2] += returnI(htmlArray[counter]);
         chars[3] += returnO(htmlArray[counter]);
         chars[4] += returnU(htmlArray[counter]);
         chars[5] += returnAcuteA(htmlArray[counter]);
         chars[6] += returnAcuteE(htmlArray[counter]);
         chars[7] += returnAcuteI(htmlArray[counter]);
         chars[8] += returnAcuteO(htmlArray[counter]);
         chars[9] += returnAcuteU(htmlArray[counter]);
         chars[10] += returnGraveA(htmlArray[counter]);
         chars[11] += returnGraveE(htmlArray[counter]);
         chars[12] += returnGraveI(htmlArray[counter]);
         chars[13] += returnGraveO(htmlArray[counter]);
         chars[14] += returnGraveU(htmlArray[counter]);
         chars[15] += returnTildeA(htmlArray[counter]);
         chars[16] += returnTildeO(htmlArray[counter]);
         chars[17] += returnCircumflexA(htmlArray[counter]);
         chars[18] += returnCircumflexE(htmlArray[counter]);
         chars[19] += returnCircumflexI(htmlArray[counter]);
         chars[20] += returnCircumflexO(htmlArray[counter]);
         chars[21] += returnCircumflexU(htmlArray[counter]);
         chars[22] += verifyConsonants(htmlArray[counter]);
      }

      System.out.printf("a(" + chars[0] + ") e(" + chars[1] +
         ") i(" + chars[2] + ") o(" + chars[3] + ") u(" + chars[4] + ") á(" + chars[5] + ") é(" + chars[6] + ") í(" +
          chars[7] + ") ó(" + chars[8] + ") ú(" + chars[9] + ") à(" + chars[10] + ") è(" + chars[11] + ") ì(" + chars[12] + 
          ") ò( "+ chars[13] + ") ù(" + chars [14] + ") ã(" + chars [15] + ") õ("  + chars[16] + ") â(" + chars[17] + ") ê(" + 
          chars[18] + ") î(" + chars[19] + ") ô(" + chars [20] + ") û(" + chars[21] + ") consoante(" + chars[22] + ") < br > (0) < table > (0) " + nome + "\n");
}

public static void main(String[] args) {
   String link, html,  name;
   String [] in = new String [1000];

   int inputNumber = 0;

    do{
        in[inputNumber] = MyIO.readLine();
        name = in[inputNumber];

        if(returnEnd(in[inputNumber++]) == true)
            break;
        
        in[inputNumber] = MyIO.readLine();
        link = in[inputNumber];
        html = getHtml(link);
        returnFinalString(html, name);

        if(returnEnd(in[inputNumber++]) == true)
        break;
    }while(true);
}

}