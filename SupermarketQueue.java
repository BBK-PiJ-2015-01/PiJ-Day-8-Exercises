public class SupermarketQueue implements PersonQueue {

    private QueuePerson headOfQueue;

    @Override
    public void insert(Person personToInsert) {

        if (personToInsert == null) {
            System.out.println("Missing person");
            return;
        }

        if (headOfQueue == null) {
            headOfQueue = new QueuePerson(personToInsert);
            return;
        }
        headOfQueue.addPerson(new QueuePerson(personToInsert));
    }

    @Override
    public Person retrieve() {

        if (headOfQueue == null) {
            System.out.println("Nobody's waiting");
            return null;
        }
        Person toReturn = headOfQueue.getPerson();
        if (headOfQueue.size() == 1) {
            headOfQueue = null;
        } else {
            headOfQueue = headOfQueue.getNextPerson();
        }
        return toReturn;
    }

    @Override
    public int size() {
        return headOfQueue == null ? 0 : headOfQueue.size();
    }

    class QueuePerson {

        private final Person person;
        //
        private QueuePerson nextPerson;
        private QueuePerson prevPerson;

        public QueuePerson(Person person) {

            this.person = person;
            nextPerson = null;
            prevPerson = null;
        }

        public QueuePerson getNextPerson() {
            return nextPerson;
        }

        public void setNextPerson(QueuePerson nextPerson) {
            this.nextPerson = nextPerson;
        }

        public QueuePerson getPrevPerson() {
            return prevPerson;
        }

        public void setPrevPerson(QueuePerson prevPerson) {
            this.prevPerson = prevPerson;
        }

        public void addPerson(QueuePerson personToAdd) {
            // Add Queue Person to end
            if (personToAdd == null) {
                return;
            }
            if (nextPerson == null) {
                nextPerson = personToAdd;
                personToAdd.setPrevPerson(this);
            } else {
                nextPerson.addPerson(personToAdd);
            }
        }

        public Person getPerson() {
            return person;
        }

        public int size() {
            return nextPerson == null ? 1 : nextPerson.size() + 1;
        }
    }

}
