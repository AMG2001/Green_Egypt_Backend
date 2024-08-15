package tech.amg.transactions_service.domain.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Document
public class Transaction {
    @Id
    Long transactionId;
    Long userId;
@Email(message = "Enter Valid email !!")
String userEmail;
@Length(max = 11 , min = 11 , message = "Phone number must be 11 Digit !!")
@Pattern(regexp = "^0(10|11|12)\\d{8}$", message = "Invalid phone number format")
String userPhoneNumber;
    Long numberOfCans;
    Long numberOfPlastic;
@DateTimeFormat
LocalDate transactionDate;
@DateTimeFormat
LocalTime transactionTime;
}
