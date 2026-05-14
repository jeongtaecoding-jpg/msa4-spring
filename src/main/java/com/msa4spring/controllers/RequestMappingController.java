package com.msa4spring.controllers;

import org.springframework.web.bind.annotation.*;

// @RestController : REST API 컨트롤러
// @RequestMapping : 클래스 레벨의 맵핑
// 위의 이 둘은 무조건 같이 써야 함.

// application.yml 파일 자체가 8080을 지정하는 건 아니고,
// 스프링 부트가 기본값(default)으로 8080을 사용하는 것.
// 다른 포트를 쓰고 싶으면 application.yml에 들어가서 직접 설정하면 됨
// 어떤 주소가 배정되었는지는 콘솔에 port XXXX를 보면 알 수 있음.

@RestController
@RequestMapping("/api")  // 소괄호 안에 /api 써붙이면 @RequestMapping 안에 있는 것들 제일 앞에 /api 가 붙게 됨.
public class RequestMappingController {
    @GetMapping("/test")
    public String test() {
        return "GET 테스트, http://localhost:8080/api/test";
    }

    @PostMapping("/test")
    public String testPost() {
        return "POST 테스트";
    }

}
