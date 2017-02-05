package com.bobaemw.drawingcanvas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    CanvasView _canvasView = null;
    Button _newCanvasBtn = null;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_color) {
            return true;
        }else if (id == R.id.menu_brush) {
            return true;
        }else if (id == R.id.menu_eraser) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
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
