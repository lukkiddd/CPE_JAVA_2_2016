/**
 * Created by lukkiddd on 2/4/2017 AD.
 */
public class Item {
    public String item_id;
    public String item_name;
    public int quantity;

    Item() {

    }

    Item(String item_id, String item_name, String quantity) {
        this.item_id = item_id;
        this.item_name = item_name;
        try {
            this.quantity = Integer.parseInt(quantity.replace(" ",""));
        } catch(NumberFormatException e) {
            System.out.println("This is not a number");
            System.out.println(e.getMessage());
        }
    }


}
