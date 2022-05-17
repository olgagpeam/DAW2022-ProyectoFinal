/*
 *  
 */
package controler.serviceServlets;

import data.ServiceDAO;
import model.Service;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ServiceSeIn", urlPatterns = {"/ServiceSeIn"})

public class ServiceSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ServiceDAO dao = new ServiceDAO();
        ArrayList<Service> ser;
        try {
            ser = dao.select();
            rq.getSession().setAttribute("ser", ser);
            rp.sendRedirect("/Veterinaria/views/ServiceConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ServiceSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            String nom = rq.getParameter("ser");

            ServiceDAO dao = new ServiceDAO();
            Service ser = new Service(nom);
            dao.insert(ser);
        } catch (ParseException ex) {
            Logger.getLogger(ServiceSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
