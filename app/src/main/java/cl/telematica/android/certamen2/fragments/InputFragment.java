package cl.telematica.android.certamen2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import cl.telematica.android.certamen2.HttpServerConnection;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import cl.telematica.android.certamen2.R;

public class InputFragment extends Fragment {

    EditText eText1;
    EditText eText2;
    Button button_1;
    TextView tText;
    String str1;
    String resultado;


    /**
     * New instance of InputFragment
     *
     * @return new instance of InputFragment
     */
    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mainView = inflater.inflate(R.layout.fragment_input, null);


        /*
         * Aquí es donde deben hacer el link a los elementos del layout fragment_input,
         * y donde prácticamente se debe hacer el desarrollo
        */

        button_1 = (Button) mainView.findViewById(R.id.button1);

        eText1 = (EditText) mainView.findViewById(R.id.name_input);
        eText2 = (EditText) mainView.findViewById(R.id.lastname_input);

        tText = (TextView)mainView.findViewById(R.id.Joke_text);




        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = "firstName="+eText1.getText().toString()+"&lastName="+eText2.getText().toString();

                AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

                    @Override
                    protected void onPreExecute(){

                    }





                    @Override
                    protected String doInBackground(Void... params) {
                        resultado = new HttpServerConnection().connectToServer("http://api.icndb.com/jokes/random?"+str1, 15000);
                        System.out.println(resultado);
                        System.out.println(str1);
                        return resultado;
                    }


                    @Override
                    protected void onPostExecute(String result) {
                        if(result != null){
                            try {
                                JSONObject objeto = new JSONObject(result);
                                final String joke = objeto.getJSONObject("value").getString("joke");
                                tText.setText(joke);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }
                };

                task.execute();
            }
        });

        return mainView;
    }
}
