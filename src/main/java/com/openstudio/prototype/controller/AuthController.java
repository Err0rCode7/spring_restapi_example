package com.openstudio.prototype.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.openstudio.prototype.dto.ListApiResponse;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthController {

/*  jackson 사용예시
    @GetMapping("gson-test")
    public JsonNode gsonTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        AuthDto authDto = new AuthDto();
        authDto.setJwtCode("testCode");
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "test1");
        hashMap.put(2, "test2");
        hashMap.put(3, "test3");

        // java object를 json string 으로 바꿔줌
        String userAsString = objectMapper.writeValueAsString(hashMap);
        // json 파일로 바꿔줌
        JsonNode jsonNode = objectMapper.readTree(userAsString);
        return jsonNode;
    }
    */
}
