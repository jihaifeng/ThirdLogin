package com.jihf.third;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import java.util.ArrayList;
import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Date：2017-04-21 16:58
 * Mail：jihaifeng@raiyi.com
 */
public class ShareActivity extends Activity {
  private RecyclerView ry_share;
  private RyShareAdapter shareAdapter;
  private Animation animShow;
  private Animation animHide;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initAnim();
    setContentView(R.layout.activity_share);
    initView();
    initData();
  }

  private void initAnim() {
    animShow =
        new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF,
            1, Animation.RELATIVE_TO_SELF, 0);
    animShow.setDuration(300);
    animHide =
        new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF,
            0, Animation.RELATIVE_TO_SELF, 1);
    animHide.setDuration(300);
  }

  private void initData() {
    List<ShareBean> list = new ArrayList<>();

    ShareBean s1 = new ShareBean();
    s1.shareText = "发送给朋友";
    s1.shareImg = R.drawable.logo_wechat;
    list.add(s1);

    ShareBean s2 = new ShareBean();
    s2.shareText = "微信朋友圈";
    s2.shareImg = R.drawable.logo_wechatmoments;
    list.add(s2);

    ShareBean s3 = new ShareBean();
    s3.shareText = "收藏到微信";
    s3.shareImg = R.drawable.logo_wechatfavorite;
    list.add(s3);

    ShareBean s4 = new ShareBean();
    s4.shareText = "微博";
    s4.shareImg = R.drawable.logo_sinaweibo;
    list.add(s4);

    ShareBean s5 = new ShareBean();
    s5.shareText = "QQ";
    s5.shareImg = R.drawable.share_qq;
    list.add(s5);

    ShareBean s6 = new ShareBean();
    s6.shareText = "QQ空间";
    s6.shareImg = R.drawable.share_qzone;
    list.add(s6);

    shareAdapter.setData(list);
  }

  private void initView() {
    ry_share = (RecyclerView) findViewById(R.id.ry_share);
    ry_share.setLayoutManager(new GridLayoutManager(this, 4));
    shareAdapter = new RyShareAdapter();
    ry_share.setAdapter(shareAdapter);
  }
}
