package com.ranying;

import java.util.HashSet;
import java.util.Set;

public class Number {

    public static void main(String[] args) {

        Set<Integer> killSets = new HashSet<>();

        int count = 0;
        for (int i = 1; i <= 11; i++) {
            for (int j = i + 1; j <= 11; j++) {
                for (int k = j + 1; k <= 11; k++) {
                    killSets = new HashSet<>();
                    killSets.add(i);
                    killSets.add(j);
                    killSets.add(k);
                    if(killSets.size()==3){
                        System.out.println("");
                        System.out.println("杀" + i + "," + j + "," + k);
                        processScheme(killSets);
                        count++;
                    }
                }
            }
        }
        System.out.println("总共：" +  count);


        /*for (int i = 3; i <= 11; i++) {
            Set<Integer> killSet = new HashSet<>();
            killSet.add(i - 2);
            killSet.add(i - 1);
            killSet.add(i);
            System.out.println("杀" + (i - 2) + "," + (i - 1) + "," + i);
            //processScheme(killSet);
        }*/

    }

    public static void processScheme(Set<Integer> killSet) {
        int count = 0;
        for (int code1 = 1; code1 < 11; code1++) {
            if (killSet.contains(code1)) continue;
            for (int code2 = code1 + 1; code2 <= 11; code2++) {

                if (killSet.contains(code2)) continue;
                for (int code3 = code2 + 1; code3 <= 11; code3++) {

                    if (killSet.contains(code3)) continue;
                    for (int code4 = code3 + 1; code4 <= 11; code4++) {

                        if (killSet.contains(code4)) continue;
                        for (int code5 = code4 + 1; code5 <= 11; code5++) {

                            if (killSet.contains(code5)) {
                                continue;
                            }
                            String result = code1 + " " + code2 + " " + code3 + " " + code4 + " " + code5 + ",";
                            System.out.println(result);
                            count ++ ;
                        }
                    }
                }
            }
        }
        System.out.println("一共："+ count);
    }

}
