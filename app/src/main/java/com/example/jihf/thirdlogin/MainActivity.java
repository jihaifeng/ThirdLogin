package com.example.jihf.thirdlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.jihf.third.ShareActivity;
import com.jihf.third.share.wx.WeChatShare;
import com.jihf.third.share.wx.WxShareTo;
import com.jihf.third.share.wx.WxShareType;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private Button btnShareWx;
  private Button btnShareQQ;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
  }

  private void initView() {
    btnShareWx = (Button) findViewById(R.id.btn_share_wx);
    btnShareWx.setOnClickListener(this);
    btnShareQQ = (Button) findViewById(R.id.btn_share_QQ);
    btnShareQQ.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btn_share_wx:
        WeChatShare.regToWx(this)
            .setWhere(WxShareTo.share_session)
            .setType(WxShareType.type_text)
            .addShareText("你好")
            .share();
        break;
      case R.id.btn_share_QQ:
        startActivity(new Intent(this, ShareActivity.class));
        //WeChatShare.regToWx(this)
        //    .setWhere(WxShareTo.share_session)
        //    .setType(WxShareType.type_text)
        //    .addShareText("你好")
        //    .share();
        break;
    }
  }
}
