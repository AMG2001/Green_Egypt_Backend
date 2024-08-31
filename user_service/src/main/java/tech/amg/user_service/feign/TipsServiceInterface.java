package tech.amg.user_service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tech.amg.user_service.domain.dto.TipDto;

import java.util.List;

@FeignClient("tips-service")
public interface TipsServiceInterface {
    @GetMapping("/green_egypt/api/v1/tips")
    public ResponseEntity<List<TipDto>> getAllTips();
}
