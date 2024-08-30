package tech.amg.user_service.domain.entity;

import jakarta.validation.constraints.Email;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tech.amg.user_service.domain.enums.Credintial;

import java.util.UUID;

@Document(collection = "users")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private byte[] image;
    @Email(message = "Enter valid email !!")
    private String email;
    private String password;
    private String phoneNumber;
    private Credintial credintial;
    private Long totalNumberOfPlastic;
    private Long totalNumberOfCans;
    private Long totalNumberOfPoints;
    public String getValue(){
        return credintial.getStringValue();
    }
}
