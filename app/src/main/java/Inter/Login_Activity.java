package Inter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.liguochao.cuberunning.R;

public class Login_Activity extends Activity {

    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        showButtonLogin();

    }

    private void showButtonLogin() {
        login = (Button) findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login_Activity.this,"点了一下登陆！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
