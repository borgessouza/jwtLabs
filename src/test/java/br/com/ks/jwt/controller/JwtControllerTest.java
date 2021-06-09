package br.com.ks.jwt.controller;

import br.com.ks.jwt.Utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtControllerTest {

   @Autowired
   private MockMvc mockMvc;
   @Autowired
   private JwtUtils jwtUtils;

   @Test
   public void shouldTestJwtController() throws Exception{
      this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/jwt"))
              .andExpect(MockMvcResultMatchers.status().isOk())
              .andExpect(MockMvcResultMatchers.content().string("Hello"));

   }

}
