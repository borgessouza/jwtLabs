package br.com.ks.jwt.dto;

import lombok.Builder;

@Builder
public class BankDTO {
    private String issuer;
    private String client;
    private String cpf;
    private Long number;
}
