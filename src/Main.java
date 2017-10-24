import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String option;
        Scanner in = new Scanner(System.in);
        do {
            option = readCommand(in);
            if (!option.equals("Q")) {
                switch (option) {
                    case "AC":
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
        option = in.nextLine().toUpperCase();
        return option;
    }
}
