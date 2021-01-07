package cs10.bongf;
public class Adder {
	public boolean[] halfadder(boolean bitA, boolean bitB) {
	        boolean sum = bitA ^ bitB;
	        boolean carry = bitA && bitB;
		 	boolean[] answer = {carry, sum};
	        return answer;
	}
	 
	public boolean[] fulladder(boolean bitA, boolean bitB, boolean carry) {
			boolean[] halfadder1 = halfadder(bitA, bitB);
			boolean[] halfadder2 = halfadder(carry, halfadder1[1]);
	        boolean sum = halfadder2[1];
	        boolean carry2 = halfadder1[0] || halfadder2[0];
		 	boolean[] answer = {carry2, sum};
	        return answer;
	}
	
	public boolean[] byteadder(boolean[] byteA, boolean[] byteB) {
			boolean[] answer = new boolean[byteA.length + 1];
			boolean carry = false;
		
			for(int i=0; i < answer.length; i++) {
				if(i == 8) {
					answer[i] = carry;
				}else {
					boolean[] fulladder = fulladder(byteA[i], byteB[i], carry);
					answer[i] = fulladder[1];
					carry = fulladder[0];
				}
			}
			return answer;
	}	
}



	   

    
