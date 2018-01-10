package com.formationandroid.interfacesavances;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment implements View.OnClickListener
{
	
	// Constantes :
	public static final String EXTRA_TEXTE = "EXTRA_TEXTE";
	public static final int NOMBRE_CARACTERES_PAR_PAGE = 800;
	
	// Vues :
	private TextView textView = null;
	
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_main, container, false);
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState)
	{
		// init :
		super.onActivityCreated(savedInstanceState);
		if (getView() != null && getContext() != null)
		{
			// vues :
			textView = getView().findViewById(R.id.texte);
			textView.setText(getArguments().getString(EXTRA_TEXTE));
			
			// listeners :
			textView.setOnClickListener(this);
		}
	}
	
	@Override
	public void onClick(View view)
	{
		// création de la boîte de dialogue :
		MainDialogFragment mainDialogFragment = new MainDialogFragment();
		
		// arguments pour la boîte de dialogue :
		Bundle bundle = new Bundle();
		bundle.putInt(MainDialogFragment.EXTRA_NOMBRE_MOTS, ((MainActivity) getActivity()).getNombreMotsPageCourante());
		bundle.putInt(MainDialogFragment.EXTRA_NUMERO_PAGE, ((MainActivity) getActivity()).getPageCourante());
		mainDialogFragment.setArguments(bundle);
		
		// affichage de la boîte de dialogue :
		mainDialogFragment.show(getActivity().getSupportFragmentManager(), MainDialogFragment.TAG_MAIN_DIALOG);
	}
	
}
