package tech.green_egypt.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tech.green_egypt.service.TipService;

@RestController
@RequestMapping("tips")
public class TipsController {

    private TipService tipService;

    @Autowired
    public TipsController(TipService tipService) {
        this.tipService = tipService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTips() {
        try {
            return ResponseEntity.ok(tipService.getAllTips());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewTip(@RequestParam String tipContent,
            @RequestParam MultipartFile tipIcon) {
        try {
            tipService.addNewTip(tipContent, tipIcon);
            return ResponseEntity.ok("New Tip Added");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<?> deleteTip(@PathVariable("uuid") UUID deletedTipUuid){
        try{
            tipService.deleteTipByUuid(deletedTipUuid);
            return ResponseEntity.ok("deleted successfully");
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
