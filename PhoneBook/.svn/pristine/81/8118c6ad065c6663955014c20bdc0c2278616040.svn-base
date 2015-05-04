package phonebook;

public class PhoneBook {

	private String label;
	
	private final static int MAX = 100;
	private Contact[] contacts;
	private int next=0;

  /**
   * Create a new phonebook with given name
   */
  public PhoneBook(String name) {  
	  label = name;
	  contacts = new Contact[MAX];
  }

  /**
   * Return the phonebook label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Insert a new contact at the end
   */  
  public void add(String first, String last, String number){
	  Contact c = new Contact(first,last,number);
	  
	  contacts[next++] = c;
  }

  /**
   * Return the first contact
   */  
  public String first() {
//	  Contact f = contacts[0];
//	  return f.getFirst() + " " + f.getLast() + " " + f.getPhone();
	  return contacts[0].asString();
  }

  /**
   * Return the i-th contact (supposing that first 
   * index is 1)
   */
  public String get(int i) {
	  return contacts[i-1].asString();
  }

  /**
   * Return a string containing the list of textual 
   * representation of all contacts.
   * The elements are separated by  ", " and the
   * list starts with "("and ends with ")" 
   */
  public String toString() {
	  //TODO: to be implemented 
	  return null;
  }

  /**
   * Return the textual representation of first
   * contact containing "needle"
   */
  public String find(String needle) {
	  //TODO: to be implemented 
	  return null;
  }
  
}
