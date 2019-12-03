package com.example.androiddemo.activity;

import android.os.Bundle;

import com.example.androiddemo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.percentlayout.widget.PercentLayoutHelper;
import androidx.percentlayout.widget.PercentRelativeLayout;

import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private TextView tvSignupInvoker;
    private LinearLayout llSignup;
    private TextView tvSigninInvoker;
    private LinearLayout llSignin;
    private Button btnSignup;
    private Button btnSignin;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_component:
                    mTextMessage.setText(R.string.title_component);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            setContentView(R.layout.activity_main);
            return false;
        }
    };

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (false) {
//          setContentView(R.layout.activity_main);
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//          mTextMessage = findViewById(R.id.message);
//        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        } else {
            setContentView(R.layout.activity_main);

            tvSignupInvoker = (TextView) findViewById(R.id.tvSignupInvoker);
            tvSigninInvoker = (TextView) findViewById(R.id.tvSigninInvoker);

            btnSignup= (Button) findViewById(R.id.btnSignup);
            btnSignin= (Button) findViewById(R.id.btnSignin);

            llSignup = (LinearLayout) findViewById(R.id.llSignup);
            llSignin = (LinearLayout) findViewById(R.id.llSignin);

            tvSignupInvoker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showSignupForm();
                }
            });

            tvSigninInvoker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showSigninForm();
                }
            });
            showSigninForm();

            btnSignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_right_to_left);
                    btnSignup.startAnimation(clockwise);
                }
            });
//        }
    }

    private void showSignupForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) llSignin.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.15f;
        llSignin.requestLayout();

        PercentRelativeLayout.LayoutParams paramsSignup = (PercentRelativeLayout.LayoutParams) llSignup.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignup = paramsSignup.getPercentLayoutInfo();
        infoSignup.widthPercent = 0.85f;
        llSignup.requestLayout();

        tvSignupInvoker.setVisibility(View.GONE);
        tvSigninInvoker.setVisibility(View.VISIBLE);
        Animation translate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_right_to_left);
        llSignup.startAnimation(translate);

        Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_right_to_left);
        btnSignup.startAnimation(clockwise);

    }

    private void showSigninForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) llSignin.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.85f;
        llSignin.requestLayout();

        PercentRelativeLayout.LayoutParams paramsSignup = (PercentRelativeLayout.LayoutParams) llSignup.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignup = paramsSignup.getPercentLayoutInfo();
        infoSignup.widthPercent = 0.15f;
        llSignup.requestLayout();

        Animation translate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_left_to_right);
        llSignin.startAnimation(translate);

        tvSignupInvoker.setVisibility(View.VISIBLE);
        tvSigninInvoker.setVisibility(View.GONE);
        Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_left_to_right);
        btnSignin.startAnimation(clockwise);
    }

}
