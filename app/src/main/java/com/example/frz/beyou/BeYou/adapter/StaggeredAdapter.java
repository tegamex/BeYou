package com.example.frz.beyou.BeYou.adapter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.frz.beyou.ActionItem;
import com.example.frz.beyou.LoadFragment;
import com.example.frz.beyou.QuickAction;
import com.example.frz.beyou.R;
import com.example.frz.beyou.BeYou.AppData;
import com.example.frz.beyou.BeYou.model.DuitangInfo;
import com.example.frz.beyou.SelectImageFragment;
import com.example.frz.beyou.widget.views.ScaleImageView;

public class StaggeredAdapter extends BaseAdapter {
    private Context mContext;
    private LinkedList<DuitangInfo> mInfos;
    AppCompatActivity activity;

    private static final int ID_UP     = 1;
    private static final int ID_DOWN   = 2;
    private static final int ID_SEARCH = 3;
    private static final int ID_INFO   = 4;
    private static final int ID_ERASE  = 5;
    private static final int ID_OK     = 6;

    public StaggeredAdapter(Context context, AppCompatActivity activity) {
        mContext = context;
        mInfos = new LinkedList<DuitangInfo>();
        this.activity=activity;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        DuitangInfo duitangInfo = mInfos.get(position);
        ActionItem nextItem 	= new ActionItem(ID_DOWN, "Next", activity.getResources().getDrawable(R.drawable.menu_down_arrow));
        ActionItem prevItem 	= new ActionItem(ID_UP, "Prev", activity.getResources().getDrawable(R.drawable.menu_up_arrow));
        ActionItem searchItem 	= new ActionItem(ID_SEARCH, "Find", activity.getResources().getDrawable(R.drawable.menu_search));
        ActionItem infoItem 	= new ActionItem(ID_INFO, "Info", activity.getResources().getDrawable(R.drawable.menu_info));
        ActionItem eraseItem 	= new ActionItem(ID_ERASE, "Clear", activity.getResources().getDrawable(R.drawable.menu_eraser));
        ActionItem okItem 		= new ActionItem(ID_OK, "OK", activity.getResources().getDrawable(R.drawable.menu_ok));
        final QuickAction quickAction = new QuickAction(activity, QuickAction.HORIZONTAL);
        quickAction.addActionItem(nextItem);
        quickAction.addActionItem(prevItem);
        quickAction.addActionItem(searchItem);
        quickAction.addActionItem(infoItem);
        quickAction.addActionItem(eraseItem);
        quickAction.addActionItem(okItem);
        if (convertView == null) {
            LayoutInflater layoutInflator = LayoutInflater.from(parent.getContext());
            convertView = layoutInflator.inflate(R.layout.infos_list, null);
            holder = new ViewHolder();
            holder.imageView = (ScaleImageView) convertView.findViewById(R.id.news_pic);
            holder.contentView = (TextView) convertView.findViewById(R.id.news_title);
            convertView.setTag(holder);
            convertView.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    quickAction.show(v);
                }
            });
        }

        holder = (ViewHolder) convertView.getTag();
        /*int w=duitangInfo.getWidth();
        int h=duitangInfo.getHeight();*/
        
        int w=200;
        int h=200;
        
        holder.imageView.setImageWidth(w);
        holder.imageView.setImageHeight(h);
        holder.contentView.setText(duitangInfo.getMsg());
        Log.i("mensaje",duitangInfo.getIsrc()+ holder.imageView);
        /*
        URL url = null;
        try {
            url = new URL(duitangInfo.getIsrc());
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.imageView.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        AppData.imageLoader.displayImage(duitangInfo.getIsrc(),holder.imageView);
        */


        new MyAsyncTask(duitangInfo.getIsrc(),holder.imageView).execute();

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImageFragment fg=new SelectImageFragment();
                Bundle bundle=new Bundle();
                bundle.putString("link",mInfos.get(position).getIsrc());
                fg.setArguments(bundle);

                activity.getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit)
                        .replace(R.id.fragment,fg).addToBackStack(null).commit();
            }
        });
        return convertView;
    }

    class ViewHolder {
    	ScaleImageView imageView;
        TextView contentView;
        TextView timeView;
    }




    class MyAsyncTask extends AsyncTask<Void,Void,Bitmap>{
        ScaleImageView scaleImageView;
        String string;
        MyAsyncTask(String string,ScaleImageView scaleImageView){
            this.scaleImageView=scaleImageView;
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
            scaleImageView.setImageBitmap(bitmap);
        }
    }
    
    @Override
    public int getCount() {
        return mInfos.size();
    }

    @Override
    public Object getItem(int arg0) {
        return mInfos.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    public void addItemLast(List<DuitangInfo> datas) {
        mInfos.addAll(datas);
    }

    public void addItemTop(List<DuitangInfo> datas) {
        for (DuitangInfo info : datas) {
            mInfos.addFirst(info);
        }
    }
}