package com.nhsbsa.security;

import lombok.*;

/**
 * Created by jeffreya on 27/09/2016.
 * AppToken
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "token"})
public class AppToken {
    private String id;
    private String token;
}
