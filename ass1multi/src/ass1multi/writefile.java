package ass1multi;
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
 public void addrecord(int off, char cha){
     x.format("<"+off+","+cha+">");
 }
 public void addrecord(int off, String cha){
     x.format("<"+off+","+cha+">");
 }
 public void addrecord2(String s){
     x.format(s);
 }
 public void closefile(){
     x.close();
 }

}
