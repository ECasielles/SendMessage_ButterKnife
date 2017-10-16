package com.example.usuario.sendmessagebutterknife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.sendmessagebutterknife.pojo.Message;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Activity principal. Pide un nombre de usuario
 * y un mensaje para enviarlo a la Activity ViewMessage,
 * que se lanza al pulsar el botón "OK".
 *
 * Versión con la librería ButterKnife
 *
 * Conceptos:
 * <ul>
 *     <li>Context</li>
 *     <li>Intent entre actividades</li>
 *     <li>Paso de parámetros con Bundle</li>
 * </ul>
 *
 * @author Enrique Casielles Lapeira
 * @version 2.0
 * @see android.app.Activity
 * @see android.support.v7.app.AppCompatActivity
 *
 */
public class SendMessageActivity extends AppCompatActivity {

    @BindView(R.id.edtMessage)
    EditText edtMessage;
    @BindView(R.id.edtUser)
    EditText edtUser;
    @BindView(R.id.btnOk)
    Button btnOk;


    //public static final String TAG = "com.example.sendmessagebutterknife";
    public static final String TAG = "sendmessagebutterknife";
    private Message mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        //Vincular el ide de las vistas en el XMl con las clases View
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessage.onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessage.onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessage.onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessage.onPause()");
    }


    @OnClick(R.id.btnOk)
    public void getOnClick(View view) {
        switch (view.getId()) {
            case R.id.btnOk:
                Bundle bundle = new Bundle();
                Message message = new Message(
                        edtMessage.getText().toString(),
                        edtUser.getText().toString()
                );
                bundle.putParcelable("message", message);
                Intent intent = new Intent(SendMessageActivity.this, ViewMessageActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }

}
