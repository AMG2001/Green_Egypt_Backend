package tech.green_egypt.domain.model;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor @ToString @Document(collection = "Tips")
public class Tip {
    private UUID uuid;
    private String tipContent;
    private byte[] tipIcon;
    
}
