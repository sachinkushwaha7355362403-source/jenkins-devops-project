package com.feedback;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackValidatorTest {

    @Test
    void validFeedbackShouldPass() {
        assertTrue(
            FeedbackValidator.isValid("Rahul", "Good teaching", 5)
        );
    }

    @Test
    void emptyNameShouldFail() {
        assertFalse(
            FeedbackValidator.isValid("", "Good teaching", 5)
        );
    }

    @Test
    void emptyMessageShouldFail() {
        assertFalse(
            FeedbackValidator.isValid("Rahul", "", 5)
        );
    }

    @Test
    void invalidRatingShouldFail() {
        assertFalse(
            FeedbackValidator.isValid("Rahul", "Good teaching", 6)
        );
    }
}
