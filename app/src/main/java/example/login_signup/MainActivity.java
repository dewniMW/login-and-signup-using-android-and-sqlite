package example.login_signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper db= new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSignup(View view){
        Intent intent= new Intent(this, SignUpActivity.class);
        startActivity(intent);

    }

    public void onLoginClick(View v) {
        if (v.getId() == R.id.button_login) {

            EditText email = (EditText) findViewById(R.id.editText_email);
            String emailStr = email.getText().toString();
            EditText password = (EditText) findViewById(R.id.editText_password);
            String passwordStr = password.getText().toString();

            //String password_1= db.searchPass(emailStr,passwordStr);
            boolean b= db.searchPass(emailStr,passwordStr);
            if (b){
                email.setText("");
                password.setText("");
                Toast t1= Toast.makeText(MainActivity.this,"Successful login",Toast.LENGTH_SHORT);
                t1.show();
            }
            else{
                email.setText("");
                password.setText("");
                Toast t2= Toast.makeText(MainActivity.this,"Password and username don't match",Toast.LENGTH_SHORT);
                t2.show();
            }
           /* if(passwordStr.equals(password_1)){

                email.setText("");
                password.setText("");
                Toast t1= Toast.makeText(MainActivity.this,"Successful login",Toast.LENGTH_SHORT);
                t1.show();
            }
            else{
                email.setText("");
                password.setText("");
                Toast t2= Toast.makeText(MainActivity.this,"Password and username don't match",Toast.LENGTH_SHORT);
                t2.show();
            }*/
        }
    }
}
