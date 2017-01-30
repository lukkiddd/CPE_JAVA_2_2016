/**
 * Created by lukkiddd on 1/30/2017 AD.
 */
public class GuessGame {
    Player p1 = new Player();
    Player p2 = new Player();
    Player p3 = new Player();

    private int answer[] = new int[3];
    private int randomNum;
    private boolean winner[] = new boolean[3];
    private boolean end;

    public void startGame() {
        randomNum = (int) (Math.random() * 10);
        System.out.println("I'm thinking of a number between 0 and 9...");
        System.out.println("Number to guess is " + randomNum);

        while(!end) {
            answer[0] = p1.guess();
            answer[1] = p2.guess();
            answer[2] = p3.guess();

            for (int i = 0; i < 3; i++) {
                System.out.println("Player " + (i + 1) + " guessed " + answer[i]);
                if (answer[i] == randomNum) {
                    winner[i] = true;
                    end = true;
                }
            }
            if(end) {
                System.out.println("We have a winner!");
                for(int i = 0; i < 3; i++) {
                    System.out.println("Player " + (i + 1) + " got it right? " + winner[i]);
                }
            } else {
                System.out.println("Players will have to try again.");
            }
        }
        System.out.println("Game is over.");
    }
}
