/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1multi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Boshy
 */
public class compressed {
    public compressed(){
         //Scanner input = new Scanner(System.in);
         //System.out.println("enter path for source file :");
        // String path = input.next();
        //System.out.println("enter path for compressed file :");
       // String path2 = input.next();
       readfile f1= new readfile();
        writefile f2=new writefile();
        f2.openfile("compressed.txt");
        f1.openfile("change.txt");
        String source;
        source = f1.readfile();
        ArrayList<String> list = new ArrayList<String>();
        /////////////////////////////////////////////
        //varibles
        int offset = 0;
        String word ="";
        boolean x=false;
        ////////////////////////////////////////////
        for(int i=0;i<source.length();i++){
            char charr = source.charAt(i);
            x=false;
            word = word+charr;
            if(i==0){
                //first char
               list.add(word);
               f2.addrecord(offset,charr);
                        word="";
                        offset=0;
                        continue;
            }
            else if(i!=0){
                //search in the list
                for(int j=0;j<list.size();j++){
                    if(word.equals(list.get(j))){
                     offset=j+1;
                     x=true;
                     break;
                    }
                    
                }
            if(i+1==source.length()){
                //last char in source
               f2.addrecord(offset,charr); 
               break;
            }
            
                if(x==false){
                    //ده معناه انه خلاص وصل لانه معاك كلمه جديده فهيحطها في الفيل و الليست
                        list.add(word);
                        f2.addrecord(offset,charr);
                        word="";
                        offset=0;
                        
                }
                else{
                    continue;
                }
            }
        }
        
        
            f1.closefile();
            f2.closefile();
        }
    }
    

