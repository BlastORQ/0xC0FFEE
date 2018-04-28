package com.a0xcooffee.studentshelper;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<News> objects;

    NewsListAdapter(Context context, ArrayList<News> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.news_lip, parent, false);
        }

        News p = getProduct(position);

        ((TextView) view.findViewById(R.id.title)).setText(p.title);
        ((TextView) view.findViewById(R.id.content)).setText(p.text + "");
        ImageView imageView = (ImageView) view.findViewById(R.id.thumbnail);

        try {
            if (!p.img_url.equals("")) {
                new DownloadImageTask(imageView)
                        .execute(p.img_url);
            }else{
                imageView.setVisibility(View.GONE);
            }
        }catch (Exception e){

        }
        return view;
    }

    // товар по позиции
    News getProduct(int position) {
        return ((News) getItem(position));
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}