/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiass3;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Boshy
 */
public class readfile {
    
     private Scanner x ;
     public void openfile(String path) {
         try{
         x= new Scanner(new File(path));
         }
         catch (Exception e){
             System.out.println("file not found !!!");
         }
     }
     public String readfile() {
         String word="";
         while(x.hasNext()){
             word+=x.next();
         }
         return word;
     }
     public void closefile(){
         x.close();
     }
}
