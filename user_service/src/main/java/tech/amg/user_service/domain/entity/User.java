package tech.amg.user_service.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.lang.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import tech.amg.user_service.domain.enums.Credintial;

@Document(collection = "users")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class User {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    private String uuid;
    private String firstName;
    private String lastName;
    @Nullable
    private byte[] image;
    @Indexed(unique = true)
    @Email(message = "Enter valid email !!")
    private String email;
    @Length(min = 8,message = "the length of the password must be 8 or more")
    private String password;
    @Pattern(regexp = "^(010|011|012|015)\\d{8}$", message = "Phone number must start with 010, 011, 012, or 015 and be 11 digits long")
    @Length(min = 11,message = "must be 11 digit")
    @Indexed(unique = true)
    private String phoneNumber;
    private Credintial credintial;
    private long totalNumberOfPlastic;
    private long totalNumberOfCans;
    private long totalNumberOfPoints;
    public String getValue(){
        return credintial.getStringValue();
    }
}
