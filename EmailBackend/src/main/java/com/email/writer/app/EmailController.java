package com.email.writer.app;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("generate")
    public Mono<ResponseEntity<String>> generateEmail(@RequestBody EmailRequest emailRequest){
       return emailService.generateEmailReply(emailRequest)
               .map(ResponseEntity::ok);
    }
    
}
