/**
 * Created by lukkiddd on 2/4/2017 AD.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import java.util.ArrayList;
public class Main {

    static ArrayList<Item> inventory = new ArrayList<Item>();

    public static void main(String args[]) {

        inventory = read();

        while(true) {
            System.out.println("===============");
            System.out.println("== Inventory");
            System.out.println("===============");
            for (int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                System.out.printf("== %s | %25s \t | %d\t |\n", item.item_id, item.item_name, item.quantity);
            }
            System.out.println("===============");
            System.out.println("== Search item ( type [exit] to end program)");
            Scanner Sc = new Scanner(System.in);
            System.out.print("Search by Item ID: ");
            String query = Sc.nextLine();
            if(query.equals("exit")) {
                System.exit(0);
            }
            Item result = search(query);
            while (result == null) {
                System.out.println("===============");
                System.out.println("== Inventory");
                System.out.println("===============");
                for (int i = 0; i < inventory.size(); i++) {
                    Item item = inventory.get(i);
                    System.out.printf("== %s | %25s \t | %d\t |\n", item.item_id, item.item_name, item.quantity);
                }
                System.out.println("===============");
                System.out.println("== Search item ( type [exit] to end program)");
                Sc = new Scanner(System.in);
                System.out.print("Search by Item ID: ");
                query = Sc.nextLine();
                if(query.equals("exit")) {
                    System.exit(0);

                }
                result = search(query);
            }

            System.out.println("===============");
            System.out.println("== [add/delete]");
            Sc = new Scanner(System.in);
            System.out.print("command: ");
            String command = Sc.nextLine().toLowerCase();
            while (!command.equals("add") && !command.equals("delete")) {
                System.out.println("Please enter command again!");
                System.out.println("===============");
                System.out.println("== [add/delete]");
                Sc = new Scanner(System.in);
                System.out.print("command: ");
                command = Sc.nextLine().toLowerCase();
            }

            if (command.equals("add")) {
                result.quantity += 1;
            } else if (command.equals("delete")) {
                result.quantity -= 1;
            }
            System.out.println("== Updated item");
            System.out.printf("== %s | %25s \t | %d\t |\n", result.item_id, result.item_name, result.quantity);

            save();
        }

    }

    public static Item search(String query) {
        boolean found = false;
        Item found_item = new Item();
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).item_id.equals(query)) {
                found = true;
                found_item = inventory.get(i);
            }
        }

        if(found) {
            return found_item;
        } else {
            System.out.printf("\nItem not found!\n\n");
            return null;
        }
    }

    public static ArrayList read() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.txt"));
            ArrayList<Item> items = new ArrayList<Item>();

            String line = br.readLine();
            while(line != null) {
                String item_data[] = line.split(",");
                Item item = new Item(item_data[0], item_data[1], item_data[2]);
                items.add(item);
                line = br.readLine();
            }

            return items;
        } catch (IOException e) {
            System.out.println("error: " + e);
            return null;
        }
    }

    public static void save() {
        try {
            PrintWriter pw = new PrintWriter("inventory.txt", "UTF-8");
            Scanner Sc = new Scanner(System.in);

            for(int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                pw.printf("%s, %s, %d\n", item.item_id, item.item_name,item.quantity );
            }
            pw.close();

        } catch (IOException e) {
            System.out.println("error: " + e);
        }
    }
}
