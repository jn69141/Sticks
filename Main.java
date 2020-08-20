import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    
	    //getting the random number of sticks 21-30:
	    Scanner reader = new Scanner(System.in);
	    int sticks = (int)(Math.random()*10) + 21;
	    //math.random gives a decimal number less than one; multiple by ten to get an integer 0-9
	    //add (int) to turn it into an integer; add 21 so 0-9 + 21 gets range of 21-30
	    
		System.out.println("There are some sticks here... " + sticks + " sticks.");
		System.out.println("Let's play the stick game!! Do you want to go first <1> or second <2>?");
		
		//getting the order of drawing:
		boolean turn;
		//true <1> is player turn; false <2> is computer turn
		if (reader.nextInt() == 1)
		    turn = true;
		else
		//else here means anything other than <1> becomes false
		    turn = false;
		
		//setting up the game ending when no sticks left:
		while(sticks > 0){
		//the bracket there applies 'while' all the way to the next bracket
		    if(turn)
		        sticks = playerMove(sticks, reader);
		    else
		        sticks = computerMove(sticks);
		    System.out.println("There are " + sticks + " sticks left!");
		    if(sticks == 0 && turn)
		        System.out.println("You win!! Good game!");
		    if(sticks == 0 && !turn)
		        System.out.println("I win!! Good try though!!");
		    turn = !turn;
	    //&& means 'and' .. ! means 'false'
		}
	}
	    
	    //setting up user drawing sticks:
	public static int playerMove(int sticks, Scanner reader){
        System.out.println("How many sticks do you want to take <1-3>?");
        int take = reader.nextInt();
        if(take < 1)
            take = 1;
        if(take > 3)
            take = 3;
        else if(take > sticks)
            take = sticks;
        System.out.println("You took " + take + " stick(s) from the pile. \n");
        return sticks - take;
	    //sticks integer - (minus) take integer
	    }
	    
	    //setting up computer drawing sticks
    public static int computerMove(int sticks){
        int take;
        if(sticks % 4 != 0)
        //% means divisible by (whole number); so 'if sticks divisible not...' (not divisible)
        take = sticks % 4;
        else
        //if it *is* divisible
            take = (int)(Math.random()*3) + 1;
        System.out.println("I took " + take + " stick(s) from the pile. \n");
        return sticks - take;
    }
}

//method of winning: if the starting number is divisible by 4, choose to pick second
//if it is not divisible by 4, start first and pull so that the remaining would be divisible by 4
//repeat.. in the end there will be 1-3 sticks and just pick it all up