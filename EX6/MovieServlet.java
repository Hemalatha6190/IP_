package controller;

import dao.MovieBookingDAO;
import model.MovieBooking;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String movie = request.getParameter("movie");
        String ticketsText = request.getParameter("tickets");
        String payment = request.getParameter("payment");

        int tickets;

        try {
            tickets = Integer.parseInt(ticketsText);
        } catch (Exception e) {
            response.getWriter().println("Invalid number of tickets.");
            return;
        }

        MovieBooking booking =
                new MovieBooking(name, movie, tickets, payment);

        MovieBookingDAO dao = new MovieBookingDAO();

        boolean status = dao.saveBooking(booking);

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Booking Status</title>");

        out.println("<style>");
        out.println("body {"
                + "font-family: Arial;"
                + "background: lightcyan;"
                + "text-align: center;"
                + "padding: 50px;"
                + "}");

        out.println(".box {"
                + "background: white;"
                + "width: 500px;"
                + "margin: auto;"
                + "padding: 30px;"
                + "border-radius: 15px;"
                + "box-shadow: 0px 0px 15px gray;"
                + "}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='box'>");

        if (status) {

            out.println("<h1>Booking Successful!</h1>");
            out.println("<h2>Ticket Details</h2>");

            out.println("<p><b>Name:</b> " + name + "</p>");
            out.println("<p><b>Movie:</b> " + movie + "</p>");
            out.println("<p><b>Number of Tickets:</b> "
                    + tickets + "</p>");
            out.println("<p><b>Payment:</b> " + payment + "</p>");

            out.println("<p>Booking saved successfully.</p>");

        } else {

            out.println("<h2>Booking Failed!</h2>");
            out.println("<p>Unable to save the booking.</p>");
            out.println("<a href='index.html'>Try Again</a>");
        }

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}