package vn.nks.loclt.produsviewpaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import vn.nks.loclt.mylibrary.RecyclerViewPager;
import vn.nks.loclt.produsviewpaper.Adapter.Adapter;

public class FreeViewpaper extends AppCompatActivity {
    RecyclerViewPager recyclewViewpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_viewpaper);
        initViewPaper();

    }

    private void initViewPaper() {
        recyclewViewpaper = (RecyclerViewPager) findViewById(R.id.recyclewViewpaper);
        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                false);
        recyclewViewpaper.setLayoutManager(layout);
        recyclewViewpaper.setAdapter(new Adapter());
        recyclewViewpaper.setHasFixedSize(true);
        recyclewViewpaper.setLongClickable(true);
        recyclewViewpaper.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int childCount = recyclewViewpaper.getChildCount();
                int width = recyclewViewpaper.getChildAt(0).getWidth();
                int padding = (recyclewViewpaper.getWidth() - width) / 2;
//                mCountText.setText("Count: " + childCount);

                for (int j = 0; j < childCount; j++) {
                    View v = recyclerView.getChildAt(j);

                    float rate = 0;
                    ;
                    if (v.getLeft() <= padding) {
                        if (v.getLeft() >= padding - v.getWidth()) {
                            rate = (padding - v.getLeft()) * 1f / v.getWidth();
                        } else {
                            rate = 1;
                        }
                        v.setScaleY(1 - rate * 0.1f);
                        v.setScaleX(1 - rate * 0.1f);

                    } else {

                        if (v.getLeft() <= recyclerView.getWidth() - padding) {
                            rate = (recyclerView.getWidth() - padding - v.getLeft()) * 1f / v.getWidth();
                        }
                        v.setScaleY(0.9f + rate * 0.1f);
                        v.setScaleX(0.9f + rate * 0.1f);
                    }
                }
            }
        });

        recyclewViewpaper.addOnPageChangedListener(new RecyclerViewPager.OnPageChangedListener() {
            @Override
            public void OnPageChanged(int oldPosition, int newPosition) {
                Log.d("test", "oldPosition:" + oldPosition + " newPosition:" + newPosition);
            }
        });
        recyclewViewpaper.addOnPageChangedListener(new RecyclerViewPager.OnPageChangedListener() {
            @Override
            public void OnPageChanged(int oldPosition, int newPosition) {
                if (recyclewViewpaper.getChildCount() < 3) {
                    if (recyclewViewpaper.getChildAt(1) != null) {
                        if (recyclewViewpaper.getCurrentPosition() == 0) {
                            View v1 = recyclewViewpaper.getChildAt(1);
                            v1.setScaleY(0.9f);
                            v1.setScaleX(0.9f);
                        } else {
                            View v1 = recyclewViewpaper.getChildAt(0);
                            v1.setScaleY(0.9f);
                            v1.setScaleX(0.9f);
                        }
                    }
                } else {
                    if (recyclewViewpaper.getChildAt(0) != null) {
                        View v0 = recyclewViewpaper.getChildAt(0);
                        v0.setScaleY(0.9f);
                        v0.setScaleX(0.9f);
                    }
                    if (recyclewViewpaper.getChildAt(2) != null) {
                        View v2 = recyclewViewpaper.getChildAt(2);
                        v2.setScaleY(0.9f);
                        v2.setScaleX(0.9f);
                    }
                }


            }
        });
//        recyclewViewpaper.setAdapter();
    }
}
