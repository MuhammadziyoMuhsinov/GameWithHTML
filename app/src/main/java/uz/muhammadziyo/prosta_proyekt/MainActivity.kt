package uz.muhammadziyo.prosta_proyekt

import android.app.DirectAction
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import java.util.function.Consumer
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.myWebView)
        val webSetting: WebSettings = webView.settings
        webSetting.builtInZoomControls = true
        webSetting.javaScriptEnabled = true

        webView.webViewClient = CallBack()

        webView.loadUrl("file:///android_asset/index.html")


    }

    private class CallBack : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?,
        ): Boolean {

            return false
        }
    }



    override fun onBackPressed() {
        if (webView != null && webView.canGoBack()){
            webView.goBack()
        }else{
            super.onBackPressed()
        }

    }



}