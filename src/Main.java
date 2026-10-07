import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Pessoa> banco = new ArrayList<>();

        ArrayList<Pessoa> cache = new ArrayList<>();

        banco.add(new Pessoa(1, "João", 25));
        banco.add(new Pessoa(2, "Maria", 30));
        banco.add(new Pessoa(3, "Carlos", 22));
        banco.add(new Pessoa(4, "Ana", 28));
        banco.add(new Pessoa(5, "Pedro", 35));

        System.out.print("Digite o ID da pessoa: ");
        int id = scanner.nextInt();

        Pessoa pessoaEncontrada = null;

        for (Pessoa pessoa : cache) {
            if (pessoa.getId() == id) {
                pessoaEncontrada = pessoa;
                System.out.println("Pessoa encontrada no cache: " + pessoa);

                break;
            }
        }

        if (pessoaEncontrada == null) {
            for (Pessoa pessoa : banco) {
                if (pessoa.getId() == id) {
                    pessoaEncontrada = pessoa;
                    if (cache.size() >= 10) {
                        cache.remove(0);
                    }
                    cache.add(pessoa);
                    System.out.println("Pessoa buscada no banco e adicionada ao cache: " + pessoa);

                    break;
                }
            }
        }

        if (pessoaEncontrada == null) {
            System.out.println("Pessoa não encontrada.");
        }
    }
}
