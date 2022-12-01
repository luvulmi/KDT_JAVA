class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        
        if (num1 == num2) {
            answer = 1;
        } else {
            answer = -1;
        }
        System.out.println(answer);
        return answer;
        
    }
}

public class Ex1_1 {
	public static void main(String[] args) {
		Solution s = new Solution();
        s.solution(3,3);
        
	}

}
