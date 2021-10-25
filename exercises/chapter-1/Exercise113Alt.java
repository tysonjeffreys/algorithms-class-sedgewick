// Write a program that takes three integer command-line arguments and prints equal                                  
// if all three are equal, and not equal otherwise.

// Alternative version of Exercise 1.1.3 that lets user enter numbers after the program starts.

import java.io.*;
import java.util.*;

public class Exercise113Alt {

    public static void main(String[] args) 
    {
        String number = null;
        int N = 0;
        int[] numbers;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

	    N = Integer.parseInt(reader.readLine());
	    numbers = new int[N];
	    int i = 0;
	    while ((number = reader.readLine()) != null) {
		StringTokenizer st = new StringTokenizer(number);
		if(!st.hasMoreTokens()) break;
		numbers[i] = Integer.parseInt(number);
		i++;
	    }

	    for (int n: numbers) 
		{
		System.out.println(n);
		}

        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
