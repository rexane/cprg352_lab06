
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String action = (String) request.getParameter("action");
         String username = (String) session.getAttribute("username");

        if ((action != null) && (action.equals("logout"))) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

        if (username != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);   
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String action = (String) request.getParameter("action");
        String username = request.getParameter("username");
        String item = request.getParameter("item");
        String delete = request.getParameter("item");
        ArrayList<String> list = (ArrayList) session.getAttribute("list");

        if (list == null) {
            list = new ArrayList<>();
        }
        
        if (action.equals("register")) {
            if (username == null || username.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
            session.setAttribute("username", username);
        }
        
        if (action.equals("add") && !item.equals("")) {
            list.add(item);
        }
        
        if (action.equals("delete")) {
            if (delete == null || delete.equals("")) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
            list.remove(delete);
        }
        
        session.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}