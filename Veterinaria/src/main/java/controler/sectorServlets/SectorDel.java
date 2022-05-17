/*
 *  
 */
package controler.sectorServlets;

import data.SectorDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "SectorDel", urlPatterns = {"/SectorDel"})

public class SectorDel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String id = rq.getParameter("id");

        SectorDAO dao = new SectorDAO();
        dao.delete(id);
    }
}
