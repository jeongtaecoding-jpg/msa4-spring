package com.msa4spring.controllers;

import com.msa4spring.responses.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResponseEntityController {
    @GetMapping("/res")
    public ResponseEntity<ResponseDTO<String>> res() {
        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder()
                .code("00")
                .msg("정상 처리")
                .data("데이터 입니다.")
                .build();

        // ResponseEntity<ResponseDTO<String>>
        // ( Integer로 값을 바꿀 땐 위의 제네릭을 모두 Integer로 바꾸고  .data()안에 숫자를 넣으면 된다.
        return ResponseEntity.status(300).body(responseDTO);
    }
}
