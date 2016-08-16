package manka.igor.sonder.model;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Igor on 12.08.2016.
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExpiringAccessToken {

    private String accessToken;
    private Date expires;

}
