/**
 * Created by lukkiddd on 1/30/2017 AD.
 */
public class PolymorphicArray {

    public static void main(String[] args) {

        Animal[] a = new Animal[3];

        a[0] = new Dog("lessy", 100);
        a[1] = new Cat("fido", 100);
        a[2] = new Human("Konthai", 100);


        for( int i = 0; i < a.length; i++) {
            a[i].talk();
        }
    }
}
