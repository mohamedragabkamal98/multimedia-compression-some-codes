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
public class decom {
    public decom(){
         //Scanner input = new Scanner(System.in);
        //int r=input.nextInt();
        //System.out.println("enter path for compressed file :");
        //String path = input.next();
        //System.out.println("enter path for decompressed file :");
        //String path2 = input.next();
    readfile f11 = new readfile();
    writefile f22= new writefile();
    f11.openfile("compressed.txt");
    f22.openfile("decompressed.txt");
    String source2;
    source2=f11.readfile();
    ArrayList<String> list2 = new ArrayList<String>();
        /////////////////////////////////////////////
        //varibles
        int offset2 = 0;
        char word2 = 0 ;
        String st="";
        char charr2 = source2.charAt(0);
        ////////////////////////////////////////////
        for(int i=0;i<source2.length();i++){
            boolean x=true;
            if(charr2=='<'){
                //charr2=source2.charAt(i+1);
        
                //offset2=charr2-48;
               // continue;
                String s="";
                for(int j=i+1;j<source2.length();j++){
                charr2=source2.charAt(j);
                if(charr2==','){
                offset2=Integer.parseInt(s);
                break;
                }
                else{
                    s=s+charr2;
                }
                }
                //Integer.parseInt
            }
           else if(charr2==','){
                charr2=source2.charAt(i+1);
                word2=charr2;
                continue;
            }
           else if(charr2=='>'){
                if(offset2==0){
                    st=st+word2;
                    
                }
                else if(offset2<=list2.size()){
                st=list2.get(offset2-1)+word2;    
                }
                
                list2.add(st);
                f22.addrecord2(st);
                st="";
            }
            if(i!=source2.length()-1){
            charr2=source2.charAt(i+1);}
    }
        
     f11.closefile();
     f22.closefile();
    }
    }

