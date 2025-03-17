package Ui;

import Enums.InvoiceType;
import Exceptions.ExpiredCardException;
import Exceptions.InvalidAmountException;
import Exceptions.InvalidCardException;
import Exceptions.InvalidDniException;
import Model.Implementations.CashPayment;
import Model.Implementations.CreditCardPayment;
import Model.Implementations.PayPalPayment;
import Repositories.Implementations.PaymentsRepository;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Verifications.Verifications.*;

public class Menu {
    private final Scanner teclado = new Scanner(System.in);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
    private final PaymentsRepository payments;

    public Menu(PaymentsRepository payments) {
        this.payments = payments;
    }

    public void mostrarMenu() {
        int opcion;

        System.out.println("Bienvenido al sistema de gestion de pagos\n");
        do {
            System.out.println("Elija una opcion:\n");
            System.out.println("1. Agregar un pago");
            System.out.println("2. Ver pagos");
            System.out.println("0. Salir\n");
            System.out.println("\nOpcion elegida: ");
            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    try {
                        addPaymentMenu();
                        System.out.println("Pago agregado!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    viewPayments();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        } while (opcion != 0);
    }

    //opc 1

    public void addPaymentMenu() throws InvalidAmountException, ExpiredCardException, InvalidCardException, InvalidDniException {
        int opcion;

        System.out.println("Ingrese el monto a pagar:");
        float amount = Float.parseFloat(teclado.nextLine());
        if (!verifyAmount(amount)) throw new InvalidAmountException("El monto debe ser mayor a 0!");

        System.out.println("Ingrese el numero de dni:");
        String dni = teclado.nextLine();
        if (!verifyNumericData(dni,8)) throw new InvalidDniException("El dni es invalido!");

        System.out.println("Ingrese el tipo de factura a emitir (a,b,c,x):");
        InvoiceType invoiceType = InvoiceType.valueOf(teclado.nextLine().toUpperCase());


        System.out.println("Elija un medio de pago:\n");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta de credito");
        System.out.println("3. PayPal");
        System.out.println("4. Crypto");
        System.out.println("\nOpcion elegida: ");
        opcion = Integer.parseInt(teclado.nextLine());

        switch (opcion) {
            case 1:
                addCashPayment(amount, dni, invoiceType);
                break;
            case 2:
                addCardPayment(amount, dni, invoiceType);
                break;
            case 3:
                addPayPalPayment(amount, dni, invoiceType);
                break;
            case 4:
                addCryptoPayment(amount, dni, invoiceType);
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                break;
        }
    }

    public void addCashPayment(float amount, String dni, InvoiceType invoiceType) throws InvalidAmountException {
        System.out.println("Ingrese el id del negocio:");
        int shopId = Integer.parseInt(teclado.nextLine());

        System.out.println("Ingrese el vuelto:");
        float changeAmount = Float.parseFloat(teclado.nextLine());
        if (!verifyChangeAmount(amount)) throw new InvalidAmountException("El vuelto debe ser mayor o igual a 0!");

        payments.add(new CashPayment(amount,dni,invoiceType,shopId,changeAmount));
    }

    public void addCardPayment(float amount, String dni, InvoiceType invoiceType) throws InvalidCardException, ExpiredCardException {
        System.out.println("Ingrese el id del negocio:");
        int shopId = Integer.parseInt(teclado.nextLine());

        System.out.println("Ingrese el nombre y apellido del titular de la tarjeta:");
        String cardholder = teclado.nextLine();

        System.out.println("Ingrese el numero de tarjeta (16 digitos):");
        String cardNumber = teclado.nextLine();
        if (!verifyNumericData(cardNumber,16)) throw new InvalidCardException("Numero de tarjeta invalido!");

        System.out.println("Ingrese el numero de seguridad (3 digitos):");
        String cvv = teclado.nextLine();
        if (!verifyNumericData(cvv,3)) throw new InvalidCardException("Numero de tarjeta invalido!");

        System.out.println("Ingrese mes y anio de vencimiento de la tarjeta (MM/AAAA):");
        YearMonth expirationDate = YearMonth.parse(teclado.nextLine(),formatter);
        if (!verifyExpirationDate(expirationDate)) throw new ExpiredCardException("Tarjeta vencida!");

        payments.add(new CreditCardPayment(amount,dni,invoiceType,shopId, cardholder, cardNumber,cvv, expirationDate));
    }

    public void addPayPalPayment(float amount, String dni, InvoiceType invoiceType) {
        System.out.println("Ingrese el sitio web donde se quiere hacer el pago:");
        String website = teclado.nextLine();

        System.out.println("Ingrese el mail con el que realizara el pago:");
        String emailAddress = teclado.nextLine();

        payments.add(new PayPalPayment(amount,dni,invoiceType,website,emailAddress));
    }

    public void addCryptoPayment(float amount, String dni, InvoiceType invoiceType) {
        System.out.println("Ingrese el sitio web donde se quiere hacer el pago:");
        String website = teclado.nextLine();

        System.out.println("Ingrese la direccion de la billetera con la que realizara el pago:");
        String walletAddress = teclado.nextLine();

        payments.add(new PayPalPayment(amount,dni,invoiceType,website,walletAddress));
    }

    //opc 2
    public void viewPayments() {
        System.out.println(payments);
    }
}
