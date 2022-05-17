/*
 *  
 */
package controler.serviceServlets;

import data.ServiceDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ServiceDel", urlPatterns = {"/ServiceDel"})

public class ServiceDel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));

        ServiceDAO dao = new ServiceDAO();
        dao.delete(id);
    }
}
