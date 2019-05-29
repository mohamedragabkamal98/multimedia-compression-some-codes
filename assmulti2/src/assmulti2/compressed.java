/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assmulti2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Boshy
 */
public class compressed {
    public compressed(){
       readfile f1= new readfile();
        writefile f2=new writefile();
        f2.openfile("compressed.txt");
        f1.openfile("change.txt");
        String source;
        source = f1.readfile();
        ArrayList<String> list = new ArrayList<String>();
        /////////////////////////////////////////////
        //varibles
        int offset = 0,offset1=0;
        String word ="";
        boolean x=false,y=false,z=false;
        ////////////////////////////////////////////
        for(int i=0;i<source.length();i++){
            char charr = source.charAt(i);
            x=false;
            word = word+charr;
             if(i>=0){
             if(offset>=0&&offset<128&&y==false){
                offset=charr;
              offset1=offset;
              y=true;
              continue;
             }
             else{
             for(int j=0;j<list.size();j++){
                    if(word.equals(list.get(j))){
                     offset=j+128;
                     x=true;
                     z=true;
                     break;
                    }
                    
             }
              if(i+1==source.length()){
                //last char in source
               f2.addrecord(offset);
               if(x==false){
               f2.addrecord((int) charr);}
               break;
            }            
             if(x==false){
                        if(z==false){
                        f2.addrecord(offset1);
                        list.add(word);
                        }
                        else{
                        f2.addrecord(offset);
                        list.add(word);
                        }
                        z=false;
                        y=false;
                        word="";
                        offset=0;
                        offset1=0;
                        i--;
                }

             }
            }}
        
            f1.closefile();
            f2.closefile();
        }
    }
    

