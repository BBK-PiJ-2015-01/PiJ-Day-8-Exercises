public class Exercise1 {

    private final Supermarket supermarket = new Supermarket();

    public static void main(String[] args) {

        new Exercise1().exercise1Runner();
    }

    private void exercise1Runner() {

        // Add three persons
        supermarket.addPerson(new BasePerson());
        supermarket.addPerson(new BasePerson());
        supermarket.addPerson(new BasePerson());
        // Serve the customers
        supermarket.servePerson();
        supermarket.servePerson();
        supermarket.servePerson();
        // try serving an empty queue
        supermarket.servePerson();
    }
}
