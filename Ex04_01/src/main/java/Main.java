/**
 * Created by lukkiddd on 2/4/2017 AD.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        int low = 32;
        int high = 212;
        int x = 0;
        int c = 0;
        int total_c = 0;
        int count = 0;
        Random rand = new Random();

        try {
            PrintWriter pw = new PrintWriter("f.txt", "UTF-8");

            Scanner Sc = new Scanner(System.in);
            System.out.print("What X?:");
            String s = Sc.nextLine();
            x = Integer.parseInt(s);

            for(int i = 0; i < x; i++) {
                int result = rand.nextInt(high-low) + low;
                pw.println(result);
            }
            pw.close();

        } catch (IOException e) {
            System.out.println("error: " + e);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("f.txt"));
            PrintWriter pw = new PrintWriter("c.txt", "UTF-8");
            String line = br.readLine();
            count = 0;
            while(line != null) {
                c = Integer.parseInt(line);
                total_c += c;
                count += 1;
                pw.println(c);
                line = br.readLine();
            }
            System.out.println("Average of f: " + total_c/count);
            pw.close();
        } catch (IOException e) {
            System.out.println("error: " + e);
        }

    }
}
