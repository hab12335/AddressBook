import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String option;
        Scanner in = new Scanner(System.in);
        ContactBook cBook = new ContactBook();
        do {
            option = readCommand(in);
            if (!option.equals("Q")) {
                switch (option) {
                    case "AC":
                        addContact(in, cBook);
                        break;
                    case "RC":
                        deleteContact(in, cBook);
                        break;
                    case "GP":
                        getPhone(in, cBook);
                        break;
                    case "GE":
                        getEmail(in, cBook);
                        break;
                    case "SP":
                        setPhone(in, cBook);
                        break;
                    case "SE":
                        setEmail(in, cBook);
                        break;
                    case "LC":
                        listAllContacts(cBook);
                        break;
                    case "BS":
                        sortContacts(cBook);
                        break;
                    default:
                        System.out.println("Invalid Command");
                }
            }
        } while (!option.equals("Q"));
        in.close();
    }

    private static String readCommand(Scanner in) {
        String option;
        System.out.println("> AC (adiciona um contacto)");
        System.out.println("> RC (remove um contacto)");
        System.out.println("> GP (consulta o telefone de um contacto)");
        System.out.println("> GE (consulta o e-mail de um contacto)");
        System.out.println("> SP (actualiza o telefone de um dado contacto)");
        System.out.println("> SE (actualiza o e-mail de um dado contacto)");
        System.out.println("> LC (lista todos os contactos existentes na agenda)");
        System.out.println("> BS (ordena os contactos por ordem alfabetica)");
        System.out.println("> Q (sair)");
        System.out.print("> ");
        option = in.nextLine().toUpperCase();
        return option;
    }

    private static void addContact(Scanner in, ContactBook cBook) {
        String name = "";
        String email = "";
        int phone = 0;
        System.out.print("Name > ");
        name = in.nextLine();
        System.out.print("Phone > ");
        phone = in.nextInt();
        in.nextLine();
        System.out.print("Email > ");
        email = in.nextLine();
        if (!cBook.hasContact(name)) {
            cBook.addContact(name, phone, email);
            System.out.println("Contact added");
        }
        else System.out.println("Contact already exists");
    }

    private static void deleteContact(Scanner in, ContactBook cBook) {
        String name = "";
        System.out.print("Name > ");
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            cBook.deleteContact(name);
            System.out.println("Contact removed.");
        } else {
            System.out.println("Cannot remove contact.");
        }
    }

    private static void getPhone(Scanner in, ContactBook cBook) {
        String name = "";
        System.out.print("Name > ");
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            System.out.println(cBook.getPhone(name));
        } else {
            System.out.println("Contact does not exists.");
        }
    }
    private static void getEmail(Scanner in, ContactBook cBook) {
        String name = "";
        System.out.print("Name > ");
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            System.out.println(cBook.getEmail(name));
        } else {
            System.out.println("Contact does not exists.");
        }
    }

    private static void setPhone(Scanner in, ContactBook cBook) {
        String name = "";
        int phone = 0;
        System.out.print("Name > ");
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            System.out.print("Phone > ");
            phone = in.nextInt();
            in.nextLine();
            cBook.setPhone(name, phone);
            System.out.println("Contact updated.");
        } else {
            System.out.println("Contact does not exists.");
        }

    }
    private static void setEmail(Scanner in, ContactBook cBook) {
        String name = "";
        String email = "";
        System.out.print("Name > ");
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            System.out.print("Email > ");
            email = in.nextLine();
            cBook.setEmail(name, email);
            System.out.println("Contact updated.");
        } else {
            System.out.println("Contact does not exists.");
        }

    }
    private static void listAllContacts(ContactBook cBook) {
        Contact tmp;
        if (cBook.getNumberOfContacts() > 0) {
            cBook.initializeIterator();
            while (cBook.hasNext()) {
                tmp = cBook.next();
                System.out.println(tmp.getName() + "; "
                        + tmp.getEmail() + "; " + tmp.getPhone());
            }
        } else
            System.out.println("Contact book empty.");

    }

    private static void sortContacts(ContactBook cBook) {
        cBook.bubbleSort();
        System.out.println("Contact book sorted.");

    }

}
