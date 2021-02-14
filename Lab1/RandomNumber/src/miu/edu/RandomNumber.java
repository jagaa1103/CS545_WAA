package miu.edu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "RandomNumber", urlPatterns = "/generate")
public class RandomNumber extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer randomNumber = generateRandomNumber();
        System.out.println("randomNumber: " + randomNumber);
        req.setAttribute("randomNumber", randomNumber);
        req.getRequestDispatcher("display.jsp").forward(req, resp);
    }

    private Integer generateRandomNumber() {
        Random rand = new Random(); //instance of random class
        int upperbound = 25;
        return rand.nextInt(upperbound);
    }
}
