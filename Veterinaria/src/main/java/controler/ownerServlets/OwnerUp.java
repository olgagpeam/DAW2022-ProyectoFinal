/*
 *  
 */
package controler.ownerServlets;

import data.OwnerDAO;
import model.Owner;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "OwnerUp", urlPatterns = {"/OwnerUp"})

public class OwnerUp extends HttpServlet {

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        OwnerDAO dao = new OwnerDAO();
        ArrayList<Owner> ownr;
        try {
            String ine = rq.getParameter("ine");
            ownr = dao.select();
            String[] result = {"", "", "", "", "", "", ""};

            PrintWriter out = rp.getWriter();
            for (Owner owner : ownr) {
                if (owner.getIne().equals(ine)) {
                    result[0] = owner.getName();
                    Date bdate = null;
                    result[1] = null;
                    if (owner.getBdate() != null) {
                        bdate = new Date(df.parse(owner.getBdate().toString()).getTime());
                        result[1] = bdate.toString();
                    }
                    result[2] = owner.getAddr();
                    result[3] = owner.getCel();
                    result[4] = owner.getTel();
                    result[5] = owner.getEmail();
                    result[6] = ine;
                    rq.getSession().setAttribute("result", result);
                    rp.sendRedirect("/Veterinaria/views/ownerSearch.jsp");
                } else {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script>");
                    out.println("alert('Dueño no encontrado/INE equivocado!.');");
                    out.println("window.location='/Veterinaria/views/ownerUp.jsp'");
                    out.println("</script>");
                    out.println("</head>");
                    out.println("</html>");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(OwnerUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            String ine = rq.getParameter("ine");
            String name = rq.getParameter("name");
            Date bdate = null;
            if (!rq.getParameter("bdate").equals("")) {
                bdate = new Date(df.parse(rq.getParameter("bdate")).getTime());
            }
            String addr = rq.getParameter("addr");
            String tel = rq.getParameter("cel");
            String cel = rq.getParameter("tel");
            String email = rq.getParameter("email");

            OwnerDAO dao = new OwnerDAO();
            Owner ownr = new Owner(name, bdate, addr, tel, cel, email);

            PrintWriter out = rp.getWriter();
            if (dao.update(ownr, ine)) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Dueño actualizado con éxito.');");
                out.println("window.location='/Veterinaria/views/ownerUp.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Error al actualizar dueño!.');");
                out.println("window.location='/Veterinaria/views/ownerUp.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(OwnerUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
