package com.formationandroid.interfacesavances;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity
{
	
	// ViewPager :
	private ViewPager viewPager = null;
	
	// Adapter :
	private MainPagerAdapter mainPagerAdapter = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// vues :
		viewPager = findViewById(R.id.viewpager);
		
		// texte et découpage :
		String texte = getString(R.string.main_texte);
		List<String> listeTextes = new ArrayList<>();
		for (int a = 0 ; a < texte.length() ; a += MainFragment.NOMBRE_CARACTERES_PAR_PAGE)
		{
			listeTextes.add(texte.substring(a, Math.min(a + MainFragment.NOMBRE_CARACTERES_PAR_PAGE, texte.length())));
		}
		
		// adapter :
		mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), listeTextes);
		viewPager.setAdapter(mainPagerAdapter);
	}
	
	/**
	 * Retourne le nombre de mots dans la page courante.
	 * @return Nombre de mots
	 */
	public int getNombreMotsPageCourante()
	{
		// récupération du texte de la page courante :
		String textePage = mainPagerAdapter.getTextePage(viewPager.getCurrentItem());
		
		// décompte des mots :
		return textePage.split("\\s+").length;
	}
	
	/**
	 * Retourne le numéro de la page courante.
	 * @return Page courante
	 */
	public int getPageCourante()
	{
		return viewPager.getCurrentItem() + 1;
	}
	
}
