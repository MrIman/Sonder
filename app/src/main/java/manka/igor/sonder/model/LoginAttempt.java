package manka.igor.sonder.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Igor on 12.08.2016.
 */
@Data //adnotacje
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginAttempt {
    private String username;
    private String password;

}
