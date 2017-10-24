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
                        break;
                    case "GP":
                        break;
                    case "GE":
                        break;
                    case "SP":
                        break;
                    case "SE":
                        break;
                    case "LC":
                        break;
                    default:
                        System.out.println("Comando Desconhecido");
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

    public static void deleteContact(Scanner in, ContactBook cBook) {
        String name = "";
        System.out.println("Name > ");
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            cBook.deleteContact(name);
            System.out.println("Contact removed.");
        } else {
            System.out.println("Contact does not exists.");
        }
    }
}
