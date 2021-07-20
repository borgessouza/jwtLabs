package br.com.ks.jwt.certs;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

@Component
public class Cert {

   private KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
   private PublicKey publicKey;
   private PrivateKey privateKey;


    public Cert() {
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }


    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }
}
