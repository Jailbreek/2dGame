//2501969731 - Andre Wijaya Siregar

import java.util.*;

public class TicTac {
	
	static String[] board;
	static String turn;
	
	static String checkWinner()
	{
		for(int i = 0; i < 8; i++)
		{
			String line = null;
			switch(i)
			{
				case 0 -> line = board[0] + board[1] + board[2];
				case 1 -> line = board[3] + board[4] + board[5];
				case 2 -> line = board[6] + board[7] + board[8];
				case 3 -> line = board[0] + board[3] + board[6];
				case 4 -> line = board[1] + board[4] + board[7];
				case 5 -> line = board[2] + board[5] + board[8];
				case 6 -> line = board[0] + board[4] + board[8];
				case 7 -> line = board[2] + board[4] + board[6];
			}
			if("XXX".equals(line))
			{
				return "X";
			}
			else if("OOO".equals(line))
			{
				return "O";
			}
		}
		
		for(int i = 0; i < 9; i++)
		{
			if(Arrays.asList(board).contains(String.valueOf(i + 1)))
			{
				break;
			}
			else if(i == 8)
			{
				return "draw";
			}
		}
		
		System.out.println("player " + turn + "'s turn\nEnter slot to place");
		return null;
	}
	
	//print board
	
	static void printBoard()
	{
		System.out.println("|-----------|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|-----------|");
	}
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			board = new String[9];
			turn = "X";
			String winner = null;
			for(int i = 0; i < 9; i++)
			{
				board[i] = String.valueOf(i + 1);
			}
			System.out.println("Classic TiTacToe Game");
			printBoard();
			System.out.println("Player X will play first\nEnter slot number to place");
		
			while(winner == null)
			{ 
				int numInput;
				try
				{
					numInput = sc.nextInt();
					if(!(numInput > 0 && numInput <= 9))
					{
						System.out.println("invalid input\nre-enter slot to place");
						continue;
					}
				}
				catch(InputMismatchException e)
				{
					System.out.println("invalid input\nre-enter slot to place");
				}
				
				if(board[numInput - 1].equals(String.valueOf(numInput)))
				{
					board[numInput - 1] = turn;
					if(turn.equals("X"))
					{
						turn = "O";
					}
					else 
					{
						turn = "X";
					}
					printBoard();
					winner = checkWinner();
				}
				else
				{
					System.out.println("Slot has been filled\nre-enter slot to place");
				}
			}
			
			if(winner.equalsIgnoreCase("draw"))
			{
				System.out.println("Game is draw\nThanks for Playing !!!");
			}
			else
			{
				System.out.println("Congrats Player " + winner + " is the Winner");
				System.out.println("Thanks for Playing");
			}
		}
	}
}