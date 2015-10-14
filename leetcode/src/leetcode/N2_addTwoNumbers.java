package leetcode;
import leetcode.N0_data_strcture.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class N2_addTwoNumbers {
	public ListNode buildNewNode(int n){
		ListNode newNode = new ListNode(n);
		newNode.next=null;	
		return newNode;
	}
	
	//recursive
	public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {  
		if (l1 == null && l2==null && carry==0) {
			ListNode newNode = null;
			return newNode;
		}
		
		ListNode ret =  buildNewNode(carry);
		
		int sum=carry;
		if(l1 !=null) sum += l1.val;
		if(l2 !=null) sum += l2.val;
		
		ret.val = sum%10;
		carry = sum/10;
		if(l1 != null || l2!=null || carry!=0){
			ListNode more = addTwoNumbers(l1 ==null? null: l1.next, 
					l2 ==null? null: l2.next,
							carry);
			ret.next = more;
		}
		return ret;
	}
	

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {  
		return addTwoNumbers(l1,l2,0);
	}
	
	
	
	public BigInteger getIntFromListNode(ListNode n){
		BigInteger ret= new BigInteger("0");
		int power=0;
		while(n != null){
			double num = n.val * Math.pow(10, power);
			ret.add(new BigInteger(String.valueOf((int)num) )) ;
			power++;
			n=n.next;
		}
		return ret;
	}
	

	
	public ListNode buildListNodeFromInt(BigInteger n){
		ListNode ret = null; 
		if(n.equals(0)) {
			ret = buildNewNode(0);
		}
		else{
			ArrayList<BigInteger> al = new ArrayList<BigInteger>();
			while(!n.equals(0) ){
				al.add(n.mod(new BigInteger("10")));
				n = n.divide(new BigInteger("10"));
			}
			
			ret = buildNewNode(al.get(0).intValue());
			ListNode cur = ret;
			//build ListNode from end of arraylist 
			for(int i=1; i<al.size(); i++){
				cur.next = buildNewNode(al.get(i).intValue());
				cur = cur.next;			
			}
		}	
		return ret;
	}
	
	
	// transform to normal addition and build nodes
	public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {  
		BigInteger sum = getIntFromListNode(l1).add(getIntFromListNode(l2));
		ListNode ret = buildListNodeFromInt(sum);
		return ret;
	}
	
	
	
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    	ListNode ret = null; 
    	ListNode current = null; 
    	int carry=0;
    	if(l1 != null && l2 != null){
    		int sum=l1.val + l2.val;
    		carry = sum/10;
    		sum = sum - carry*10;
    		ListNode newNode = new ListNode(sum);
    		newNode.next = null;
    		ret = newNode; 
    		current = newNode; 
    		l1= l1.next; l2=l2.next;
    	}
    	
    	while(l1 != null && l2 != null){
    		int sum=l1.val + l2.val + carry;
    		carry = sum/10;
    		sum = sum - carry*10;
    		ListNode newNode = new ListNode(sum);
    		newNode.next = null;
    		current.next = newNode;  
    		current = current.next ; 
    		l1= l1.next; l2=l2.next;
    	}
    	

    	if(l1 != null) {
    		ListNode tmpNode=l1;
    		while(tmpNode !=null && carry != 0){
    			tmpNode.val +=carry;
    			carry = tmpNode.val/10;
    			tmpNode.val = tmpNode.val - carry*10;
    			tmpNode = tmpNode.next;
    		}
    		current.next = l1;
    	}
    	if(l2 != null) {
    		ListNode tmpNode=l1;
    		while(tmpNode !=null && carry != 0){
    			tmpNode.val +=carry;
    			carry = tmpNode.val/10;
    			tmpNode.val = tmpNode.val - carry*10;    			
    			tmpNode = tmpNode.next;
    		}
    		current.next = l2;
    	}
    	
    	if(carry!=0){
    		ListNode newNode = new ListNode(carry);
    		newNode.next = null;
    		current.next = newNode;
    	}
    	

    	return ret;
    }
}
