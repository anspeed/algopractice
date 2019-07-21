package com.anspeed.pastCompanies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akolukuluru on 7/21/19.
 */
public class NextGreaterElement {
    public int nextGreaterElement(int n) {
        if(n/10==0){
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        int temp = n;
        int prevDigit = -1;
        int breakDigit = -1;
        while(temp!=0){
            if(prevDigit > temp%10) {
                breakDigit = temp%10;
                temp=temp/10;
                break;
            }
            prevDigit = temp%10;
            list.add(prevDigit);
            temp=temp/10;
        }

        if(prevDigit ==-1 || breakDigit == -1){
            return -1;
        }

        list.add(0,breakDigit);
        for(int i=1;i<list.size();i++){
            int biggerThanBreak = list.get(i);
            if(biggerThanBreak>breakDigit){
                list.set(i,breakDigit);
                list.set(0,biggerThanBreak);
                break;
            }
        }
        for(int i=0;i<list.size();i++){
            temp = temp*10+list.get(i);
        }
        if(temp<n){//for out of range integers.
            return -1;
        }
        return temp;
    }

    private void printNextGreaterVal(int n){
        int k= nextGreaterElement(n);
        if(k!=-1 && k<=n){
            System.out.println("WRONGGGG Next greater for n:"+n+" is: "+k);
        }
        System.out.println("Next greater for n:"+n+" is: "+k);
        //Next greater for n:534976 is: 536479
    }

    public static void main(String[] rags){
        NextGreaterElement nextGreaterElement=new NextGreaterElement();
        nextGreaterElement.printNextGreaterVal(534976);
        nextGreaterElement.printNextGreaterVal(218765);
        nextGreaterElement.printNextGreaterVal(12);
        nextGreaterElement.printNextGreaterVal(21);
        nextGreaterElement.printNextGreaterVal(654321);
        nextGreaterElement.printNextGreaterVal(112);
        nextGreaterElement.printNextGreaterVal(2241);
        nextGreaterElement.printNextGreaterVal(1999999999);

    }
}
