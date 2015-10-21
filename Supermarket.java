public class Supermarket {

    private final PersonQueue queue = new SupermarketQueue();
    
    public void addPerson(Person person) {

        queue.insert(person);
    }

    public void servePerson() {

        Person toServe = queue.retrieve();
        if (toServe == null) {
            System.out.println("No one to serve, going to stack shelves");
        }
        System.out.println("Serving a customer, " + queue.size() + " remaining");
    }
}
