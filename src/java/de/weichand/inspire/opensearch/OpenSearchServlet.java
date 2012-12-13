package de.weichand.inspire.opensearch;

import de.weichand.inspire.opensearch.dataset.DatasetConfigurationFactory;
import de.weichand.inspire.opensearch.dataset.iface.ISimpleDatasetConfiguration;
import de.weichand.inspire.opensearch.exception.OpenSearchException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Simple Example for an INSPIRE Pre-defined Atom OpenSearch Interface<br />
 * 
 * @author Juergen Weichand
 */
public class OpenSearchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String alias = request.getRequestURI().replace(request.getContextPath() + "/", "");
            
            ISimpleDatasetConfiguration dataset = DatasetConfigurationFactory.getDataset(alias);
            
            
            String parRequest = request.getParameter("request");
            String parCrs =  request.getParameter("crs");
            
            // Operation DescribeSpatialDataset
            if (parRequest != null && parRequest.toLowerCase().equals("describespatialdataset")) {
                response.sendRedirect(dataset.getDatasetFeed());
                
            // Operation GetSpatialDataset
            } else if (parRequest != null && parRequest.toLowerCase().equals("getspatialdataset")) {
                if (parCrs == null) {
                    throw new OpenSearchException("Missing 'crs' parameter!");
                }
                try {
                    int epsg = Integer.valueOf(parCrs.split(":")[1]);
                    response.sendRedirect(dataset.getDataset(epsg));
                } catch (NumberFormatException ex) {
                    throw new OpenSearchException(ex);
                }
            
            //  else OpenSearchDescription
            } else {
                response.sendRedirect(dataset.getOpenSearchDescriptionDocument());
            }
            
        } catch (OpenSearchException ex) {
            PrintWriter writer = response.getWriter();
            writer.write("Error: " + ex.getMessage());
            writer.close();
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Simples Beispiel für Pre-defined Atom OpenSearch";
    }// </editor-fold>
}
