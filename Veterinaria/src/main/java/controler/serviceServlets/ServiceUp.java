/*
 *  
 */
package controler.serviceServlets;

import data.ServiceDAO;
import model.Service;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ServiceUp", urlPatterns = {"/ServiceUp"})

public class ServiceUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));
        String nom = rq.getParameter("ser");

        ServiceDAO dao = new ServiceDAO();
        Service ser = new Service(nom);
        dao.update(ser, id);
    }
}
