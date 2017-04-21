package com.jihf.third.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
import com.jihf.third.constants.Constants;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Date：2017-04-18 14:43
 * Mail：jihaifeng@raiyi.com
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
  public static final String TAG = WXEntryActivity.class.getSimpleName().trim();
  private IWXAPI api;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    TextView currrentTextView = new TextView(this);
    setContentView(currrentTextView);
    api = WXAPIFactory.createWXAPI(this, Constants.WeChat_APPID, false);
    api.handleIntent(getIntent(), this);
  }

  @Override protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    api.handleIntent(intent, this);
  }

  @Override public void onReq(BaseReq baseReq) {
    Log.i(TAG, "onReq: ");
  }

  @Override public void onResp(BaseResp resp) {
    Log.i(TAG, "onResp: ");
    int errorCode = resp.errCode;
    switch (errorCode) {
      case BaseResp.ErrCode.ERR_OK:
        //用户同意
        String code = ((SendAuth.Resp) resp).code;
        Log.i(TAG, "ERR_OK: ");
        break;
      case BaseResp.ErrCode.ERR_AUTH_DENIED:
        //用户拒绝
        Log.i(TAG, "ERR_AUTH_DENIED: ");
        break;
      case BaseResp.ErrCode.ERR_USER_CANCEL:
        //用户取消
        Log.i(TAG, "ERR_USER_CANCEL: ");
        break;
      default:
        break;
    }
  }
}
