package com.feedback;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Student Feedback</title></head>");
        out.println("<body style='font-family:Arial;text-align:center;background:#f0f4f8;padding:30px'>");
        out.println("<h1>Student Feedback Form</h1>");

        out.println("<form method='post' action='feedback'>");

        out.println("<p>Your Name</p>");
        out.println("<input name='name' required maxlength='100'>");

        out.println("<p>Your Feedback</p>");
        out.println("<textarea name='message' required maxlength='1000'></textarea>");

        out.println("<p>Rating</p>");
        out.println("<select name='rating' required>");
        out.println("<option value=''>Choose rating</option>");
        out.println("<option value='1'>1 - Poor</option>");
        out.println("<option value='2'>2 - Fair</option>");
        out.println("<option value='3'>3 - Good</option>");
        out.println("<option value='4'>4 - Very Good</option>");
        out.println("<option value='5'>5 - Excellent</option>");
        out.println("</select>");

        out.println("<p><button type='submit'>Submit Feedback</button></p>");
        out.println("</form>");
        out.println("<a href='./'>Back to Home</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String message = request.getParameter("message");
        String ratingText = request.getParameter("rating");

        int rating = 0;

        try {
            rating = Integer.parseInt(ratingText);
        } catch (NumberFormatException | NullPointerException e) {
            // Invalid rating remains zero.
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Feedback Result</title></head>");
        out.println("<body style='font-family:Arial;text-align:center;padding:30px'>");

        if (FeedbackValidator.isValid(name, message, rating)) {
            out.println("<h1>Thank You!</h1>");
            out.println("<p>Your feedback was submitted successfully.</p>");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("<h1>Invalid Feedback</h1>");
            out.println("<p>Please enter a valid name, message and rating from 1 to 5.</p>");
        }

        out.println("<p><a href='feedback'>Submit Another Feedback</a></p>");
        out.println("<p><a href='./'>Back to Home</a></p>");
        out.println("</body></html>");
    }
}
