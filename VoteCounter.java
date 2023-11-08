import java.util.Scanner;

public class VoteCounter {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int[] contestantsCount = new int[6];
        // created a array of size six because to increment the votes gained by the contestants 1 - 5 ignoring 0th position.

        int totalVotes = 0;
        int spoiltVotes = 0;

        
        while(true){
            System.out.print("Enter (1 - 5) for voting contestants 1 to 5 else vote 0 to stop: ");
            int vote = scan.nextInt();

            if(vote == 0){
                break;
            }

            if(vote >= 1 && vote <= 5){
                contestantsCount[vote]++;
                totalVotes++;
            }else spoiltVotes++;
        }   
        System.out.println();
        System.out.println("Votes count");

        for(int i = 1; i <= 5; i++){
            System.out.println("Candidate " + i + "Votes : " + contestantsCount[i]);
        }
        
        System.out.println("Spoilt votes : " + spoiltVotes);
        System.out.println("Total votes : " + totalVotes);

        scan.close();
    }   
}
