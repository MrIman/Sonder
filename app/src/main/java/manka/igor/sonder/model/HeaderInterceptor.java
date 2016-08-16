package manka.igor.sonder.model;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Igor on 12.08.2016.
 */
public class HeaderInterceptor
        implements Interceptor {
    @Override
    public Response intercept(Chain chain)
            throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("Odpowiedz", "NoSiema")
                .build();
        Response response = chain.proceed(request);
        return response;
    }
}
