package com.xiaoft.codeview817;

import com.sun.tools.javac.jvm.Code;

import java.util.*;

public class CodeView2 {
    List<List<String>> stringList = new ArrayList<>();
    int count = 0;
    boolean[] visited;
    String[] retStr ;

    public void get2DStringList(){
        Scanner sc = new Scanner(System.in);
        String str = "";
        while(sc.hasNextLine()){
            str =  sc.nextLine();
            String[] strArray = str.split(" ");
            stringList.add(Arrays.asList(strArray));
        }
        sc.close();
    }

    public boolean backTracking(List<List<String>> list,boolean[] visited,
                             int count,String currStr){
        if(count == list.size()){
            return true;
        }

        boolean hasNext = false;
        for(int i = 0; i < list.size(); i++){
            if(currStr.equals(list.get(i).get(0)) && ! visited[i]){
                visited[i] = true;
                hasNext = true;
                retStr[count] = currStr;
                currStr = list.get(i).get(1);
                break;
            }
        }

        if(hasNext == true){
            return backTracking(list,visited,count+1,currStr);
        }else{
            return false;
        }
    }

    public void backFun(){
        get2DStringList();
        for(List<String> strs : stringList){
            if(backTracking(stringList,visited,count,strs.get(0))){
                for(int i = retStr.length-1; i >= 0; i --){
                    System.out.println(retStr[i]);
                }
                return;
            }
        }

        System.out.println("NO");
    }

    public static void main(String[] args) {
        CodeView2 codeView2 = new CodeView2();
        codeView2.backFun();
    }
}
