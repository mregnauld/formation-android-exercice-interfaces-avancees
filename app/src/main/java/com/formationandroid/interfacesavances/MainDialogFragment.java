package com.formationandroid.interfacesavances;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


public class MainDialogFragment extends DialogFragment
{
	
	// Constantes :
	public static final String TAG_MAIN_DIALOG = "TAG_MAIN_DIALOG";
	public static final String EXTRA_NOMBRE_MOTS = "EXTRA_NOMBRE_MOTS";
	public static final String EXTRA_NUMERO_PAGE = "EXTRA_NUMERO_PAGE";
	
	
	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		// récupération des arguments :
		int nombreMots = getArguments().getInt(EXTRA_NOMBRE_MOTS);
		int numeroPage = getArguments().getInt(EXTRA_NUMERO_PAGE);
		
		// initialisation de la boîte de dialogue :
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(getString(R.string.main_dialogue_message, nombreMots, numeroPage))
				.setPositiveButton(R.string.main_dialogue_ok, new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						dialog.dismiss();
					}
				});
		
		// création de la boîte de dialogue et retour :
		return builder.create();
	}
	
}
