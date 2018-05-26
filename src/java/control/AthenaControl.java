/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gru100
 */
@WebServlet(name = "AthenaControl", urlPatterns = {"/AthenaControl"})
public class AthenaControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AthenaControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AthenaControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
    //Až dosud jde o text automaticky generovaný při vytvoření nového servletu.
    //Tato metoda má dva vstupní argumenty, jimiž jsou request a response:
    //1) Request - požadavek uživatele, ať už jde o provedení akce či o přístup k datům. V tomto objektu
    //jsou zároveň uchovány všechny vstupy, které byly do systému zadány, tj. tento objekt obsahuje veškeré
    //informace zapsané do textových polí v naší úvodní stránce.
    //2) Response - reprezentuje nějaké speciální chování programu po přijetí požadavku, například
    //periodické zasílání zpráv či upozornění. My žádnou speciální akci od stránek nečekáme, proto
    //response necháme být.
            
    
    //Jednotlivé parametry pak můžeme z požadavku získávat pomocí příkazu getParameter, 
    //argumentem je pak námi zvolený název parametru určený v html souboru úvodní stránky.
            String name = request.getParameter("name");
            String status = request.getParameter("status");
            String place = request.getParameter("place");
            String pass = request.getParameter("pass");
    
            //Zde jednoduše ověřuji heslo. Kupříkladu zde budou informace zadané do textových polí
            //zprocesovány, zadal-li uživatel do kolonky Pass slovo heslo.
            if ("heslo".equals(pass)) {
                //Vytvořím si nový záznam z jednotlivých parametrů.
                model.Athena athena = new model.Athena(name, status, place);
                //Nově vzniklý záznam následně "přilepím" k požadavku, tj. metody pracující
                //s požadavkem budou rázem moci manipulovat i s novým objektem.
                request.setAttribute("athena", athena);
                //Příkazem getRequestDispatcher určím cílovou stránku, tj. kam uživatele po stisku
                //tlačítka přesunu. Příkazem forward pak dodám stránce i všechny informace obsažené v požadavku.
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("denied.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
        return "Short description";
    }// </editor-fold>

}
