package test.proj6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button addBtn;
    private MyFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = (MyFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_1);

        addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.addNewObj();
            }
        });
    }
}
