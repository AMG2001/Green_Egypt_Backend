package tech.amg.user_service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data @NoArgsConstructor @AllArgsConstructor
public class TipDto {
    private UUID uuid;
    private String tipContent;
    private byte[] tipIcon;
}
