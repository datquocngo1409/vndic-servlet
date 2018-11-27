import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "menu", urlPatterns = "/menu")
public class menu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        writer.println(
                "<html>\n" +
                        "<head>\n" +
                        "        <title>Vietnamese Dictionary</title>\n" +
                        "        <meta charshet=\"utf-8\" />\n" +
                        "    </head>\n"+
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<head>\n" +
                "  <title>Simple Dictionary</title>\n" +
                "  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Vietnamese Dictionary</h2>\n" +
                "<form action=\"/menu\" method=\"post\">" +
                "  <input type=\"text\" name=\"txtSearch\" placeholder=\"Enter your word: \"/>\n" +
                "  <input type = \"submit\" id = \"submit\" value = \"Search\"/>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");

        String search = request.getParameter("txtSearch");

        writer.println("<html>");
        writer.println(
                "<head>\n" +
                "        <title>Vietnamese Dictionary</title>\n" +
                "        <meta charshet=\"utf-8\" />\n" +
                "    </head>\n"
        );
        String result = dictionary.get(search);
        if(result != null){
            writer.println("Word: " + search);
            writer.println("<br>Result: " + result);
        } else {
            writer.println("Not found");
        }

        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println(
                        "<html>\n" +
                                "<head>\n" +
                                "        <title>Vietnamese Dictionary</title>\n" +
                                "        <meta charshet=\"utf-8\" />\n" +
                                "    </head>\n"+
                        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                        "<head>\n" +
                        "  <title>Simple Dictionary</title>\n" +
                        "  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h2>Vietnamese Dictionary</h2>\n" +
                        "<form action=\"/menu\" method=\"post\">" +
                        "  <input type=\"text\" name=\"txtSearch\" placeholder=\"Enter your word: \"/>\n" +
                        "  <input type = \"submit\" id = \"submit\" value = \"Search\"/>\n" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }
}
