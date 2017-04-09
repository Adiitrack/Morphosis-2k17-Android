package com.nitmz.morphosis.scoobydoo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nitmz.morphosis.R;


public class LeaderBoardUserDetailsFragment extends Fragment {


    CircleImageView user_image;
    TextView user_score;
    TextView user_name;
    TextView user_rank;




    public LeaderBoardUserDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leader_board_user_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String name = getArguments().getString("name");
        String score = getArguments().getString("score");
        String purl = getArguments().getString("purl");

        user_image = (CircleImageView)view.findViewById(R.id.user_image_leaderboard_details);
        user_name = (TextView)view.findViewById(R.id.user_name_ip);
        user_score = (TextView)view.findViewById(R.id.user_score_ip);
        user_rank = (TextView)view.findViewById(R.id.user_rank_ip);



        Glide.with(getContext())
                .load(purl)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .fitCenter()
                .error(R.drawable.ic_account_circle_white_48dp)
                .placeholder(R.drawable.ic_account_circle_white_48dp)
                .dontAnimate()
                .into(user_image);

        user_name.setText(name);
        user_score.setText(score);







    }
}