package com.nanda.qrbarcodescanner;

import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.CompoundBarcodeView;

/**
 * Created by nandagopal on 9/13/16.
 */
public class QrBarCaptureActivity extends CaptureActivity {

    @Override
    protected CompoundBarcodeView initializeContent() {
        setContentView(R.layout.activity_code_capture);
        return (CompoundBarcodeView) findViewById(R.id.zxing_barcode_scanner);
    }

}
