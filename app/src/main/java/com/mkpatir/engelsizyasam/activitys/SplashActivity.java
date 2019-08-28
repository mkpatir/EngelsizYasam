package com.mkpatir.engelsizyasam.activitys;

import android.content.Intent;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.mkpatir.engelsizyasam.R;

public class SplashActivity extends AppCompatActivity {

    AnimatedVectorDrawable splash_icon_with_anim;
    ImageView splash_icon_image;
    RelativeLayout splash_icon_relative;
    LinearLayout splash_main_layout;
    LinearLayout splash_login_layout;
    LinearLayout splash_register_layout;
    Button splash_change_login;
    Button splash_change_register;
    TextInputLayout splash_login_email;
    TextInputLayout splash_login_password;
    TextInputLayout splash_register_name;
    TextInputLayout splash_register_email;
    TextInputLayout splash_register_password;
    Button login_button;
    Button register_button;
    Switch splash_login_switch;
    Switch splash_register_switch;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) splash_icon_relative.getLayoutParams();
            layoutParams.removeRule(RelativeLayout.CENTER_VERTICAL);
            splash_icon_relative.setLayoutParams(layoutParams);
            splash_main_layout.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash_icon_image = (ImageView)findViewById(R.id.splash_main_icon);
        splash_icon_relative = (RelativeLayout)findViewById(R.id.splash_icon_relative);
        splash_main_layout = (LinearLayout)findViewById(R.id.splash_main_layout);
        splash_change_login = (Button)findViewById(R.id.splash_change_login);
        splash_change_register = (Button)findViewById(R.id.splash_change_register);
        splash_login_layout = (LinearLayout)findViewById(R.id.splash_login_layout);
        splash_register_layout = (LinearLayout)findViewById(R.id.splash_register_layout);
        splash_login_email = (TextInputLayout)findViewById(R.id.splash_login_email);
        splash_login_password = (TextInputLayout)findViewById(R.id.splash_login_password);
        splash_register_name = (TextInputLayout)findViewById(R.id.splash_register_name);
        splash_register_email = (TextInputLayout)findViewById(R.id.splash_register_email);
        splash_register_password = (TextInputLayout)findViewById(R.id.splash_register_password);
        login_button = (Button)findViewById(R.id.splash_login_button);
        register_button = (Button)findViewById(R.id.splash_register_button);
        splash_login_switch = (Switch)findViewById(R.id.splash_login_switch);
        splash_register_switch = (Switch)findViewById(R.id.splash_register_switch);
        splash_icon_with_anim = (AnimatedVectorDrawable) splash_icon_image.getDrawable();
        splash_icon_with_anim.start();
        handler.postDelayed(runnable,3000);
        setButtonClickAndSwitch();
        Login();
        Register();
    }

    public void setButtonClickAndSwitch(){
        try {
            splash_change_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    splash_change_login.setBackground(getResources().getDrawable(R.drawable.splash_button_back_on));
                    splash_change_register.setBackground(getResources().getDrawable(R.drawable.splash_button_back_off));
                    splash_change_login.setTextColor(getResources().getColor(android.R.color.white));
                    splash_change_register.setTextColor(getResources().getColor(R.color.AppColor1));
                    splash_login_layout.setVisibility(View.VISIBLE);
                    splash_register_layout.setVisibility(View.GONE);
                }
            });
            splash_change_register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    splash_change_login.setBackground(getResources().getDrawable(R.drawable.splash_button_back_off));
                    splash_change_register.setBackground(getResources().getDrawable(R.drawable.splash_button_back_on));
                    splash_change_login.setTextColor(getResources().getColor(R.color.AppColor1));
                    splash_change_register.setTextColor(getResources().getColor(android.R.color.white));
                    splash_login_layout.setVisibility(View.GONE);
                    splash_register_layout.setVisibility(View.VISIBLE);
                }
            });
            splash_login_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        splash_login_password.getEditText().setInputType(InputType.TYPE_CLASS_TEXT);
                    }
                    else {
                        splash_login_password.getEditText().setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }
                }
            });
            splash_register_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        splash_register_password.getEditText().setInputType(InputType.TYPE_CLASS_TEXT);
                    }
                    else {
                        splash_register_password.getEditText().setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }
                }
            });
        }
        catch (Exception ex){

        }
    }

    public void Login(){
        try {
            login_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkLoginEmail() && checkLoginPassword()){
                        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
        catch (Exception ex){

        }
    }

    public void Register(){
        try {
            register_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkRegisterName() && checkRegisterEmail() && checkRegisterPassword()){
                        Toast.makeText(getApplicationContext(),"üyelik başarılı",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        catch (Exception ex){

        }
    }

    public boolean checkLoginEmail(){
        try {
            if (splash_login_email.getEditText().getText().toString().equals("")){
                splash_login_email.setError("Email alanı boş bırakılamaz.");
                return false;
            }
            else {
                splash_login_email.setError(null);
                return true;
            }
        }
        catch (Exception ex){
            return false;
        }
    }

    public boolean checkLoginPassword(){
        try {
            if (splash_login_password.getEditText().getText().toString().equals("")){
                splash_login_password.setError("Şifre alanı boş bırakılamaz.");
                return false;
            }
            else {
                splash_login_password.setError(null);
                return true;
            }
        }
        catch (Exception ex){
            return false;
        }
    }

    public boolean checkRegisterEmail(){
        try {
            if (splash_register_email.getEditText().getText().toString().equals("")){
                splash_register_email.setError("Email alanı boş bırakılamaz.");
                return false;
            }
            else {
                splash_register_email.setError(null);
                return true;
            }
        }
        catch (Exception ex){
            return false;
        }
    }

    public boolean checkRegisterPassword(){
        try {
            if (splash_register_password.getEditText().getText().toString().equals("")){
                splash_register_password.setError("Şifre alanı boş bırakılamaz.");
                return false;
            }
            else if (splash_register_password.getEditText().getText().toString().length() < 6){
                splash_register_password.setError("Şifreniz en az 6 haneli olmalıdır.");
                return false;
            }
            else {
                splash_register_password.setError(null);
                return true;
            }
        }
        catch (Exception ex){
            return false;
        }
    }

    public boolean checkRegisterName(){
        try {
            if (splash_register_name.getEditText().getText().toString().equals("")){
                splash_register_name.setError("İsim alanı boş bırakılamaz.");
                return false;
            }
            else {
                splash_register_name.setError(null);
                return true;
            }
        }
        catch (Exception ex){
            return false;
        }
    }
}
