package com.itheima.feedback;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;


public class MainActivity
        extends Activity
        implements View.OnClickListener
{

    private Button mBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ctrl + alt + f
        mBtn1 = (Button) findViewById(R.id.btn1);

        //
        mBtn1.setOnClickListener(this);
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

    @Override
    public void onClick(View v)
    {
        if (v == mBtn1)
        {
            //放大的动画
            //            ObjectAnimator animator = ObjectAnimator.ofFloat(v,
            //                                                             "scaleX",
            //                                                             0.5f,
            //                                                             1f);
            //            animator.start();


            int centerX = v.getWidth() / 2;//动画起始的位置x坐标
            int centerY = v.getHeight() / 2;//动画起始的位置y坐标
            float startRadius = v.getWidth();//水波纹开始时的半径
            float endRadius = 0;//结束的半径
            Animator animator = ViewAnimationUtils.createCircularReveal(v,
                                                                        centerX,
                                                                        centerY,
                                                                        startRadius,
                                                                        endRadius);
            animator.setDuration(3000);
            animator.start();
        }
    }
}
