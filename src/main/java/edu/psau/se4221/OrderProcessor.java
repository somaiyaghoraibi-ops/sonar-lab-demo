package edu.psau.se4221;

/**
 * Intentionally smelly class for the Maintainability part of the lab.
 * Students will refactor this to satisfy the Quality Gate.
 */
public class OrderProcessor {

    public double processOrder(String type, int qty, double price,
                               boolean member, boolean holiday) {
        double total = 0;
        if (type.equals("A")) {
            if (qty > 10) { total = qty * price * 0.9; }
            else { total = qty * price; }
            if (member) { total = total * 0.95; }
            if (holiday) { total = total * 1.1; }
        } else if (type.equals("B")) {
            if (qty > 20) { total = qty * price * 0.85; }
            else { total = qty * price; }
            if (member) { total = total * 0.95; }
            if (holiday) { total = total * 1.15; }
        } else if (type.equals("C")) {
            if (qty > 5) { total = qty * price * 0.95; }
            else { total = qty * price; }
            if (member) { total = total * 0.95; }
            if (holiday) { total = total * 1.2; }
        } else {
            total = qty * price;
        }
        double tax = total * 0.15;
        return total + tax;
    }
}
