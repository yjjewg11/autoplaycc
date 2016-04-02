package autoplaycc.wenjie.com.autoplay.Util;

import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by tangt on 2016/3/4.
 */
public abstract class Utils {
    public static void setWebView(WebView webView){
        WebSettings webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
    }
}
