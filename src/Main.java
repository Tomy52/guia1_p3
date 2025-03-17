import Repositories.Implementations.PaymentsRepository;
import Ui.Menu;

public class Main {
    public static void main(String[] args) {
        Menu pagosMenu = new Menu(new PaymentsRepository());

        pagosMenu.mostrarMenu();
    }
}