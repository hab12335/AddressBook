import java.util.Scanner;

public class Main {

    // MENU OPTIONS
    private static final String Q = "Q";
    private static final String AC = "AC";
    private static final String RC = "RC";
    private static final String GP = "GP";
    private static final String GE = "GE";
    private static final String SP = "SP";
    private static final String SE = "SE";
    private static final String LC = "LC";
    private static final String BS = "BS";

    //PROMPTS
    private static final String PROMPT = "> ";
    private static final String NAME_PROMPT = "Name " + PROMPT;
    private static final String PHONE_PROMPT = "Phone " + PROMPT;
    private static final String EMAIL_PROMPT = "Email " + PROMPT;

    //STRINGS
    private static final String INVALID_COMMAND = "Invalid Command.";
    private static final String CONTACT_ADDED = "Contact added.";
    private static final String CONTACT_ALREADY_EXISTS = "Contact already exists.";
    private static final String CONTACT_REMOVED = "Contact removed.";
    private static final String CANNOT_REMOVE_CONTACT = "Cannot remove contact.";
    private static final String CONTACT_DOES_NOT_EXISTS = "Contact does not exists.";
    private static final String CONTACT_UPDATED = "Contact updated.";
    private static final String CONTACT_BOOK_EMPTY = "Contact book empty.";
    private static final String CONTACT_BOOK_SORTED = "Contact book sorted.";

    public static void main(String[] args) {
        String option;
        Scanner in = new Scanner(System.in);
        ContactBook cBook = new ContactBook();
        do {
            option = readCommand(in);
            if (!option.equals(Q)) {
                switch (option) {
                    case AC:
                        addContact(in, cBook);
                        break;
                    case RC:
                        deleteContact(in, cBook);
                        break;
                    case GP:
                        getPhone(in, cBook);
                        break;
                    case GE:
                        getEmail(in, cBook);
                        break;
                    case SP:
                        setPhone(in, cBook);
                        break;
                    case SE:
                        setEmail(in, cBook);
                        break;
                    case LC:
                        listAllContacts(cBook);
                        break;
                    case BS:
                        sortContacts(cBook);
                        break;
                    default:
                        System.out.println(INVALID_COMMAND);
                }
            }
        } while (!option.equals(Q));
        in.close();
    }

    private static String readCommand(Scanner in) {
        String option;
        System.out.println("=======================================================");
        System.out.println("> AC (adiciona um contacto)");
        System.out.println("> RC (remove um contacto)");
        System.out.println("> GP (consulta o telefone de um contacto)");
        System.out.println("> GE (consulta o e-mail de um contacto)");
        System.out.println("> SP (actualiza o telefone de um dado contacto)");
        System.out.println("> SE (actualiza o e-mail de um dado contacto)");
        System.out.println("> LC (lista todos os contactos existentes na agenda)");
        System.out.println("> BS (ordena os contactos por ordem alfabetica)");
        System.out.println("> Q (sair)");
        System.out.println("=======================================================");
        System.out.print(PROMPT);
        option = in.nextLine().toUpperCase();
        return option;
    }

    private static void addContact(Scanner in, ContactBook cBook) {
        String name = "";
        String email = "";
        int phone = 0;
        do {
            System.out.print(NAME_PROMPT);
            name = in.nextLine();
        } while (name.equals(""));
        if (!cBook.hasContact(name)) {
            System.out.print(PHONE_PROMPT);
            phone = in.nextInt();
            in.nextLine();
            do {
                System.out.print(EMAIL_PROMPT);
                email = in.nextLine();
            } while (email.equals(""));
            cBook.addContact(new Contact(name, phone, email));
            System.out.println(CONTACT_ADDED);
        }
        else System.out.println(CONTACT_ALREADY_EXISTS);
    }

    private static void deleteContact(Scanner in, ContactBook cBook) {
        String name = "";
        do {
            System.out.print(NAME_PROMPT);
            name = in.nextLine();
        } while (name.equals(""));
        if (cBook.hasContact(name)) {
            cBook.deleteContact(name);
            System.out.println(CONTACT_REMOVED);
        } else {
            System.out.println(CANNOT_REMOVE_CONTACT);
        }
    }

    private static void getPhone(Scanner in, ContactBook cBook) {
        String name = "";
        do {
            System.out.print(NAME_PROMPT);
            name = in.nextLine();
        } while (name.equals(""));
        if (cBook.hasContact(name)) {
            System.out.println(cBook.getPhone(name));
        } else {
            System.out.println(CONTACT_DOES_NOT_EXISTS);
        }
    }
    private static void getEmail(Scanner in, ContactBook cBook) {
        String name = "";
        do {
            System.out.print(NAME_PROMPT);
            name = in.nextLine();
        } while (name.equals(""));
        if (cBook.hasContact(name)) {
            System.out.println(cBook.getEmail(name));
        } else {
            System.out.println(CONTACT_DOES_NOT_EXISTS);
        }
    }

    private static void setPhone(Scanner in, ContactBook cBook) {
        String name = "";
        int phone = 0;
        do {
            System.out.print(NAME_PROMPT);
            name = in.nextLine();
        } while (name.equals(""));
        if (cBook.hasContact(name)) {
            System.out.print(PHONE_PROMPT);
            phone = in.nextInt();
            in.nextLine();
            cBook.setPhone(name, phone);
            System.out.println(CONTACT_UPDATED);
        } else {
            System.out.println(CONTACT_DOES_NOT_EXISTS);
        }

    }
    private static void setEmail(Scanner in, ContactBook cBook) {
        String name = "";
        String email = "";
        do {
            System.out.print(NAME_PROMPT);
            name = in.nextLine();
        } while (name.equals(""));
        if (cBook.hasContact(name)) {
            System.out.print(EMAIL_PROMPT);
            email = in.nextLine();
            cBook.setEmail(name, email);
            System.out.println(CONTACT_UPDATED);
        } else {
            System.out.println(CONTACT_DOES_NOT_EXISTS);
        }

    }
    private static void listAllContacts(ContactBook cBook) {
        if (cBook.getNumberOfContacts() > 0) {
            Contact tmp;
            cBook.initializeIterator();
            while (cBook.hasNext()) {
                tmp = cBook.next();
                System.out.println(tmp.getName() + "; "
                        + tmp.getEmail() + "; " + tmp.getPhone());
            }
        } else
            System.out.println(CONTACT_BOOK_EMPTY);

    }

    private static void sortContacts(ContactBook cBook) {
        cBook.bubbleSort();
        System.out.println(CONTACT_BOOK_SORTED);

    }

}
