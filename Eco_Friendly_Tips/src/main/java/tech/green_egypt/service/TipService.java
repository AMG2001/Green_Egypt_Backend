package tech.green_egypt.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tech.green_egypt.domain.model.Tip;
import tech.green_egypt.repo.TipRepo;
import tech.green_egypt.service.util.UUIDUtil;

@Service
public class TipService {

    
    private TipRepo tipRepo;


    @Autowired
    public TipService(TipRepo tipRepo){
        this.tipRepo=tipRepo;
    }
    
    public void addNewTip(String tipContent,MultipartFile tipIcon) throws IOException{
            Tip newTip = new Tip();
            newTip.setUuid(UUIDUtil.generateUUID());  
            newTip.setTipContent(tipContent);
            newTip.setTipIcon(tipIcon.getBytes());
            tipRepo.save(newTip);
    }
    
    public List<Tip> getAllTips(){
        return tipRepo.findAll();
    }

    public void deleteTipByUuid(UUID uuid){
        tipRepo.deleteByUuid(uuid);
    }
}
