package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        int t=0;
        while (t++!=T){
            String string = br.readLine().trim();
            for (int i=0;i<string.length()/2;i+=2){
                System.out.print(string.charAt(i));
            }
            System.out.println();
        }
    }
}