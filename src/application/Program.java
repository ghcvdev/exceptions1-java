package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date: ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");

		} else {
			Reservation res = new Reservation(number, checkIn, checkOut);
			System.out.println(res);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date: ");
			Date checkIn2 = sdf.parse(sc.next());
			System.out.print("Check-out date: ");
			Date checkOut2 = sdf.parse(sc.next());

			// Date now = new Date();

			if (checkOut2.before(checkOut) || checkIn2.before(checkIn)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!checkOut2.after(checkIn2)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");

			} else {
				res.updateDates(checkIn, checkOut);
				System.out.println(res);
			}
		}

		sc.close();

	}

}
