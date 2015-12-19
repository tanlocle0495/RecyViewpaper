package vn.nks.loclt.produsviewpaper;

import android.os.Bundle;

/**
 * Created by loc on 19/12/2015.
 */
public class    FreeFlingPagerActivity  extends FreeViewpaper {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclewViewpaper.setSinglePageFling(false);
    }
}
