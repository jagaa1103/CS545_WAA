package miu.edu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberComparision extends HttpServlet {
    Random rand = new Random(); //instance of random class
    int upperbound = 25;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer controlNumber = generateRandomNumber();
        Integer num1 = generateRandomNumber();
        Integer num2 = generateRandomNumber();
        Integer num3 = generateRandomNumber();
        req.setAttribute("controlNumber", controlNumber);
        req.setAttribute("num1", num1);
        req.setAttribute("num2", num2);
        req.setAttribute("num3", num3);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    private Integer generateRandomNumber() {
        return rand.nextInt(upperbound);
    }

    public Boolean checkStatus(Integer controlNumber, List<Integer> nums) {
        return controlNumber < nums.get(0) && controlNumber > nums.get(1) && controlNumber == nums.get(2);
    }
}
