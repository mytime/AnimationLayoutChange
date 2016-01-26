package com.jikexueyuan.animationlayoutchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 布局内容改变动画
 * <!--android:animateLayoutChanges="true"  启用布局改变动画 -->
 */
public class MainActivity extends AppCompatActivity {

    //线性布局对象
    private LinearLayout rootView;

    //按钮点击事件
    private View.OnClickListener btn_onclicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //移除按钮
            rootView.removeView(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //查找布局
        rootView = (LinearLayout) findViewById(R.id.rootView);
    }

    //创建菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //菜单点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_add:
                addButton();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //动态生成一个按钮
    private void addButton() {
        Button btn = new Button(this);
        btn.setText("Remove me");
        rootView.addView(btn);

        //自定义动画效果
        //移位动画
//        TranslateAnimation ta = new TranslateAnimation(0,200,0,200);
//        ta.setDuration(1000);
//        btn.startAnimation(ta);

        //按钮的监听事件
        btn.setOnClickListener(btn_onclicklistener);
    }
}
