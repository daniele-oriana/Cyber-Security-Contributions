/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selforgerybirthatt;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniele Oriana
 */
public class BirthAttack1457625 {
    
    
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, FileNotFoundException, InvalidKeyException {
        
        copiaFile("ContractGood1457625.txt", "Copia1Good");
        copiaFile("ContractGood1457625.txt", "Copia2Good");
        copiaFile("ContractBad1457625.txt", "Copia1Bad");
        copiaFile("ContractBad1457625.txt", "Copia2Bad");
        
        Random rm = new Random();
        int metodo = rm.nextInt(3 - 1 + 1) + 1;
        Random rm1 = new Random();
        int tipo = rm1.nextInt(2 - 1 + 1) + 1;
        int dueFile=0;
        
        HashMap hmGood = new HashMap<String, String>();
        HashMap hmBad = new HashMap<String, String>();
        
        System.out.print("Searching");
        
        while(true) {
            
            System.out.print(".");
            
            
            if(dueFile%2==0) { //da 1 a 2
                
                if(tipo==1) { // good
                    String hash="";
                    String stringaDaFile="";
                    if(metodo==1) {
                        randomMaiusc("Copia1Good.txt", "Copia2Good.txt");
                        stringaDaFile = new Scanner(new File("Copia2Good.txt")).useDelimiter("\\Z").next();
                        hash = calcolaHASH("Copia2Good.txt");
                      
                    }
                    if (metodo == 2) {
                        randomSlash("Copia1Good.txt", "Copia2Good.txt");
                        stringaDaFile = new Scanner(new File("Copia2Good.txt")).useDelimiter("\\Z").next();
                        hash = calcolaHASH("Copia2Good.txt");
                    }
                    if (metodo == 3) {
                        randomSpaces("Copia1Good.txt", "Copia2Good.txt");
                        stringaDaFile = new Scanner(new File("Copia2Good.txt")).useDelimiter("\\Z").next();
                        hash = calcolaHASH("Copia2Good.txt");
                    }

                    if (hmBad.containsKey(hash) && !(hmBad.get(hash)).equals(stringaDaFile)) {
                        System.out.println("");
                        System.out.println("SHA collision found, please check the resulting contracts in Official1457625.txt e Unofficial1457625.txt  Hash ---> " + hash);
                        scriviStringa(stringaDaFile, "Official1457625.txt");
                        scriviStringa((String)hmBad.get(hash), "Unofficial1457625.txt");
                        break;
                    }
                    else {
                        hmGood.put(hash, stringaDaFile);
                    }

                }
                
                else { //bad
                    
                    String hash="";
                    String stringaDaFile="";
                    
                    if(metodo==1) {
                        randomMaiusc("Copia1Bad.txt", "Copia2Bad.txt");
                        stringaDaFile = new Scanner(new File("Copia2Bad.txt")).useDelimiter("\\Z").next();
                        hash = calcolaHASH("Copia2Bad.txt");
                    }
                    
                    if(metodo==2) {
                        randomSlash("Copia1Bad.txt", "Copia2Bad.txt");
                        stringaDaFile = new Scanner(new File("Copia2Bad.txt")).useDelimiter("\\Z").next();
                        hash = calcolaHASH("Copia2Bad.txt");
                    }
                    
                    if(metodo==3) {
                        randomSpaces("Copia1Bad.txt", "Copia2Bad.txt");
                        stringaDaFile = new Scanner(new File("Copia2Bad.txt")).useDelimiter("\\Z").next();
                        hash = calcolaHASH("Copia2Bad.txt");
                    }
                    
                    if(hmGood.containsKey(hash) && !(hmGood.get(hash).equals(stringaDaFile))) {
                        System.out.println("");
                        System.out.println("SHA collision found, please check the resulting contracts in Official1457625.txt e Unofficial1457625.txt  Hash ---> " + hash);
                        scriviStringa(stringaDaFile, "Unofficial1457625.txt");
                        scriviStringa((String)hmGood.get(hash), "Official1457625.txt");
                        break;
                    }
                    else {
                        hmBad.put(hash, stringaDaFile);
                    }
                    
                }
            }
            
            
            else { // da 2 a 1
                
                String hash="";
                String stringaDaFile="";
                    
                if(tipo==1) { //good
                    
                    if(metodo==1) {
                        randomMaiusc("Copia2Good.txt", "Copia1Good.txt");
                        hash = calcolaHASH("Copia1Good.txt");
                        stringaDaFile = new Scanner(new File("Copia1Good.txt")).useDelimiter("\\Z").next();
                    }
                    
                    if(metodo==2) {
                        randomSlash("Copia2Good.txt", "Copia1Good.txt");
                        hash = calcolaHASH("Copia1Good.txt");
                        stringaDaFile = new Scanner(new File("Copia1Good.txt")).useDelimiter("\\Z").next();
                    }
                    
                    if(metodo==3) {
                        randomSpaces("Copia2Good.txt", "Copia1Good.txt");
                        hash = calcolaHASH("Copia1Good.txt");
                        stringaDaFile = new Scanner(new File("Copia1Good.txt")).useDelimiter("\\Z").next();
                    }
                    
                    if(hmBad.containsKey(hash) && !(hmBad.get(hash).equals(stringaDaFile))) {
                        System.out.println("");
                        System.out.println("SHA collision found, please check the resulting contracts in Official1457625.txt e Unofficial1457625.txt  Hash ---> " + hash);
                        scriviStringa(stringaDaFile, "Official1457625.txt");
                        scriviStringa((String)hmBad.get(hash), "Unofficial1457625.txt");
                        break;
                    }
                    else {
                        hmGood.put(hash, stringaDaFile);
                    }
                }
                
                else { //bad
                    
                    if(metodo==1) {
                        randomMaiusc("Copia2Bad.txt", "Copia1Bad.txt");
                        hash = calcolaHASH("Copia1Bad.txt");
                        stringaDaFile = new Scanner(new File("Copia1Bad.txt")).useDelimiter("\\Z").next();
                    }
                    
                    if(metodo==2) {
                        randomSlash("Copia2Bad.txt", "Copia1Bad.txt");
                        hash = calcolaHASH("Copia1Bad.txt");
                        stringaDaFile = new Scanner(new File("Copia1Bad.txt")).useDelimiter("\\Z").next();
                    }
                    
                    if(metodo==3) {
                        randomSpaces("Copia2Bad.txt", "Copia1Bad.txt");
                        hash = calcolaHASH("Copia1Bad.txt");
                        stringaDaFile = new Scanner(new File("Copia1Bad.txt")).useDelimiter("\\Z").next();
                    }
                    
                    if(hmGood.containsKey(hash) && !(hmGood.get(hash).equals(stringaDaFile))) {
                        System.out.println("");
                        System.out.println("SHA collision found, please check the resulting contracts in Official1457625.txt e Unofficial1457625.txt  Hash ---> " + hash);
                        scriviStringa(stringaDaFile, "Unofficial1457625.txt");
                        scriviStringa((String)hmGood.get(hash), "Official1457625.txt");
                        break;
                    }
                    else {
                        hmBad.put(hash,stringaDaFile);
                    }
                }
                
            }
            
            
            
            
            
            if (dueFile == 15) {
                copiaFile("ContractGood1457625.txt", "Copia1Good");
                copiaFile("ContractGood1457625.txt", "Copia2Good");
                copiaFile("ContractBad1457625.txt", "Copia1Bad");
                copiaFile("ContractBad1457625.txt", "Copia2Bad");
                dueFile = -1;
            }
            
            metodo = rm.nextInt(3 - 1 + 1) + 1;
            tipo = rm.nextInt(2 - 1 + 1) + 1;
            dueFile++;
        }
        

    }
    
    
    
    
    public static void randomSlash(String source, String dest) {

        String line;
        PrintWriter writer = null;

        InputStream fis;
        try {
            fis = new FileInputStream(source);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            writer = new PrintWriter(dest, "UTF-8");
            Random rm = new Random();
            int scelta = rm.nextInt(100 - 1 + 1) + 1;

            while ((line = br.readLine()) != null) {

                if (scelta <= 85 && scelta >= 80) {
                    writer.println(line);
                    writer.println("");
                } else {
                    writer.println(line);
                }

                scelta = rm.nextInt(100 - 1 + 1) + 1;
            }
            writer.flush();
            writer.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelForgeryBirthAtt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SelForgeryBirthAtt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void randomSpaces(String source, String dest) {

        String line;
        PrintWriter writer = null;

        InputStream fis;
        try {
            fis = new FileInputStream(source);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            writer = new PrintWriter(dest, "UTF-8");

            while ((line = br.readLine()) != null) {

                String[] words = line.split(" ");
                String lines = "";
                
                Random rm = new Random();
                int scelta = rm.nextInt(100 - 1 + 1) + 1;

                for (int i = 0; i < words.length; i++) {

                    String word = words[i];

                    
                    if(scelta<=5) {
                        //System.out.println(word);
                        lines = lines + word + "  ";
                    }
                    else {
                        lines = lines + word + " " ;
                    }
                    scelta = rm.nextInt(100 - 1 + 1) + 1;
                }

                //System.out.println(lines);
                writer.println(lines);

            }
            writer.flush();
            writer.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelForgeryBirthAtt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SelForgeryBirthAtt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void randomMaiusc(String source, String dest) {
        
        String line;
        PrintWriter writer = null;

        InputStream fis;
        try {
            fis = new FileInputStream(source);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            writer = new PrintWriter(dest, "UTF-8");

            while ((line = br.readLine()) != null) {

                String[] words = line.split(" ");
                String lines = "";
                
                Random rm = new Random();
                int scelta = rm.nextInt(100 - 1 + 1) + 1;

                for (int i = 0; i < words.length; i++) {

                    String word = words[i];
                    if(scelta>=95) {
                        //System.out.println(word);
                        lines = lines + StringUtils.capitalize(word)+ " ";
                    }
                    else {
                        lines = lines + word + " ";
                    }
                    scelta = rm.nextInt(101 - 1 + 1) + 1;
                }

                //System.out.println(lines);
                writer.println(lines);

            }
            writer.flush();
            writer.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelForgeryBirthAtt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SelForgeryBirthAtt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public static void scriviStringa(String testo, String dest) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter out = new PrintWriter(dest,  "UTF-8");
        out.println(testo);
        out.close();
    }
    
    
    
    public static void copiaFile(String filePath, String dest) {

        String line;
        PrintWriter writer = null;

        InputStream fis;
        try {
            fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            writer = new PrintWriter(dest+".txt", "UTF-8");

            while ((line = br.readLine()) != null) {

                String[] words = line.split(" ");
                String lines = "";

                for (int i = 0; i < words.length; i++) {

                    String word = words[i];
                    lines = lines + word + " ";

                }

                //System.out.println(lines);
                writer.println(lines);

            }
            writer.flush();
            writer.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelForgeryBirthAtt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SelForgeryBirthAtt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public static String calcolaHASH(String filePath) throws NoSuchAlgorithmException, FileNotFoundException, IOException, InvalidKeyException {
        
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        FileInputStream fis = new FileInputStream(filePath);

        byte[] dataBytes = new byte[1024];

        int nread = 0;
        while ((nread = fis.read(dataBytes)) != -1) {
          md.update(dataBytes, 0, nread);
        };
        byte[] mdbytes = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        String returning = sb.toString();
        returning = returning.substring(0, 6);
        return returning;
        
    }
}
