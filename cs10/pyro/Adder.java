import java.util.Arrays; 

public class Adder {
	// [미션]이진덧셈기 - 미션1 
	public static boolean[] halfadder(boolean bitA, boolean bitB) {
	        boolean sum = bitA ^ bitB;
	        boolean carry = bitA && bitB;
		 	boolean[] answer = {carry, sum};
	        return answer;
	    }
	 
	public static boolean[] fulladder(boolean bitA, boolean bitB, boolean carry) {
	        boolean sum = (bitA ^ bitB) ^ carry; 
	        boolean carry2 = (bitA && bitB) || ((bitA ^ bitB) && carry); 
		 	boolean[] answer = {carry2, sum};
	        return answer;
        }

	// [미션]이진덧셈기 - 미션2 : 여기는 위에 halfadder랑 fulladder로 수정해야 할 것 같습니다 
    public static boolean[] byteadder(boolean[] byteA, boolean[] byteB) {
            boolean[] answer = new boolean[9];
            boolean carry = false;
            for(int i=0; i < answer.length; i++) {
                if(i == 8) {
                    answer[i] = carry;
                }else {
                    answer[i] = (byteA[i] ^ byteB[i]) ^ carry;
                    carry = (byteA[i] && byteB[i]) || ((byteA[i] ^ byteB[i]) && carry);
                }
            }
            return answer;
            
            
    
        }    


	public static void main(String[] args) {
		// 미션 1 Test
//		boolean bitA = true;
//		boolean bitB = false;
//		boolean[] answer = halfadder(bitA, bitB);
		// 미션 2 Test
		boolean[] byteA = new boolean[]{true, true, false, false, true, false, true, false};
	    boolean[] byteB = new boolean[]{true, true, false, true, true, false, false, true};
	    boolean[] answer = byteadder(byteA, byteB);
	    int[] answer2 = new int[answer.length];
	    for(int i=0; i<answer.length; i++) {
	    	if(answer[i] == true) {
	    		answer2[i] = 1;
	    	}else {
	    		answer2[i] = 0;
	    	}
	    }
		System.out.println(Arrays.toString(answer2));
	}
    
    
}



	   
