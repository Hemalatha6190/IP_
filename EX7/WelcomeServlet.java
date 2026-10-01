import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("uname");
        String pass = request.getParameter("pwd");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("admin".equals(name) && "123".equals(pass)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", name);

            Integer visitorCount =
                    (Integer) getServletContext().getAttribute("visitorCount");

            if (visitorCount == null) {
                visitorCount = 0;
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome</title>");

            out.println("<style>");
            out.println("body{font-family:'Segoe UI',sans-serif;margin:0;"
                    + "background:linear-gradient(135deg,#74b9ff,#a29bfe);"
                    + "height:100vh;display:flex;justify-content:center;"
                    + "align-items:center;}");

            out.println(".box{background:#fff;padding:30px 40px;"
                    + "border-radius:12px;box-shadow:0 8px 24px "
                    + "rgba(0,0,0,0.15);width:100%;max-width:420px;"
                    + "text-align:center;}");

            out.println("h2{color:#2d3436;margin-bottom:10px;}");
            out.println("p{color:#636e72;margin:10px 0;}");

            out.println("a,input[type='submit']{background:#0984e3;"
                    + "color:#fff;text-decoration:none;border:none;"
                    + "padding:10px 20px;border-radius:6px;"
                    + "font-weight:600;display:inline-block;"
                    + "margin-top:15px;cursor:pointer;}");

            out.println("a:hover,input[type='submit']:hover{"
                    + "background:#74b9ff;}");

            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='box'>");

            out.println("<h2>Welcome, " + name + "!</h2>");

            out.println("<p><b>Total Unique Visitors So Far: "
                    + visitorCount + "</b></p>");

            out.println("<hr style='border:0;border-top:1px solid "
                    + "#dfe6e9;margin:20px 0;'>");

            out.println("<h3>Hidden Field Demo</h3>");

            out.println("<form action='HiddenFieldServlet' method='post'>");

            out.println("<input type='hidden' name='hf' value='"
                    + name + "'>");

            out.println("<input type='submit' value='Go (Hidden Field)'>");

            out.println("</form>");

            out.println("<h3 style='margin-top:20px;'>"
                    + "URL Rewriting Demo</h3>");

            out.println("<a href='URLRewriteServlet?uname="
                    + name + "'>Visit (URL Rewriting)</a>");

            out.println("</div>");

            out.println("</body>");
            out.println("</html>");

        } else {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Access Denied</title>");

            out.println("<style>");
            out.println("body{font-family:'Segoe UI',sans-serif;margin:0;"
                    + "background:linear-gradient(135deg,#ff7675,#fab1a0);"
                    + "height:100vh;display:flex;justify-content:center;"
                    + "align-items:center;}");

            out.println(".box{background:#fff;padding:30px 40px;"
                    + "border-radius:12px;box-shadow:0 8px 24px "
                    + "rgba(0,0,0,0.15);width:100%;max-width:380px;"
                    + "text-align:center;}");

            out.println("h2{color:#d63031;margin-bottom:10px;}");
            out.println("p{color:#636e72;}");

            out.println("a{background:#d63031;color:#fff;"
                    + "text-decoration:none;padding:10px 20px;"
                    + "border-radius:6px;font-weight:600;"
                    + "display:inline-block;margin-top:15px;}");

            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='box'>");

            out.println("<h2>Access Denied</h2>");

            out.println("<p>Invalid Username or Password!</p>");

            out.println("<a href='index.html'>Try Again</a>");

            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.html");
    }
}