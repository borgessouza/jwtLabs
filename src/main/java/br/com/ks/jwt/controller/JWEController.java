package br.com.ks.jwt.controller;

import br.com.ks.jwt.Utils.JwtUtils;
import br.com.ks.jwt.dto.BankDTO;
import com.google.gson.Gson;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwa.AlgorithmConstraints.ConstraintType;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("v1/jwe")
public class JWEController {

    private JwtUtils jwtUtils;

    public JWEController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }


    @GetMapping
    public String getJweToken() throws JoseException {
        Map<String,Object> clains = new HashMap<>();

        BankDTO payload = BankDTO.builder()
                .client("Cassiano")
                .cpf("12345678901")
                .issuer("Banco postal")
                .number(1212121L).build();


        return  jwtUtils.doGenerateEncrToken(clains,new Gson().toJson(payload));


    }
}
