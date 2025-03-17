package Ui;

import Enums.InvoiceType;
import Exceptions.InvalidAmountException;
import Model.Implementations.CashPayment;
import Repositories.Implementations.PaymentsRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Verifications.Verifications.*;

public class Menu {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
    PaymentsRepository payments;

    public Menu(PaymentsRepository payments) {
        this.payments = payments;
    }

    public void mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        System.out.println("Bienvenido al sistema de gestion de pagos\n");
        do {
            System.out.println("Elija una opcion:\n");
            System.out.println("1. Agregar un pago");
            System.out.println("2. Eliminar un pago");
            System.out.println("3. Ver pagos en orden cronologico");
            System.out.println("4. Ver pagos por ID");
            System.out.println("5. Ver pagos por DNI");
            System.out.println("0. Salir\n");
            System.out.println("\nOpcion elegida: ");
            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    try {
                        addPaymentMenu();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    //deletePayment();
                    break;
                case 3:
                    //viewPaymentsByChrono();
                    break;
                case 4:
                    //viewPaymentsByID();
                    break;
                case 5:
                    //viewPaymentsByDNI();
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

    public void addPaymentMenu() throws InvalidAmountException {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        System.out.println("Ingrese el monto a pagar:");
        float amount = Float.parseFloat(teclado.nextLine());
        if (!verifyAmount(amount)) throw new InvalidAmountException("El monto debe ser mayor a 0!");

        System.out.println("Ingrese el numero de dni:");
        String dni = teclado.nextLine();

        System.out.println("Ingrese el tipo de factura a emitir (a,b,c,x):");
        InvoiceType invoiceType = InvoiceType.valueOf(teclado.nextLine().toUpperCase());

        System.out.println("Ingrese el id del negocio:");
        String shopId = teclado.nextLine();

        System.out.println("Elija un medio de pago:\n");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta de credito");
        System.out.println("3. PayPal");
        System.out.println("4. Crypto");
        System.out.println("\nOpcion elegida: ");
        opcion = Integer.parseInt(teclado.nextLine());

        switch (opcion) {
            case 1:
                addCashPayment(amount, dni, invoiceType, shopId);
                break;
            case 2:
                //addCardPayment();
                break;
            case 3:
                //addPayPalPayment();
                break;
            case 4:
                //addCryptoPayment();
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                break;
        }
    }

    public void addCashPayment(float amount, String dni, InvoiceType invoiceType,String shopId) {
        payments.add(new CashPayment(amount,dni,invoiceType,shopId));
    }

    public void addCardPayment(float amount, String dni, InvoiceType invoiceType,String shopId) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el nombre y apellido del titular de la tarjeta:");

        System.out.println("Ingrese el ");
    }
}
