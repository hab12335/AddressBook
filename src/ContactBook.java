public class ContactBook {
    public static final int MAX_CONTACTS = 50;
    public static final int GROWTH = 2;

    private int currentContact;
    private int counter;
    private Contact[] contacts;


    public ContactBook() {
        currentContact = -1;
        counter = 0;
        contacts = new Contact[MAX_CONTACTS];
    }

    public boolean hasContact(String name) {
        return (searchIndex(name) >= 0);
    }

    public int getNumberOfContacts() {
        return counter;
    }

    // pre: !hasContact(name)
    public void addContact(String name, int phone, String email) {
        if (atCapacity()) grow();
        contacts[counter++] = new Contact(name, phone, email);
    }

    // pre: hasContact(name)
    public void deleteContact(String name) {
        contacts[searchIndex(name)] = contacts[counter - 1];
        counter--;
    }

    // pre: hasContact(name)
    public int getPhone(String name) {
        return contacts[searchIndex(name)].getPhone();
    }

    // pre: hasContact(name)
    public String getEmail(String name) {
        return contacts[searchIndex(name)].getEmail();
    }

    // pre: hasContact(name)
    public void setPhone(String name, int phone) {
        contacts[searchIndex(name)].setPhone(phone);
    }

    // pre: hasContact(name)
    public void setEmail(String name, String email) {
        contacts[searchIndex(name)].setEmail(email);

    }

    private int searchIndex(String name) {
        int i = 0;
        int result = -1;
        while ((i < counter) && result == -1) {
            if (contacts[i].getName().equals(name))
                result = i;
            i++;
        }
        return result;
    }

    private boolean atCapacity() {
        return (contacts.length == counter);
    }

    private void grow() {
        Contact tmp[] = new Contact[GROWTH * contacts.length];
        for (int i = 0; i < contacts.length; i++)
            tmp[i] = contacts[i];
        contacts = tmp;
    }

    public void initializeIterator() {
        currentContact = 0;
    }

    public boolean hasNext() {
        return ((currentContact < counter) && (currentContact >= 0));
    }

    // pre: hasNext()
    public Contact next() {
        return contacts[currentContact++];
    }


}
