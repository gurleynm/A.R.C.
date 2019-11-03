package com.android.arc.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;


import java.util.ArrayList;

public class Utility {

    public static int calculateNoOfColumns(Context context, float columnWidthDp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        return (int) (screenWidthDp / columnWidthDp + 0.5);
    }

    public static boolean isConnectedToNetwork(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean isConnected = false;
        if (connectivityManager != null) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            isConnected = (activeNetwork != null) && (activeNetwork.isConnectedOrConnecting());
        }

        return isConnected;
    }

    public static void clearStack(FragmentManager fm) {
        //Here we are clearing back stack fragment entries
        int backStackEntry = fm.getBackStackEntryCount();
        if (backStackEntry > 0) {
            for (int i = 0; i < backStackEntry; i++) {
                fm.popBackStackImmediate();
            }
        }

        //Here we are removing all the fragment that are shown here
        if (fm.getFragments() != null && fm.getFragments().size() > 0) {
            for (int i = 0; i < fm.getFragments().size()-1; i++) {
                Fragment mFragment = fm.getFragments().get(i);
                if (mFragment != null) {
                    fm.beginTransaction().remove(mFragment).commit();
                }
            }
        }
    }
}
