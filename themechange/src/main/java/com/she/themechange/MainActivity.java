package com.she.themechange;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private ViewGroup layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeChangeUtil.changeTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (ViewGroup) this.findViewById(R.id.layout);
        Button mSettingBtn = (Button) findViewById(R.id.btn_setting);
        mSettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        FloatingActionButton actionButton = (FloatingActionButton) findViewById(R.id.fab);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar sb=Snackbar.make(v, "跳转下一页", Snackbar.LENGTH_LONG).setAction("jump", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.this.startActivity(new Intent(MainActivity.this, ChangeTheme.class));
                    }
                });
                //红色
                sb.getView().setBackgroundColor(0xfff44336);
                sb.show();
            }
        });
    }
}
