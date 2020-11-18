package com.wiggins.toast;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wiggins.toast.base.BaseActivity;
import com.wiggins.toastlibrary.ToastUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTvToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
    }

    private void initView() {
        mTvToast = (TextView) findViewById(R.id.tv_toast);
    }

    private void setListener() {
        mTvToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_toast:
                ToastUtil.showText("骗你的啦！！！");
                break;
        }
    }
}
