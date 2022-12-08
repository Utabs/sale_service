package co.shop.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String service_token;

    public JwtResponse(String jwtToken) {
        this.service_token = jwtToken;
    }

}
