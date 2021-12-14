import java.io.*;
import java.net.*;

class Main {
    
    public static boolean finishProgram(String s){
        
        
        if((s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') ){ // CHECAR SE FIM FOI ESCRITO
            
            return true;
        }
        
        else{ 
            
        return false; 
            
        }
        
    }
    
    
    
    
   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
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
   public static void main(String[] args) {
      String endereco, html;
      endereco = "http://maratona.crc.pucminas.br/series/Friends.html";
      html = getHtml(endereco);
      
      String nome;
      
      int vogal = 0;
      
       int[] proc = {97, 101, 105, 111, 117, 225, 233, 237, 243, 250, 224, 232, 236, 897, 901, 227, 245, 226, 234,  789, 244, 790};
      
      while (true)
      {
          
          int[] values = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0, 0, 0, 0, 0};
          
          nome = MyIO.readLine();
          
          if(finishProgram(nome) == true  ){ break; }
          
          endereco = MyIO.readLine();
          
          html = getHtml(endereco);
          
          for(int i = 0; i < 25; i++)
          {
              
             
              
              for(int j = 0; j < html.length(); j++ )
              {
                  vogal = 0;
                  
                  
                  if( i < 22){
                  
                  if((int)(html.charAt(j)) == proc[i])        // COMPARAR COM VOGAIS NA LISTA DE VOGAIS DO ARRAY
                  {
                     // if(i > 4){ MyIO.println(html.charAt(j) + " " + (int)(html.charAt(j)) + " " + i );}
                      values[i] += 1;
                                              
                      
                  }
                  }
                  
                  if( i == 22)
                  {
                      
                      for(int k = 0; k < 22; k++)
                      {
                          if( (int)(html.charAt(j)) == proc[k] ){ vogal++; } // SE LETRA ENCONTRADA EM LISTA DE VOGAIS, ENTAO NAO E CONSOANTE


                      }
                      if( (html.charAt(j) >= 'a' && html.charAt(j) <= 'z') || ( html.charAt(j) >= 'A' && html.charAt(j) <= 'Z')   ) { }
                      else{ vogal++; }
                      
                      if(html.charAt(j) >= '0' && html.charAt(j) <= '9'){ vogal++; }
                      
                      if( vogal == 0){ values[22]++; }
                      
                  }
                  
                  if( i == 23)
                  {
                      
                      if(html.charAt(j) == 'b' && html.charAt(j + 1) == 'r' && html.charAt(j + 2) == '>' ){values[23]++; }
                      
                      
                  }
                  
                  
                  if( i == 25)
                  {
                      
                      if(html.charAt(j) == 't' && html.charAt(j + 1) == 'a' && html.charAt(j + 2) == 'b' && html.charAt(j + 3) == 'l' ){values[24]++; }
                      
                      
                  }
                  
                  
              }
              
              
              
              
          }
          
         MyIO.println("a(" + values[0] + ") " + "e(" + values[1] + ") " + "i(" + values[2] + ") " + "o(" + values[3] + ") " + "u(" + values[4] + ") " +
         
        "á(" + values[5] + ") " + "é(" + values[6] + ") " + "í(" + values[7] + ") " + "ó(" + values[8] + ") " + "ú(" + values[9] + ") " +
        "à(" + values[10] + ") " + "è(" + values[11] + ") " + "ì(" + values[12] + ") " + "ò(" + values[13] + ") " + "ù(" + values[14] + ") " +
        "ã(" + values[15] + ") " + "õ(" + values[16] + ") " + "â(" + values[17] + ") " + "ê(" + values[18] + ") " + "î(" + values[19] + ") " +
        "ô(" + values[20] + ") " + "û(" + values[21] + ") " + "consoante(" + values[22] + ") " + "<br>(" + values[23] + ") " +
        "<table>(" + values[24] + ") " + nome);   
        
         
         
          
      }
      
      
      
      
      
      
   }
}
