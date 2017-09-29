package com.example.usuario.sendmessagebutterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.usuario.sendmessagebutterknife.pojo.Message;

/**
 * Activity secundaria. Recibe un nombre de usuario
 * y un mensaje de la Activity principal.
 */
public class ViewMessageActivity extends AppCompatActivity {

    public static final String TAG = "com.example.sendmessagebutterknife";
    private TextView txvViewMessage;
    private TextView txvViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);
        txvViewMessage = (TextView) findViewById(R.id.txvViewMessage);
        txvViewUser = (TextView) findViewById(R.id.txvViewUser);
        //1: Recoger el Intent que se ha enviado
        //2: Recoger el mensaje del Bundle
        //3: Mostrar mensaje
        Message message = getIntent().getParcelableExtra("message");
        txvViewMessage.setText(message.getMessage());
        txvViewUser.setText(
                String.format(
                    getResources().getString(R.string.txvViewUser),
                    message.getUser()
                )
        );
        //Tenerlo en una sola línea de código reduce la cantidad de objetos duplicados

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ViewMessage.onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ViewMessage.onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ViewMessage.onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ViewMessage.onPause()");
    }
}
