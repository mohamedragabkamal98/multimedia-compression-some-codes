/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiass3;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import javafx.print.Collation;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author Boshy
 */
public final class compressed {
    public void printMap(Map mp) {
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }
}
 public void print_in_file(Map mp,writefile f) {
     f.openfile("table.txt");
     String s="";
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        s=s+pair.getKey() + ":" + pair.getValue()+",";
        //System.out.println(pair.getKey() + " = " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }
    f.addrecord(s);
    f.closefile();
}

public void code(Stack team,String code,Map map,boolean state,int node){  
String code1,code2,chr="";
int tms=team.size();
if(team.size()==1&&state==false){map.put(team.pop(), code);return ;}
else if(team.size()==1&&state==true){
    chr=chr+team.pop();
    code1=code+"0";
    code2=code+"1";
    if(node==1){
    map.put(chr, code1);}
     if(node==2){
    map.put(chr, code2);}
    return ;}
else if(team.size()==0){return;}
else{
code1=code+"0";
code2=code+"1";
tms=team.size();
chr=chr+team.pop();
map.put(chr,code1);
Stack ne=new Stack();
ne.push(team.pop());
code(ne,code2,map,true,1);
code(team,code2,map,true,2);
}



}
    public compressed(){
       readfile f1= new readfile();
        writefile f2=new writefile();
        writefile f=new writefile();
        f.openfile("table.txt");
        f2.openfile("compressed.txt");
        f1.openfile("change.txt");
        String source;
        
        source = f1.readfile();
        System.out.println(source);
        HashMap<String,Double> map=new HashMap<>();
        HashMap<String,String> map_code=new HashMap<>();
        /////////////////////////////////////////////
        //varibles
       String team1="",team2="";
       double team1_prob=0,team2_prob=0;
       double len=source.length();
       char c;String enters="";
       double counter=0;boolean check=true;
        ////////////////////////////////////////////
       for (int i=0;i<source.length();i++){
           String key="",prob="";double pro=0;
           c=source.charAt(i);
           for(int k=0;k<enters.length();k++){
               char cc=enters.charAt(k);
              if(c==cc){
                  check=false;
                  break;}
                  }
           if(check==false){check=true;continue;}
           enters=enters+c;
         for(int j=i;j<source.length();j++){
           if(source.charAt(j)==c){
               counter++;
           }

         }
                 pro=counter/len;
           key=key+c;
           map.put(key,pro);
           counter=0;
       }
   //sort
String ch[] = new String[map.size()];
double pro[] = new double[map.size()];
Iterator it = map.entrySet().iterator();
int u=0;
while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        String l=(String) pair.getKey();
        ch[u]=l;
        double r=(double) pair.getValue();
        pro[u]=r;
        u++;
        //System.out.println(pair.getKey() + " = " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
}

      //  System.out.println(pro.size());
for (int i=0;i<pro.length-1;i++){
for(int j=i+1;j<pro.length;j++){
        int s=pro.length;
if(pro[i]<pro[j]){
double t=0;String t2=""; 
t=pro[i];
t2=ch[i];
pro[i]=pro[j];
ch[i]=ch[j];
ch[j]=t2;
pro[j]=t;
        //System.out.println(pro.);
}

}
}
//////////////////////////////////////////////////end sort
for (int i=0;i<pro.length;i++){System.out.println(pro[i]);}
for (int i=0;i<pro.length;i++){System.out.println(ch[i]);}
HashMap<String,Double> ma=new HashMap<String,Double>();
for(int q=0;q<pro.length;q++){
ma.put(ch[q],pro[q]);
}
String ch2[] = new String[map.size()];
double pro2[] = new double[map.size()];
/*for(int i=0;i<pro.length;i++){
    pro2[i]=pro[i];
    ch2[i]=ch[i];
}*/ 

pro2=pro;
ch2=ch;

//map=map2;
int size_of_hashmap=pro.length;
if(size_of_hashmap<=2){
team1=ch[0];
team2=ch[1];
team1_prob=pro[0];
team2_prob=pro[1];        
}
if(size_of_hashmap>2){
team1=ch2[0];
team1_prob=pro2[0];
while(size_of_hashmap>2){
team2=ch2[size_of_hashmap-1]+ch2[size_of_hashmap-2];
team2_prob=pro2[size_of_hashmap-1]+pro2[size_of_hashmap-2];
size_of_hashmap--;
pro2[size_of_hashmap-1]=team2_prob;
ch2[size_of_hashmap-1]=team2;
if(size_of_hashmap<=2)
    break;
if(team2_prob>team1_prob){
String tem;
double te;
te=team1_prob;
tem=team1;
team1=team2;
team1_prob=team2_prob;
team2=tem;
team2_prob=te;
}
}}
Stack stack_team1=new Stack();
Stack stack_team2=new Stack();
for(int i=0;i<team1.length();i++){stack_team1.push(team1.charAt(i));}
for(int i=0;i<team2.length();i++){stack_team2.push(team2.charAt(i));}
        /*System.out.println(team1);
        System.out.println(team1_prob);
        System.out.println(team2);
        System.out.println(team2_prob);
        */
code(stack_team1,"0",map_code,false,0);
code(stack_team2,"1",map_code,false,0);

        //printMap(map_code);
for(int i=0;i<source.length();i++){
String value="",cr="";
cr=cr+source.charAt(i);
value=map_code.get(cr);
if(value==null){
value="0";
}
f2.addrecord(value);
}
        print_in_file(map_code, f);
   /////////////
  // Map<String,Double>map1=new TreeMap<String,Double>(map);
//        System.out.println(ma);
        //for(int i=0;i<map.size();i++){System.out.println(map.values());}
            f1.closefile();
            f.closefile();
            f2.closefile();
        }
    }
    

