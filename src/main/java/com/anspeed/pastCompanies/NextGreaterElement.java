package com.anspeed.pastCompanies;

import java.util.ArrayList;
import java.util.List;

/**
 Initially I see that we need to pass through digits from right to left
 I thought I would use String Builder to build a number but it turned out that
 I am adding unnecessary complexity, then I thought I would use array deque to add things front and rear.
 But later realized to just use normal list.

 Then I made a mistake that I can add element at Position 0
 534976 --> 536479
 6
 7
 9

 break element is 4   List is 6 7 9.

 remaining 53*

 here i thought just push break element at position 1 in the list: 6 (4) 7 9.

 it works fine. 536479

 but how about 2241

 remaining 2, break element 2,  list 1 4

 push 2 at position 1 :  2142 is result, its wrong.

 then I thought just parse thorugh remaining list and just get element bigger than break element.

 break element 2,  list 1 4  find element in the list that is bigger than 2 which is 4 and swap with it.

 so the list 1< 2, so pass then 4> 2 so replace with :-  4 1 2
 so  |2 4 1 2|
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
