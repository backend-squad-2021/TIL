import java.util.Arrays; 


public class Convertor {

    public static void main(String[] args) {
        //미션1 test
        // boolean[] answer = dec2bin(173);
        // System.out.println(Arrays.toString(answer));
        //미션2 test
		boolean[] bin = {true, true, true, true, false, true, false, true}; 
		int answer = bin2dec(bin);
        System.out.println(answer);
        
	}
	
    //[미션]진법 변환기 - 미션1
    public static boolean[] dec2bin(int decimal) {
		    //배열 크기 구하기 		 
		 	int count = 0;
		 	int decimal2 = decimal;
		 	while(decimal2 !=1) {
		 		count += 1;
		 		decimal2 = decimal2 / 2;
		 	}
		 	//2진수바꿔 배열로 만들기 
		 	int[] answer_array = new int[count+1];
		 	int i = 0; 
		 	while(decimal != 1) {
		 		answer_array[i++] = decimal % 2;
		 		decimal = decimal / 2; 
		 	}
		 	answer_array[i] = decimal;
		 	//boolean으로 바꾸기 
		 	boolean[] answer = new boolean[answer_array.length];
		 	for(int j=0; j < answer_array.length; j++) {
		 		if(answer_array[j] == 1) {
		 			answer[j] = true;
		 		}else {
		 			answer[j] = false;
		 		}
		 	}
		 	return answer;
		 	
        }

    //[미션]진법 변환기 - 미션2
    public static int bin2dec(boolean[] bin) {
		
		int[] answer_binary = new int[bin.length];
		for(int j=0; j < bin.length; j++) {
			if(bin[j] == true) {
				answer_binary[j] = 1;
			}else {
				answer_binary[j] = 0;
			}
		
		}
		int answer = 0;
		int time = 1;  
		for(int i=0; i < answer_binary.length; i++) {
			if(i >= 1) {
				time *= 2;
				answer += answer_binary[i] * time;
			}else {
				answer += answer_binary[i];
			}
		}
        return answer;
    }
        
        
}
