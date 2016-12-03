package com.example.frz.beyou;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.frz.beyou.BeYou.adapter.StaggeredAdapter;
import com.example.frz.beyou.widget.views.ScaleImageView;

import java.net.URL;

/**
 * Created by gerson on 03/12/16.
 */

public class SelectImageFragment extends NewFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_select_image, container, false);

        new MyAsyncTask(getArguments().getString("link"),(ImageView)v.findViewById(R.id.muralpicture)).execute();
        return v;
    }
    class MyAsyncTask extends AsyncTask<Void,Void,Bitmap> {
        ImageView imageView;
        String string;
        MyAsyncTask(String string,ImageView imageView){
            this.imageView=imageView;
            this.string=string;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            URL url = null;
            try {
                url = new URL(string);
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                return bmp;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            //super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }
}
