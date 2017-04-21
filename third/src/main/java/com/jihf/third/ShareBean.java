package com.jihf.third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Date：2017-04-21 17:53
 * Mail：jihaifeng@raiyi.com
 */
public class ShareBean {
  public String shareText;
  public int shareImg;

  public static final String wxFriend = "发送给朋友";
  public static final int ico_wxFriend = R.drawable.logo_wechat;

  public static final String wxFriendCicle = "微信朋友圈";
  public static final int ico_wxFriendCicle = R.drawable.logo_wechatmoments;

  public static final String wxFacorite = "收藏到微信";
  public static final int ico_wxFacorite = R.drawable.logo_wechatfavorite;

  public static final String sinaweibo = "微博";
  public static final int ico_sinaweibo = R.drawable.logo_sinaweibo;

  public static final String QQ = "QQ";
  public static final int ico_QQ = R.drawable.share_qq;

  public static final String Qzone = "QQ空间";
  public static final int ico_Qzone = R.drawable.share_qzone;

  private HashMap<String, Integer> hashMap = new HashMap<>();

  public List<String> getShareText() {
    List<String> stringList = new ArrayList<>();
    stringList.add(wxFriend);
    stringList.add(wxFriendCicle);
    stringList.add(wxFacorite);
    stringList.add(sinaweibo);
    stringList.add(QQ);
    stringList.add(Qzone);
    return stringList;
  }
}
