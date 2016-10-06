package cl.telematica.android.certamen2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.AsyncTask;
import android.widget.TextView;

import cl.telematica.android.certamen2.HttpServerConnection;
import org.json.JSONException;
import org.json.JSONObject;

import cl.telematica.android.certamen2.R;
import cl.telematica.android.certamen2.UIAdapter;

import static android.R.attr.id;

public class ListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    TextView text2;
    TextView text3;

    /**
     * New instance of ListFragment
     *
     * @return new instance of ListFragment
     */
    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mainView = inflater.inflate(R.layout.fragment_list, null);

        /*
         * Aquí es donde deben hacer el link a los elementos del layout fragment_list,
         * y donde prácticamente se debe hacer el desarrollo
        */

        mRecyclerView = (RecyclerView) mainView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(mainView.getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);


        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPreExecute(){

            }

            @Override
            protected String doInBackground(Void... params) {
                String resultado = new HttpServerConnection().connectToServer("http://api.icndb.com/jokes/random/20", 15000);
                return resultado;
            }

            @Override
            protected void onPostExecute(String result) {
                if(result != null){
                    try {

                        JSONObject objeto = new JSONObject(result);
                        final String joke = objeto.getJSONObject("value").getString("joke");
                        final String ID = objeto.getJSONObject("value").getInt("id");
                        text2.setText(joke);
                        text3.setText(id);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
        };


        task.execute();
    }





    return mainView;
    }
}
