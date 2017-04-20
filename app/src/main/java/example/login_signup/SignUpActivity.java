package example.login_signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class SignUpActivity extends AppCompatActivity {

    DBHelper db= new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }

    public void onSignupClick(View v){
        if (v.getId()==R.id.button_register){
            EditText name= (EditText) findViewById(R.id.editText_name1);
            String nameStr= name.getText().toString();
            EditText email= (EditText) findViewById(R.id.editText_email);
            String emailStr= email.getText().toString();
            EditText password= (EditText) findViewById(R.id.editText_password1);
            String passwordStr= password.getText().toString();

            User u = new User();
            u.setFullname(nameStr);
            u.setEmail(emailStr);
            u.setPassword(passwordStr);
            db.insertUser(u);
        }
    }
}
