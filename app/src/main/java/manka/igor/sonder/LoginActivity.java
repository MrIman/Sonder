package manka.igor.sonder;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import manka.igor.sonder.model.ExpiringAccessToken;
import manka.igor.sonder.model.LoginAttempt;
import manka.igor.sonder.repository.AuthenticationRepository;
import manka.igor.sonder.utils.RetrofitCallbackAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://91.134.137.115:6969")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
    final AuthenticationRepository authenticationRepository = retrofit.create(AuthenticationRepository.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Intent a = new Intent(LoginActivity.this, MainActivity.class); //oDPALENIE BEZ LOGOWANIA
//        startActivity(a);
        Button loginButton = (Button)findViewById(R.id.loginButton);
        final EditText loginET = (EditText)findViewById(R.id.loginEditText);
        final EditText passwordET = (EditText)findViewById(R.id.passwordEditText);
        final TextView textView = (TextView)findViewById(R.id.failMessage) ;
        loginButton.setOnClickListener(new View.OnClickListener() {
            boolean czyPoprawne = true;
            @Override
            public void onClick(View v) {

                LoginAttempt loginAttempt = new LoginAttempt(loginET.getText().toString(), passwordET.getText().toString());

                    authenticationRepository.login(loginAttempt).enqueue(new RetrofitCallbackAdapter<ExpiringAccessToken>() {

                        @Override
                        public void onResponse(Call<ExpiringAccessToken> call, Response<ExpiringAccessToken> response) {
                            textView.setText("");
                            try {
                                ExpiringAccessToken token = response.body();
                                token.getAccessToken();
                                token.getExpires();

                                runIntentSync(new Intent(LoginActivity.this, MainActivity.class));
                            }
                            catch(Exception ex){
                                textView.setText("Błędny login lub hasło");
                            }

                        }

                        @Override
                        public void onFailure(Call<ExpiringAccessToken> call, Throwable t) {

                            textView.setText("Błąd sieci");

                        }


                    });


            }
        });
    }

    protected void runIntentSync(final Intent intent) {
        runOnUi(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        });
    }

    protected void runOnUi(Runnable runnable) {
        new Handler().post(runnable);
    }

}
