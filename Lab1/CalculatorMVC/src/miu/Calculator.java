package miu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Calculator extends HttpServlet {
    Integer sum = 0;
    Integer profit = 0;

    Integer add1 = 0;
    Integer add2 = 0;

    Integer multi1 = 0;
    Integer multi2 = 0;

    public Calculator () {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("====== Calculator :: doGet =====");

        String num1 = req.getParameter("add1");
        String num2 = req.getParameter("add2");

        String num3 = req.getParameter("multi1");
        String num4 = req.getParameter("multi2");

        try {
            add1 = Integer.parseInt(num1);
            add2 = Integer.parseInt(num2);
            multi1 = Integer.parseInt(num3);
            multi2 = Integer.parseInt(num4);
            sum =  add1 + add2;
            profit = multi1 * multi2;
            req.setAttribute("add1", add1);
            req.setAttribute("add2", add2);
            req.setAttribute("multi1", multi1);
            req.setAttribute("multi2", multi2);
            req.setAttribute("sum", sum);
            req.setAttribute("profit", profit);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
            dispatcher.forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
