package com.example.android.miwok;

import android.app.Activity;
import android.app.LauncherActivity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jani on 02-11-2016.
 */

public class WordAdapter extends ArrayAdapter<word> {
    int mColorId;


    public WordAdapter(Activity context, ArrayList<word> words, int colorId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorId = colorId;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        word newWord = getItem(position);


        TextView nameTextView = (TextView) listItemView.findViewById(R.id.mowik_text_view);

        nameTextView.setText(newWord.getMiwokTranslation());





        TextView numberTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        numberTextView.setText(newWord.getDefaultTranslation());

        ImageView nameImageView = (ImageView) listItemView.findViewById(R.id.default_image_view);

        View textContainer = listItemView.findViewById(R.id.text_container);

        int colorItem = ContextCompat.getColor(getContext(), mColorId);

        textContainer.setBackgroundColor(colorItem);

        if (newWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            nameImageView.setImageResource(newWord.getImageResourceId());
            // Make sure the view is visible
            nameImageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            nameImageView.setVisibility(View.GONE);
        }

        return listItemView;
    }

}
