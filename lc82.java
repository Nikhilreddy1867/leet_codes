/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        TreeMap<Integer,Integer> hs = new TreeMap<>();
        ListNode temp =head;
        while(temp !=null){
            hs.put(temp.val,hs.getOrDefault(temp.val,0)+1);
            temp = temp.next;
        }
        ListNode new_node = null;
        ListNode n_temp =null;
        for(int val:hs.keySet()){
            int freq=hs.get(val);
            if(freq==1){
                ListNode node = new ListNode(val);
                if(new_node ==null){
                    new_node= node;
                    n_temp =node;
                }
                else{
                    n_temp.next =node;
                    n_temp= n_temp.next;
                }
            }
        }
        return new_node;
    }
}