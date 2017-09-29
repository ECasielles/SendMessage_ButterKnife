package com.example.usuario.sendmessagebutterknife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.sendmessagebutterknife.pojo.Message;

/**
 * Activity principal. Pide un nombre de usuario
 * y un mensaje para enviarlo a la Activity ViewMessage,
 * que se lanza al pulsar el botón "OK".
 *
 * Conceptos:
 * <ul>
 *     <li>Context</li>
 *     <li>Intent entre actividades</li>
 *     <li>Paso de parámetros con Bundle</li>
 * </ul>
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see android.app.Activity
 * @see android.support.v7.app.AppCompatActivity
 *
 */
public class SendMessageActivity extends AppCompatActivity {

    public static final String TAG = "com.example.sendmessagebutterknife";
    //public static final String TAG = "SendMessageActivity";
    private EditText edtMessage;
    private EditText edtUser;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        edtMessage = (EditText) findViewById(R.id.edtMessage);
        edtUser = (EditText) findViewById(R.id.edtUser);
        btnOk = (Button) findViewById(R.id.btnOk);
        //Usando clases anónimas
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Message message = new Message(
                        edtMessage.getText().toString(),
                        edtUser.getText().toString()
                );
                bundle.putParcelable("message", message);
                Intent intent = new Intent(SendMessageActivity.this, ViewMessageActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
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

    public void getOnClick(View view) {

        /*switch (view.getId()){
            case R.id.btnOk:
                //1: Recoger el mensaje
                //2: Crear un objeto Bundle y añadir el mensaje
                Bundle bundle = new Bundle();
                bundle.putString("message", edtMessage.getText().toString());
                bundle.putString("user", edtUser.getText().toString());

                //3: Crear un objeto Intent
                //Por nomenclatura se usa el nombre de la clase más this, aunque
                //sea obvio.
                Intent intent = new Intent(SendMessageActivity.this, ViewMessageActivity.class);

                //4: Añadir el objeto Bundle al objeto Intent
                intent.putExtras(bundle);
                //4: Iniciar la Activity ViewMessage
                startActivity(intent);
                break;
        }*/

    }
}
