package HackerRank;

public class JumpingCloud {
	public static void main(String[] args) {
		int[] c = {0,1,0,0,0,1,0};
		System.out.println(jumpingOnClouds(c));
	}

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int minJump = 0;
		int i =0;
		while (i < c.length -1) {
			if(i + 2 == c.length || c[i + 2] == 1){
				i++;
				minJump++;
			} else {
				i +=  2;
				minJump++;
			}
		}
		return minJump;
	}
}
