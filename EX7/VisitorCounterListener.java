import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class VisitorCounterListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        ServletContext context = se.getSession().getServletContext();

        synchronized (context) {

            Integer count = (Integer) context.getAttribute("visitorCount");

            if (count == null) {
                count = 0;
            }

            count = count + 1;

            context.setAttribute("visitorCount", count);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // No action needed
    }
}