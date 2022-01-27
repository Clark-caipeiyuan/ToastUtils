/**
 * FileName: TestActivity
 * Author: clark
 * Date: 2022/1/27 9:42 上午
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.wiggins.toastlibrary;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @ClassName: TestActivity
 * @Description: java类作用描述
 * @Author: clark
 * @Date: 2022/1/27 9:42 上午
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_main);
        ImageView imageView=(ImageView)findViewById(R.id.image_view);
        Glide.with(this).load("https://img1.baidu.com/it/u=1407750889,3441968730&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=799").into(imageView);

    }
}
