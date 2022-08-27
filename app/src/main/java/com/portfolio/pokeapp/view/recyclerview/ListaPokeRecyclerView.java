package com.portfolio.pokeapp.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.portfolio.pokeapp.R;

public class ListaPokeRecyclerView extends RecyclerView {

    private GridLayoutManager manager;
    private final int columnWidth = 150;
    public int numberOfColumns = 1;

    public ListaPokeRecyclerView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ListaPokeRecyclerView(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ListaPokeRecyclerView(@NonNull Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        numberOfColumns = calculateNoOfColumns(context.getApplicationContext(), columnWidth);
        manager = new GridLayoutManager(getContext(), 1);
        setLayoutManager(manager);
    }

    public static int calculateNoOfColumns(Context context, float columnWidthDp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (numberOfColumns > 0) {
            manager.setSpanCount(numberOfColumns);
        }
    }

}
