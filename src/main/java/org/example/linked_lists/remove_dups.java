package org.example.linked_lists;
import java.util.ArrayList;
import java.util.Hashtable;

class remove_dups_testcase {
    public LinkedList input;
    public LinkedList output;

    public remove_dups_testcase(
            LinkedList input,
     LinkedList output
    ){
        this.input = input;
        this.output = output;
    }
}

/**
 * insight
 * p1 and p2, p1 = null and p2 = head
 * if not in the set, p1 is updated to p2
 * p2 moves every iteration
 * this is to deal with consecutive duplicates, e.g., 333
 */

public class remove_dups {
    static void solve(LinkedList list){
        boolean[] flag = new boolean[128];
        for(int i = 0; i < flag.length; i++) {
            flag[i] = false;
        }
        // fill here
        ListNode prevNode = null;
        ListNode currNode = list.getHead();
        while(currNode != null) {
            if(!flag[currNode.data]) {
                flag[currNode.data] = true;
                prevNode = currNode; // move p1 when not flagged
            } else {
                prevNode.next = currNode.next;
            }
            currNode = currNode.next;
        }
    }
    
    static void book_solution_no_buffer(LinkedList list) {
        ListNode p1 = list.getHead();
        ListNode p2;
        while(p1 != null) {
            p2 = p1;
            while(p2.next != null) {
                if(p2.next.data == p1.data) {
                    p2.next = p2.next.next;
                } else {
                    p2 = p2.next;
                }
            }
            p1 = p1.next;
        }
    }

    static void test() {
        ArrayList<remove_dups_testcase> testSet = new ArrayList<>();
        testSet.add(new remove_dups_testcase(new LinkedList(new int[]{3,3}), new LinkedList(new int[]{3})));
        testSet.add(new remove_dups_testcase(new LinkedList(new int[]{1,3,3}), new LinkedList(new int[]{1,3})));
        testSet.add(new remove_dups_testcase(new LinkedList(new int[]{3,1,3}), new LinkedList(new int[]{3,1})));
        testSet.add(new remove_dups_testcase(new LinkedList(new int[]{3,3,1,1}), new LinkedList(new int[]{3,1})));
        testSet.add(new remove_dups_testcase(new LinkedList(new int[]{1,3,3,3,4,4,4}), new LinkedList(new int[]{1,3,4})));
        for(remove_dups_testcase tc: testSet) {
            tc.input.print();
            tc.output.print();

//            solve(tc.input);
            book_solution_no_buffer(tc.input);

            System.out.println("result:");
            tc.input.print();

            System.out.println(tc.input.compare(tc.output));
        }
    }

    static void main(){
        test();
    }
}

