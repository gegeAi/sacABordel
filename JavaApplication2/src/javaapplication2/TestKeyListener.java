package javaapplication2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* ############################################################################
 * 
 * TestKeyListener.java : démonstration de la capture d'événements issus du
 *                        clavier.
 * 
 * Auteur : Christophe Jacquet, Supélec
 * 
 * Historique
 * 2006-12-19  Création
 * 
 * ############################################################################
 */
 
 
 
/**
 * Programme de test des KeyListener : affiche une fenêtre où un JLabel
 * affiche les codes de touches appuyées et relâchées.
 */
public class TestKeyListener {
    private static final long serialVersionUID = -5222658361778310082L;
 
    public static boolean save = false;
    public static String buffer = "";
    public static String file = "";
     
    public static void main(String[] args) {
        
        try{
		  BufferedReader urlReader = new BufferedReader(new InputStreamReader(new URL("http://www.hearthpwn.com/search?decks-sort=-rating&search=priest%20dragon#t1:decks").openStream()));
 
		  String s;
 
		  while((s = urlReader.readLine()) != null){
                      
                    Pattern p2 = Pattern .compile("(</tr>)");
                    Matcher m2 = p2.matcher(s);
                    if(m2.find())
                        s = endSave(s);  
                    
                    Pattern p = Pattern .compile("<tr class=\"(even)|(odd)\">");
                    Matcher m = p.matcher(s);
                    if(m.find())
                        beginSave(s);
                
                    save(s);
		  }
		  urlReader.close();
                  
                  
		}
		catch(Exception e){
		  System.out.println("Erreur : " + e);
		}
        
        try{
            Pattern p = Pattern .compile("\"/decks/.*\"");
            Matcher m = p.matcher(file);
            while (m.find())
               getDeckList(file.substring(m.start()+2, m.end()-1));
         }catch(Exception pse){
         }
        
    }
    
    public static String beginSave(String s) {
        
        s = s.split("<tr class=\"(even)|(odd)\">")[1];
        save = true;
        return s;
    }
    
    public static void save(String s) throws IOException {
        if(!save) 
            return;
        buffer += s+"\n";
    }
    
    public static String endSave(String s) throws IOException {
        
        
        
        save = false;
        String[] renvoi = s.split("</tr>");
        if(renvoi.length > 0)
            buffer += renvoi[0]+"</tr>\n\n";
        else
            buffer += "</tr>\n\n";
        
        Pattern p = Pattern .compile("build-latest");
        Matcher m = p.matcher(s);
        if(m.find())
            file += buffer;
        buffer = "";
        
        if(renvoi.length > 1) {
            return renvoi[1];
        }
        else
            return "";
    }
    
    public static void getDeckList(String name) {
        System.out.println("http://www.hearthpwn.com/"+name);
        boolean wr = false;
        String buf = "";
        String buf2 = "";
        try{
                BufferedReader urlReader = new BufferedReader(new InputStreamReader(new URL("http://www.hearthpwn.com/"+name).openStream()));
                FileWriter localFile = new FileWriter(new File(name+".html"));

                String s;

                while((s = urlReader.readLine()) != null){
                  buf += s + "\n";
                }
                  
                Pattern p = Pattern .compile("<aside");
                Matcher m = p.matcher(buf);
                while (m.find())
                    buf2 = buf.substring(m.start(), buf.length()-1);
                
                Pattern p2 = Pattern .compile("</aside>");
                Matcher m2 = p2.matcher(buf2);
                while (m2.find())
                    buf = buf2.substring(0, m2.end());
                  localFile.write(buf);
		  urlReader.close();
		  localFile.close();
                  
                  
		}
		catch(Exception e){
		  System.out.println("Erreur : " + e);
		}
      
    }
        
}
 
 