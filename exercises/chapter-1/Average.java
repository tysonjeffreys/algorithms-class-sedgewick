import java.io.*;
import java.util.*;

public class Average
{
    public static void main(String[] args)
    {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	String sum = "test";
	int cnt = 0;
	int totalSum = 0;
	try {
	    while((sum = reader.readLine()) != null)
	
	{
		    StringTokenizer st = new StringTokenizer(sum);
		    if(!st.hasMoreTokens()) break;
		    totalSum = Integer.parseInt(sum) + totalSum;
		    cnt++;
		}
	} catch (IOException e) {
	    System.out.println(e);
		}
	System.out.println(totalSum / cnt);
       
	/*
	while (!StdIn.isEmpty())
	    { //Read a number and cumulate the sum.
		sum += StdIn.readDouble();
		cnt++;
	    }
	double avg = sum / cnt;
	System.out.println("Average is %.5f\n" + avg);
	*/
}
}