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
    public void addContact(Contact newContact) {
        if (this.atCapacity()) this.grow();
        contacts[counter++] = newContact;
    }

    // pre: hasContact(name)
    public void deleteContact(String name) {
        // TODO ?????? poque a ordem não interessa?
        contacts[searchIndex(name)] = contacts[counter--];
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
        int result = -1;
        for (int i = 0; (i < counter && result == -1); i++)
            if (contacts[i].getName().equals(name))
                result = i;
        return result;
    }

    private boolean atCapacity() {
        return (contacts.length == counter);
    }

    private void grow() {
        Contact[] tmp = new Contact[GROWTH * contacts.length];
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

    public void bubbleSort() {
        for (int i = 1; i < counter; i++) {
            for (int j = counter-1; j >= i; j--) {
                if ((contacts[j - 1].compareTo(contacts[j])) > 0) {
                    Contact tmp = contacts[j - 1];
                    contacts[j - 1] = contacts[j];
                    contacts[j] = tmp;
                }
            }
        }
    }
}
