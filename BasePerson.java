public class BasePerson implements Person {

	private final int age;
	
	public BasePerson() {
		age = 0;
	}
	
	public BasePerson(int age) {
		this.age = age;
	}
    @Override
    public void move(int distance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void say(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
	@Override
	public int getAge() {
		return age;
	}
}
