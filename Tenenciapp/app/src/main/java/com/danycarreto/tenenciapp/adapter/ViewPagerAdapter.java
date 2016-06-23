package com.danycarreto.tenenciapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.danycarreto.tenenciapp.fragment.InfraccionFragment;
import com.danycarreto.tenenciapp.fragment.TenenciaFragment;
import com.danycarreto.tenenciapp.fragment.VerificacionFragment;

/**
 * Created by DanyCarreto on 22/06/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public CharSequence[] titulo;
    public ViewPagerAdapter(FragmentManager fm, CharSequence[] titulo) {

        super(fm);
        this.titulo = titulo;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TenenciaFragment();
            case 1:
                return new VerificacionFragment();
            case 2:
                return new InfraccionFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulo[position];
    }

}
