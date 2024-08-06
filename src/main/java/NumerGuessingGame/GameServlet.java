package NumerGuessingGame;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value="/game")
public class GameServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int target_number = (int) ((Math.random() * 100) + 1);
        int attempts = 0;
        if (session.getAttribute("attempts") != null) {
            attempts = (int) session.getAttribute("attempts");
        }
        
        String guessStr = req.getParameter("guess");
        int guess;
        try {
            guess = Integer.parseInt(guessStr);
        } catch (NumberFormatException e) {
            req.setAttribute("message", "Invalid input. Please enter a number.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
        
        if (guess < 1 || guess > 100) {
            req.setAttribute("message", "Invalid input. Please enter a number between 1 and 100.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
        
        attempts++;
        session.setAttribute("attempts", attempts);
        
        String message;
        if (guess < target_number) {
            message = "too low!";
        } else if (guess > target_number) {
            message = "too high !!";
        } else {
            message = "correct !";
            int score = 5 - attempts;
            req.setAttribute("score", score);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
            return;
        }
        
        if (attempts >= 5) {
            req.setAttribute("message", "You've reached the maximum number of attempts. The correct answer was " + target_number);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
            return;
        }
        
        req.setAttribute("message", message);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}


