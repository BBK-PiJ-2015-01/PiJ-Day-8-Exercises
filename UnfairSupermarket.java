public class UnfairSupermarket {

//    private final PersonQueue queue = new SupermarketQueue();
//    private final PersonQueue queue = new PriorityArrayPersonQueue();
    private final PersonQueue queue = new AgeOrderSupermarketQueue();
    
    public void addPerson(Person person) {

        queue.insert(person);
    }

    public void servePerson() {

        Person toServe = queue.retrieve();
        if (toServe == null) {
            System.out.println("No one to serve, going to stack shelves");
			return;
        }
        System.out.println("Serving a customer with age " + toServe.getAge() );
    }
}
