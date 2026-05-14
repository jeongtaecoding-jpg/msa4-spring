package com.msa4spring.controllers;

import com.msa4spring.requests.PostsFilterRequest;
import com.msa4spring.requests.UsersPaginationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsersController {
    @GetMapping("/users")
    public String index(
            // @RequestParam(value = "pa") String page   // value : 요청에서 받을 파라미터 이름 지정(pa로 바뀜) 잘 안씀!!!
            // @RequestParam(required = false) String page   // required : 파라미터 필수 여부(기본값은 true임), true이면 없을 경우 400 에러 발생(false를 넣고 주소를 보낼 때 값을 넣지 않으면 그냥 null 반환)
            @RequestParam(required = false, defaultValue = "1") String page   // defaultValue : 파라미터가 없을 때 사용할 기본값( 1 지정 )
            , @RequestParam String limit
    ) {
        // 쿼리 파라미터 획득 방법 : @RequestParam 어노테이션을 통해 획득
        return "GET USERS : " + page + ", " + limit;
    }



    // @GetMapping("/users/key") 처럼 users 뒤에 자리가 겹치도록 넣으면 중복되서 안 됨.
    @GetMapping("/users/{id}")
    public String show(
            @PathVariable String id
    ) {
        return "GET users show: " + id;
    }

    @PostMapping("/users")
    public String store() {
        return "POST USERS";
    }



    // ---------------------------
    // DTO를 활용하여 파라미터 획득
    // ---------------------------
    @GetMapping("/users/dto-param")
    public String dtoParam(
            UsersPaginationRequest usersPaginationRequest
    ) {
        // String이면 %s,  int이면 %d  (UsersPaginationRequest 참조)
        return String.format("GET dtoParam : %d, %d", usersPaginationRequest.page(), usersPaginationRequest.limit());
    }



    // --- 세그먼트 파라미터 || Form Data를 DTO로 획득
    // @ModelAttribute 사용
    @GetMapping("/posts/{id}/filter/{categoryId}")
    public String postFilter(
            @ModelAttribute PostsFilterRequest postsFilterRequest
    ) {
        return String.format("postFilter: %d, %d", postsFilterRequest.id(), postsFilterRequest.categoryId());
    }


    // JSON 데이터를 DTO로 획득 : @RequestBody 사용
    @GetMapping("/posts/json")
    public String postsJson(
            @RequestBody PostsFilterRequest postsFilterRequest
    ) {
        return String.format("postsJson: %d, %d", postsFilterRequest.id(), postsFilterRequest.categoryId());
    }
}
