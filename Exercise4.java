public class Exercise4 {

    private  UnfairSupermarket supermarket = new UnfairSupermarket();

    public static void main(String[] args) {

        new Exercise4().exercise4Runner();
    }

    private void exercise4Runner() {

		Person juvenilePerson = new BasePerson(16);
		Person youngPerson = new BasePerson(21);
		Person middleAgedPerson = new BasePerson(51);
		Person oldPerson = new BasePerson(65);
		Person veryOldPerson = new BasePerson(99);
		
		// Queue them in age order	
		supermarket.addPerson(juvenilePerson);
        supermarket.addPerson(youngPerson);
        supermarket.addPerson(middleAgedPerson);
        supermarket.addPerson(oldPerson);
        supermarket.addPerson(veryOldPerson);
		
		// Serve the customers
        supermarket.servePerson();
        supermarket.servePerson();
        supermarket.servePerson();
		supermarket.servePerson();
		supermarket.servePerson();

		System.out.println("\n Second test\n");
		supermarket = new UnfairSupermarket();
		// Rebuild the queue
		supermarket.addPerson(oldPerson);
		supermarket.addPerson(youngPerson);
		supermarket.addPerson(youngPerson);
		supermarket.addPerson(veryOldPerson);
		supermarket.addPerson(juvenilePerson);
		supermarket.addPerson(middleAgedPerson);
		supermarket.addPerson(middleAgedPerson);
		supermarket.addPerson(oldPerson);	
		
		for(int i = 0; i < 10; i++) {
			supermarket.servePerson();
		}
		
		
    }
}
