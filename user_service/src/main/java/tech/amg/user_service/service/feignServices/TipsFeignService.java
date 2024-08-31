package tech.amg.user_service.service.feignServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.amg.user_service.domain.dto.TipDto;
import tech.amg.user_service.feign.TipsServiceInterface;

import java.util.List;

@Service
public class TipsFeignService {
private TipsServiceInterface tipsServiceInterface;

    @Autowired
    public TipsFeignService(TipsServiceInterface tipsServiceInterface) {
        this.tipsServiceInterface = tipsServiceInterface;
    }

    public List<TipDto> getAllTips(){
        return tipsServiceInterface.getAllTips().getBody();
    }


}
