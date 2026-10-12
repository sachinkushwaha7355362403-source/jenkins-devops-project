package com.feedback;

public class FeedbackValidator {

    public static boolean isValid(String name, String message, int rating) {

        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        if (message == null || message.trim().isEmpty()) {
            return false;
        }

        if (rating < 1 || rating > 5) {
            return false;
        }

        return true;
    }
}
