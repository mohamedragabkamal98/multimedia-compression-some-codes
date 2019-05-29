package assmulti2;
import java.util.*;
public class writefile {
 
 private Formatter x;
 public void openfile(String path) {
         try{
         x= new Formatter(path);
         }
         catch (Exception e){
             System.out.println("file not found !!!");
         }
         }
 public void addrecord(int off){
     x.format(""+off+",");
 }
  public void addrecord(String s){
     x.format("%s",s);
 }
 
 
 public void closefile(){
     x.close();
 }

}
