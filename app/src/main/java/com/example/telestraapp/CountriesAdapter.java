package com.example.telestraapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountryViewHolder> {

String[] mCountries;
    private LayoutInflater mInflater;

    public CountriesAdapter(String[] countries, Context context) {
        mCountries = countries;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override //onCreateViewHolder --- to create/buy new  plank-strip [
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recyclerlist_row, parent, false);
        return new CountryViewHolder(mItemView);
    }

    @Override//onBindViewHolder -- write the data on to the newly created/recycled  plank
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.countryText.setText(mCountries[position]);  //binding the data onto the inflated plank
    }

    @Override // getItemCount -- tell how many data items are there so that the above 2 guys can create or recycle items
    public int getItemCount() {
        return mCountries.length;
    }

    /**
     * this guy will have a box of empty planks/ planks to recycle and insert at the bottom of the list/screen
     */
    public class CountryViewHolder extends RecyclerView.ViewHolder {
       public TextView countryText;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryText =  itemView.findViewById(R.id.textViewCountry);
        }
    }
}
