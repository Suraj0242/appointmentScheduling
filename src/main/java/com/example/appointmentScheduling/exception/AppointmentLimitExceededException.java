package com.example.appointmentScheduling.exception;


public class AppointmentLimitExceededException extends RuntimeException {
    public AppointmentLimitExceededException(String message) {
        super(message);
    }
}
