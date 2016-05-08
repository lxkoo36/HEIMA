package com.itheima.themedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity
        extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        int theme = getIntent().getIntExtra("theme",
                                            -1);
        if (theme != -1)
        {
            setTheme(theme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void clickTheme1(View view)
    {
        changeTheme(R.style.Theme1);
    }

    public void clickTheme2(View view)
    {
        changeTheme(R.style.Theme2);
    }

    private void changeTheme(int theme)
    {
        //必须在activity的setContentView之前
        //activity必须重启

        overridePendingTransition(0,
                                  0);
        finish();
        Intent intent = new Intent(this,
                                   MainActivity.class);
        intent.putExtra("theme",
                        theme);
        overridePendingTransition(0,
                                  0);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,
                                  menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
