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
public class decom {
    public decom(){
         //Scanner input = new Scanner(System.in);
        //int r=input.nextInt();
        //System.out.println("enter path for compressed file :");
        //String path = input.next();
        //System.out.println("enter path for decompressed file :");
        //String path2 = input.next();
    readfile f1 = new readfile();
    writefile f2= new writefile();
    f1.openfile("compressed.txt");
    f2.openfile("decompressed.txt");
    String source2;
    source2=f1.readfile();
    ArrayList<String> list = new ArrayList<String>();
        /////////////////////////////////////////////
        //varibles
        int offset = 0,offset2=0,first=1;
        String word = "" ;char charr,charr2; 
        String st="",st2="";
        boolean x=true,y=true;
        ////////////////////////////////////////////
        for(int i=0;i<source2.length();i++){
           charr = source2.charAt(i);
           if(charr!=','){
           word+=charr;
           continue;
           }
           if(charr==','){
           offset=Integer.parseInt(word);
           }
           if(offset>=0&&offset<128){
           charr2=(char) offset;
           st+=charr2;
           f2.addrecord(st);
           if(first==1){
             offset2=offset;
             st="";
             word="";
             offset=0;
             first=2;
             continue;
           }
             else{
             charr2=(char) offset2;
             st2+=charr2;
             st2+=st.charAt(0);
             list.add(st2);
             st="";
             word="";
             st2="";
             offset2=offset;
             offset=0;
             continue;   
                  }
           
           }
           if(offset>127){
               offset-=128;
             if(list.size()>offset){
             st=list.get(offset);
             f2.addrecord(st);
             if(offset2>127){
             st2+=list.get(offset2-128)+st.charAt(0);}
             else{
                 charr2=(char)offset2;
                 st2+=charr2;st2+=st.charAt(0);}
             list.add(st2);
             }
             else{
               if(offset2>127){  
             st2+=list.get(offset2-128)+list.get(offset2-128).charAt(0);}
               else{
                   charr2=(char)offset2;
                   st2+=charr2;
                   st2+=charr2;}
             f2.addrecord(st2);
             list.add(st2);
             }    
             st="";
             word="";
             st2="";
             offset2=offset+128;
             offset=0;
        }}
        
     f1.closefile();
     f2.closefile();
    }
    }

