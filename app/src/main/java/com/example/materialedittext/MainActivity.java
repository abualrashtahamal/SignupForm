package com.example.materialedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    //decliration
    TextInputLayout Username,Password,Email,Phone,Address;
    Button Signup;
    String name,pass,email,number,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intialization

        Username=(TextInputLayout) findViewById(R.id.user);
        Password=(TextInputLayout) findViewById(R.id.password);
        Email=(TextInputLayout) findViewById(R.id.email);
        Phone=(TextInputLayout) findViewById(R.id.phone);
        Address=(TextInputLayout) findViewById(R.id.address);

        //onclicklistener
        Signup=(Button) findViewById(R.id.signup);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!usernameValidate() || ! passwordValidate() || !PhoneValidate() || !emailValidate() || !addValidate()){
                    return;
                }else{
                    Toast.makeText(getApplicationContext(), "welcom"+Username.getEditText().getText(), Toast.LENGTH_LONG).show();
                }



            }
        });




    }
    //methods of validation

    //validateusername
    boolean usernameValidate(){

        name=Username.getEditText().getText().toString().trim();
        if(name.isEmpty()){

            Username.setError("this field shouldnot be empty !!");
            return false;
        }else{
           Username.setErrorEnabled(false);
           return true;
        }

    }
    //validatepassword
    boolean passwordValidate(){

        pass=Password.getEditText().getText().toString().trim();
        if(pass.isEmpty()){

            Password.setError("this field shouldnot be empty !!");
            return false;
        }else{
            Password.setErrorEnabled(false);
            return true;
        }

    }
    //validatePhone
    boolean PhoneValidate(){

        number=Phone.getEditText().getText().toString().trim();
        String validid=number.substring(0,2);
        if(number.isEmpty()){

            Phone.setError("this field shouldnot be empty !!");
            return false;

        }else if(number.length()!=9) {

            Phone.setError("the number should be 9 digits");
            return false;
        }

        else if(!validid.equals("77")&&!validid.equals("78")&&!validid.equals("79")){
            Phone.setError("your numbernot valid");
            return false;
        }

        else{
            Phone.setErrorEnabled(false);
            return true;
        }


    }
    //validateEmail
    boolean emailValidate(){

        email=Email.getEditText().getText().toString().trim();
        if(email.isEmpty()){

            Email.setError("this field shouldnot be empty !!");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("sorry your email not valid try again ");
            return false;

        }else{
            Email.setErrorEnabled(false);
            return true;
        }

    }
    //validateadd
    boolean addValidate(){

        add=Address.getEditText().getText().toString().trim();
        if(add.isEmpty()){

            Address.setError("this field shouldnot be empty !!");
            return false;
        }else{
            Address.setErrorEnabled(false);
            return true;
        }

    }
}
