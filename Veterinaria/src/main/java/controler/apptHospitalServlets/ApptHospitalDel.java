/*
 *  
 */

package controler.apptHospitalServlets;

import data.ApptHospitalDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ApptHospitalDel", urlPatterns = {"/ApptHospitalDel"})

public class ApptHospitalDel extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));

        ApptHospitalDAO dao = new ApptHospitalDAO();
        dao.delete(id);
    }
}
