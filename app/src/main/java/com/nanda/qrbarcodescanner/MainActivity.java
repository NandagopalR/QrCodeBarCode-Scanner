package com.nanda.qrbarcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mScanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (mScanButton = (Button) findViewById(R.id.scanCodes)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new IntentIntegrator(this).setCaptureActivity(QrBarCaptureActivity.class).setBeepEnabled(true).
                setPrompt("Place the Barcode/QR Code inside the frame").initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                showToast("Scanning Cancelled");
            } else {
                showToast("Scanned - " + result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
