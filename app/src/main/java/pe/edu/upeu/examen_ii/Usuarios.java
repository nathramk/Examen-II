package pe.edu.upeu.examen_ii;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.examen_ii.bean.UsuariosReg;

/**
 * Created by Alumnos on 25/04/2017.
 */

public class Usuarios extends Fragment{

    public static List<UsuariosReg> listUsers = new ArrayList<UsuariosReg>();
    public int usuarioId = 0;

    public static int layout = android.R.layout.simple_list_item_1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.tab01, container, false);

        ListView listUser = (ListView) view.findViewById(R.id.listUser);
        ArrayAdapter<UsuariosReg> arrayAdapter = new ArrayAdapter<UsuariosReg>(getActivity(), layout, listUsers);
        listUser.setAdapter(arrayAdapter);

        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UsuariosReg usuariosReg = (UsuariosReg) parent.getItemAtPosition(position);
                usuarioId = usuariosReg.getUsuarioId();
                Toast.makeText(getActivity(), usuariosReg.getUsuarioId()+usuariosReg.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
