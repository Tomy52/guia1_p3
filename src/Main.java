import Repositories.Implementations.PaymentsRepository;
import Ui.Implementations.PaymentsMenu;

public class Main {
    public static void main(String[] args) {
        PaymentsMenu pagosMenu = new PaymentsMenu(new PaymentsRepository());

        pagosMenu.mostrarMenu();
    }
}