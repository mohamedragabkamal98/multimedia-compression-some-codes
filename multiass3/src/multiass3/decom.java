/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiass3;

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
    readfile f = new readfile();
    writefile f2= new writefile();
    f1.openfile("compressed.txt");
    f.openfile("table.txt");
    f2.openfile("decompressed.txt");
    ArrayList<String> code=new ArrayList<String>();
    ArrayList<String> chr=new ArrayList<String>();
    String source2,table;
    source2=f1.readfile();
    table=f.readfile();
    for(int i=0;i<table.length();i++)
    {String c="";
    c=c+table.charAt(i);
    if(",".equals(c)){ i++;c=""+table.charAt(i);chr.add(c); continue;}
    else if(":".equals(c)){
       String k="";
       i++;
        while(!",".equals(c))
        {
        k=k+table.charAt(i);
        c=""+table.charAt(i+1);
        i++;
        }
        code.add(k);
        continue;
    }
    else{c=""+table.charAt(i);chr.add(c);} 
    }
    String c="";
   for(int i=0;i<source2.length();i++){
       int m=code.size();
   c=c+source2.charAt(i);
   for(int j=0;j<code.size();j++){
       String k="";
       k=code.get(j);
   if( k.equals(c)){
     String l=chr.get(j);  
    f2.addrecord(l);
   c="";
   break;
   }
   }
   }
     f1.closefile();
     f.closefile();
     f2.closefile();
    }
    }

