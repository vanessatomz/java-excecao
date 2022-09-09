package application;

import model.entities.Reservation;
import modell.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            System.out.print("Numero do Quarto: ");
            int number = sc.nextInt();

            System.out.print("Data de Entrada (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());

            System.out.print("Data de Saida (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number,checkIn,checkOut);
            System.out.println("Reserva: "+ reservation);

            System.out.println();
            System.out.println("Entre com a nova data de reserva: ");
            System.out.print("Data de Entrada (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de Saida (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateData(checkIn,checkOut);
            System.out.println("Reserva: "+ reservation);

            sc.close();
        } catch (ParseException e ){
            System.out.println("Data invalida.");
        } catch (DomainException e){
            System.out.println("Erro na reserva: "+ e.getMessage());
        }catch (RuntimeException e ){
            System.out.println("Erro inesperado.");
        }
        
    }
}
