package com.example.telestraapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountryViewHolder> {//4

String[] mCountries;//8
    private LayoutInflater mInflater;//10

    public CountriesAdapter(String[] countries, Context context) {
        mCountries = countries;//8a
        mInflater = LayoutInflater.from(context);//11
    }

    @NonNull
    @Override //onCreateViewHolder --- to create/buy new  plank-strip [
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//6
        View mItemView = mInflater.inflate(R.layout.recyclerlist_row, parent, false);//12
        return new CountryViewHolder(mItemView);//13
    }

    @Override//onBindViewHolder -- write the data on to the newly created/recycled  plank
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {//6
        holder.countryText.setText(mCountries[position]);  //binding the data onto the inflated plank//15
    }

    @Override // getItemCount -- tell how many data items are there so that the above 2 guys can create or recycle items
    public int getItemCount() {//6
        return mCountries.length;//9
    }

    /**
     * this guy will have a box of empty planks/ planks to recycle and insert at the bottom of the list/screen
     */
    public class CountryViewHolder extends RecyclerView.ViewHolder {//5
       public TextView countryText;//14
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryText =  itemView.findViewById(R.id.textViewCountry);//16
        }
    }
}
