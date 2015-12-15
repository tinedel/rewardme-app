package ua.kiev.tinedel.rewardme.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);

        final TextView score = (TextView) view.findViewById(R.id.scoreView);
        final TextView countDown = (TextView) view.findViewById(R.id.countDownView);

        final Button doneSomething = (Button) view.findViewById(R.id.doneSomethingButton);
        doneSomething.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                score.setText(String.valueOf(Integer.parseInt(String.valueOf(score.getText())) + 15));
            }
        });

        final Button claimReward = (Button) view.findViewById(R.id.claimRewardButton);
        claimReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                int currentScore = Integer.parseInt(String.valueOf(score.getText()));
                score.setText("0");

                int hours = currentScore / 60;
                int minutes = currentScore % 60;
                countDown.setText(String.format("%02d:%02d:00", hours, minutes));
            }
        });

        return view;
    }
}
