<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Booking Confirmation</title>

    <link rel="stylesheet" href="style.css">

    <style>
        .confirmation {
            width: 450px;
            margin: 50px auto;
            padding: 25px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px #cccccc;
        }

        .confirmation h2 {
            color: green;
            text-align: center;
        }

        .confirmation p {
            font-size: 16px;
            margin: 12px 0;
        }

        .confirmation a {
            display: block;
            width: 180px;
            margin: 20px auto 0;
            text-align: center;
            text-decoration: none;
        }
    </style>
</head>

<body>

<header>
    <h1>Online Movie Ticket Booking</h1>

    <nav>
        <a href="index.html">Home</a>
        <a href="movies.html">Movies</a>
        <a href="booking.html">Book Ticket</a>
    </nav>
</header>

<div class="confirmation">

    <h2>Booking Successful!</h2>

    <p>
        <strong>Customer Name:</strong>
        <%= request.getAttribute("customerName") %>
    </p>

    <p>
        <strong>Movie Name:</strong>
        <%= request.getAttribute("movieName") %>
    </p>

    <p>
        <strong>Show Date:</strong>
        <%= request.getAttribute("showDate") %>
    </p>

    <p>
        <strong>Show Time:</strong>
        <%= request.getAttribute("showTime") %>
    </p>

    <p>
        <strong>Number of Tickets:</strong>
        <%= request.getAttribute("ticketCount") %>
    </p>

    <p>
        <strong>Total Amount:</strong>
        ₹<%= request.getAttribute("totalAmount") %>
    </p>

    <a class="button" href="index.html">Back to Home</a>

</div>

<footer>
    <p>© 2026 Online Movie Ticket Booking System</p>
</footer>

</body>
</html>