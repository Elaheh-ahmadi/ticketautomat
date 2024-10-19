package com.spengergasse;

import com.spengergasse.exceptions.InvalidPaymentException;
import com.spengergasse.exceptions.InvalidPriceException;

public class TicketAutomat {
    private double preisInEuro;
    private double bezahlterBetrag = 0;

    public TicketAutomat() {
    }

    public TicketAutomat(double preisInEuro) throws InvalidPriceException {
        this.setPreisInEuro(preisInEuro);
    }

    public double getPreisInEuro() {
        return preisInEuro;
    }

    public void setPreisInEuro(double preisInEuro) throws InvalidPriceException {
        if (preisInEuro <= 0) {
            throw new InvalidPriceException("Price cannot be less than 0");
        }

        if (preisInEuro > 1000) {
            throw new InvalidPriceException("Price cannot be greater than 1000");
        }

        this.preisInEuro = preisInEuro;
    }

    public double getBezahlterBetrag() {
        return bezahlterBetrag;
    }

    public void setBezahlterBetrag(double bezahlterBetrag) throws InvalidPaymentException {
        if (bezahlterBetrag < 0) {
            throw new InvalidPaymentException("Paid amount cannot be less than 0");
        }

        if (bezahlterBetrag != 0.20 && bezahlterBetrag != 0.5 && bezahlterBetrag != 1) {
            throw new InvalidPaymentException("Accepted amounts are 0.2, 0.5 and 1 Euros");
        }

        this.bezahlterBetrag += bezahlterBetrag;
    }


    public double ticketKaufen() {
        if (this.bezahlterBetrag < this.preisInEuro) {
            System.out.println("Not enough funds has been deposited");
            return this.preisInEuro - this.bezahlterBetrag;
        }

        this.bezahlterBetrag -= this.preisInEuro;
        this.ticketDrucken();
        return 0.0;
    }

    private void ticketDrucken() {
        String _price = String.valueOf(this.preisInEuro);
        String price = ("            " + _price).substring(_price.length());

        StringBuilder s = new StringBuilder();
        s.append("#########################\n");
        s.append("#     Die SPG-Linie     #\n");
        s.append("# --------------------- #\n");
        s.append("# Einzelticket          #\n");
        s.append("# --------------------- #\n");
        s.append(String.format("# Preis: %s € #\n", price));
        s.append("#########################");

        System.out.println(s.toString());
    }

}
