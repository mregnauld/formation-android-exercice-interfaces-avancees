package com.formationandroid.interfacesavances;

import android.os.Bundle;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MainPagerAdapter extends FragmentStatePagerAdapter
{

	// Liste de textes :
	private List<String> listeTextes = null;
	
	
	/**
	 * Constructeur.
	 * @param fragmentManager FragmentManager
	 * @param listeTextes Liste de textes
	 */
	public MainPagerAdapter(FragmentManager fragmentManager, List<String> listeTextes)
	{
		super(fragmentManager);
		this.listeTextes = listeTextes;
	}
	
	@Override
	public Fragment getItem(int position)
	{
		// création de la page, avec le bon contenu :
		MainFragment fragment = new MainFragment();
		Bundle bundle = new Bundle();
		bundle.putString(MainFragment.EXTRA_TEXTE, listeTextes.get(position));
		fragment.setArguments(bundle);
		
		// retour :
		return fragment;
	}
	
	@Override
	public int getCount()
	{
		return listeTextes.size();
	}
	
	/**
	 * Retourne le texte à la page spécifiée.
	 * @param position Position de la page
	 * @return Texte
	 */
	String getTextePage(int position)
	{
		return listeTextes.get(position);
	}
	
}
