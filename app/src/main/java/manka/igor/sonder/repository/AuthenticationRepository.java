package manka.igor.sonder.repository;

import manka.igor.sonder.model.ExpiringAccessToken;
import manka.igor.sonder.model.LoginAttempt;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Igor on 12.08.2016.
 */
public interface AuthenticationRepository {

    @Headers({"Content-Type: application/json"})
    @POST("/auth/login")
    Call<ExpiringAccessToken> login(@Body LoginAttempt loginAttempt);

}
