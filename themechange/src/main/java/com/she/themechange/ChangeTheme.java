package com.she.themechange;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 晓勇 on 2015/8/29 0029.
 */
public class ChangeTheme extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        com.she.themechange.ThemeChangeUtil.changeTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        Button mChangeBtn = (Button) findViewById(R.id.btn_change);
        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ThemeChangeUtil.isChange) {
                    ThemeChangeUtil.isChange = false;
                } else {
                    ThemeChangeUtil.isChange = true;
                }
                ChangeTheme.this.recreate();//重新创建当前Activity实例
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mIntent = new Intent(this, MainActivity.class);
        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mIntent);
        finish();
    }
}
