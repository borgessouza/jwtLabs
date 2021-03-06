package br.com.ks.jwt.controller;

import br.com.ks.jwt.Utils.JwtUtils;
import br.com.ks.jwt.dto.BankDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("v1/jwt")
public class JwtController {

    private JwtUtils jwtUtils;

    public JwtController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @GetMapping
    public String getJwt() {
        Map<String,Object> clains = new HashMap<>();

        BankDTO payload = BankDTO.builder()
                .client("Cassiano")
                .cpf("12345678901")
                .issuer("Banco postal")
                .number(1212121L).build();


        return  jwtUtils.doGenerateToken(clains,new Gson().toJson(payload));
    }


    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Boolean validateJwt(@RequestParam MultiValueMap<String,String> map) {
        System.out.println(map.toString());
        return this.jwtUtils.validate(map.get("token").get(0));

    }

}
