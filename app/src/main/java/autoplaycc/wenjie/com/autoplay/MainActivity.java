package autoplaycc.wenjie.com.autoplay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import autoplaycc.wenjie.com.autoplay.Util.GlobalUtils;
import autoplaycc.wenjie.com.autoplay.Util.TimeUtil;
import autoplaycc.wenjie.com.autoplay.Util.Utils;

public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        webView = (WebView) findViewById(R.id.webView);
        clear();
        Utils.setWebView(webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
//        http://www.wenjienet.com/px-cc/index.html?t=1231233333
        String path = GlobalUtils.httpPath+"?t="+ TimeUtil.getNowTime();
//        String path = GlobalUtils.testPath;
        webView.loadUrl(path);
        Log.v("TAG", "打印网址 : " + path);
    }

    @Override
    protected void onStop() {
        super.onStop();
        webView.destroy();
    }

    public void clear(){
        WebStorage webStorage = WebStorage.getInstance();
        webStorage.deleteAllData();
        deleteDatabase("webview.db");
        deleteDatabase("webviewCache.db");
        webView.clearCache(true);
        webView.clearHistory();

//        (getCacheDir().toString());
    }
}
