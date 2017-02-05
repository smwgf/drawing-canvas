package com.bobaemw.drawingcanvas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    CanvasView _canvasView = null;
    Button _newCanvasBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _canvasView = (CanvasView) findViewById(R.id.canvasView);
        _canvasView.setmContext(MainActivity.this);

        _newCanvasBtn = (Button) findViewById(R.id.bt_new_canvas);
        _newCanvasBtn.setOnClickListener(_listener);

    }
    View.OnClickListener _listener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.bt_new_canvas:
                    _canvasView.initPaint(CanvasView.NEW_CANVAS);
                    break;
                default:
                    break;
            }
        }
    };

}
