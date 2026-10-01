package model;

public class MovieBooking {

    private String name;
    private String movie;
    private int tickets;
    private String payment;

    public MovieBooking(String name, String movie, int tickets, String payment) {
        this.name = name;
        this.movie = movie;
        this.tickets = tickets;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public String getMovie() {
        return movie;
    }

    public int getTickets() {
        return tickets;
    }

    public String getPayment() {
        return payment;
    }
}