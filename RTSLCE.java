import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * RTS Labs Code Exercise
 * @author Justin Scyphers
 * @date 09/15/2020
 */
public class RTSLCE extends Application
{
	/**
	 * Start is where the scene (GUI window) is built and populated with the text fields
	 * and buttons for the user to use.
	 * 
	 * AboveBelow Calculator: Prints the number of integers in an array that are above the given input 
	 * and the number that are below, e.g. for the array [1, 5, 2, 1, 10] with input 6, print “above: 1, below: 4”.
	 * 
	 * String Rotator: Rotates the characters in a string by a given input and have the overflow 
	 * appear at the beginning, e.g. “MyString” rotated by 2 is “ngMyStri”.
	 */
	public void start(Stage primaryStage) throws java.lang.InterruptedException
	{
		primaryStage.setTitle("RTS Labs CE");
		
        GridPane gridPane = new GridPane();
        
        //-------------------------------------AboveBelow Calculator------------------------------------------
        Label aboveBelow = new Label();
        TextField enterArray = new TextField("Enter Int Array");
        TextField enterMid = new TextField("Enter Middle Number");
        Button submitMid = new Button("Submit");
        Label midResult = new Label();
          
        submitMid.setOnAction(action -> {
        	try
        	{
        		int[] nums = stringToIntArray(enterArray.getText());
        		int mid = Integer.parseInt(enterMid.getText());
        		midResult.setText("above: " + countAbove(nums, mid) + ", below: " + countBelow(nums, mid));
        }
		catch (Exception NumberFormatException)
        	{
			midResult.setText("Please enter a valid int array and a middle number");
        	}
        });
        //----------------------------------------------------------------------------------------------------
        
        //----------------------------------------String Rotator----------------------------------------------
        Label strRotate = new Label();
        TextField enterStr = new TextField("Enter String");
        TextField enterPos = new TextField("Enter Number of Characters to Flip");
        Button submitRotate = new Button("Submit");
        Label rotateResult = new Label();
        
        submitRotate.setOnAction(action -> {
        	try 
        	{
        		int rotate = Integer.parseInt(enterPos.getText());
        		if (rotate >= enterStr.getText().length())
        			rotateResult.setText("Please enter a number smaller than the length of the string");
        		else
        		{
        			rotateResult.setText(enterStr.getText().substring(enterStr.getText().length()-rotate) +
        					enterStr.getText().subSequence(0, enterStr.getText().length()-rotate));
        		}
        	}
        	catch (Exception NumberFormatException)
        	{
			rotateResult.setText("Please enter a valid number");
        	}
        });
        //----------------------------------------------------------------------------------------------------
        
        Scene scene = new Scene(gridPane, 400, 400);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        //AboveBelow calculator
        gridPane.add(aboveBelow, 0, 0, 100, 10);
        gridPane.add(enterArray, 0, 0, 100, 15);
        gridPane.add(enterMid, 0, 0, 100, 20);
        gridPane.add(submitMid, 0, 0, 100, 25);
        gridPane.add(midResult, 0, 0, 100, 30);
        
        //String rotator
        gridPane.add(strRotate, 0, 0, 100, 40);
        gridPane.add(enterStr, 0, 0, 100, 45);
        gridPane.add(enterPos, 0, 0, 100, 50);
        gridPane.add(submitRotate, 0, 0, 100, 55);
        gridPane.add(rotateResult, 0, 0, 100, 60);
        
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	/**
	 * countAbove counts how many ints in the int array nums are greater than the separate int named mid
	 * and returns that number to start.
	 * @param nums - integer array to be checked
	 * @param mid - integer used to count how many ints in nums are greater than mid
	 * @return - integer of how many, if any, are greater than mid
	 */
	public int countAbove(int[] nums, int mid)
	{
		int count = 0;
		for (int i=0;i<nums.length;i++)
		{
			if (nums[i] > mid)
				count++;
		}
		return count;
	}
	
	/**
	 * countAbove counts how many ints in the int array nums are less than the separate int named mid 
	 * and returns that number back to start.
	 * @param nums - integer array to be checked
	 * @param mid - integer used to count how many ints in nums are less than mid
	 * @return - integer of how many, if any, are less than mid
	 */
	public int countBelow(int[] nums, int mid)
	{
		int count = 0;
		for (int i=0;i<nums.length;i++)
		{
			if (nums[i] < mid)
				count++;
		}
		return count;
	}
	
	/**
	 * stringToIntArray converts a string into an int array and returns it to start.
	 * @param input - string of integers taken from user input
	 * @return - an integer array of the ints from the input string
	 */
	public int[] stringToIntArray(String input)
	{
		List<Integer> numList = new ArrayList<Integer>();
		Scanner scan = new Scanner(input);
		while (scan.hasNextInt())
		{
			numList.add(scan.nextInt());
		}
		scan.close();
		
		int[] nums = new int[numList.size()]; 
        for (int i=0;i<nums.length;i++)
        {
        		nums[i] = numList.get(i);
        }
        
        return nums;
	}	

	public static void main(String[] args)
	{
		Application.launch(args);  
	}
}
