package com.gitgud.homelesshelper.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.SearchProvider;
import com.gitgud.homelesshelper.model.Shelter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class ShelterViewActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Shelter> list = Shelter.getShelterList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RecyclerView shelterRecycle = findViewById(R.id.ShelterListView);
        final ShelterRecyclerViewAdapter shelterAdapter = new ShelterRecyclerViewAdapter(list);
        shelterRecycle.setAdapter(shelterAdapter);

        Button mSearchButton = findViewById(R.id.search_activity_button);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShelterViewActivity.this, ShelterSearchActivity.class));
                list = SearchProvider.getSearchResult();
                shelterAdapter.notifyDataSetChanged();
            }
        });

        Button mMapButton = findViewById(R.id.viewmapbutton);
        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShelterViewActivity.this, DefaultMapActivity.class));
            }
        });

    }

    public class ShelterRecyclerViewAdapter extends
            RecyclerView.Adapter<ShelterRecyclerViewAdapter.ViewHolder> {

        /**
         * @param list shelter list
         */
        public void updateData(List<Shelter> list) {
            shelterList = list;
            notifyDataSetChanged();
        }

        private List<Shelter> shelterList;

        /**
         * @param shelterList List of shelters
         */
        public ShelterRecyclerViewAdapter(List<Shelter> shelterList) {
            this.shelterList = shelterList;
        }
        @Override
        public ShelterRecyclerViewAdapter.ViewHolder
        onCreateViewHolder(ViewGroup parent, int index) {
            Context parentgetcontext = parent.getContext();
            LayoutInflater layoutinflaterparent = LayoutInflater.from(parentgetcontext);
            View v = layoutinflaterparent.inflate(R.layout.shelter_detail, parent, false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {

            holder.shelter = shelterList.get(position);

            holder.shelterName.setText(holder.shelter.getName());

            holder.shelterName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //on a phone, we need to change windows to the detail view
                    Context context = v.getContext();
                    //create our new intent with the new screen (activity)
                    Intent intent = new Intent(context, ShelterDetailActivity.class);
                        /*
                            pass along the id of the course so we can retrieve the correct data in
                            the next window
                         */
                    intent.putExtra(Shelter.SHELTER_NAME, holder.shelter.getId());


                    //now just display the new window
                    context.startActivity(intent);

                }
            });


        }

        /**
         * @param input Shelter list
         */
        public void updates(Collection<Shelter> input)
        {
            if((input == null) || (input.isEmpty())) {
                return;
            }
            if ((shelterList != null) && (!shelterList.isEmpty())) {
                shelterList.clear();
            }
            shelterList.addAll(input);
            Collections.sort(shelterList);
            notifyDataSetChanged();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            final View view;
            final TextView shelterName;
            Shelter shelter;

            /**
             * @param view View
             */
            public ViewHolder(View view) {
                super(view);
                this.view = view;
                this.shelterName = view.findViewById(R.id.name);
            }
        }

        @Override
        public int getItemCount() {
            return shelterList.size();
        }


    }

}

