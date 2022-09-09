package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do Quarto: ");
        int number = sc.nextInt();

        System.out.print("Data de Entrada (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("Data de Saida (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if ( !checkOut.after(checkIn)){
            System.out.println("Error na reserva: Data de Saida deve ser posterior da Data de Entrada");
        } else {
            Reservation reservation = new Reservation(number,checkIn,checkOut);
            System.out.println("Reserva: "+ reservation);

            System.out.println();
            System.out.println("Entre com a nova data de reserva: ");
            System.out.print("Data de Entrada (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de Saida (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            String error = reservation.updateData(checkIn,checkOut);
            if(error != null){
                System.out.println("Erro na reserva: " + error);
            }else{
                System.out.println("Reserva: "+ reservation);
            }

        }

        sc.close();
    }
}
