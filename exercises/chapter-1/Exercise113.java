import java.io.*;
import java.util.*;

public class Exercise113 {

	public static void main(String[] args) {

		int one = Integer.parseInt(args[0]);
		int two = Integer.parseInt(args[1]);
		int three = Integer.parseInt(args[2]);

		if (one == two && two == three) 
		    {
			System.out.println("equal");

		    } else System.out.println("not equal");

	}
}