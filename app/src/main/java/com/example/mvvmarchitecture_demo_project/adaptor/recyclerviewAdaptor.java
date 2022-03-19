package com.example.mvvmarchitecture_demo_project.adaptor;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.mvvmarchitecture_demo_project.R;
import com.example.mvvmarchitecture_demo_project.models.nicePlace;

import java.util.ArrayList;
import java.util.List;



public class recyclerviewAdaptor extends RecyclerView.Adapter<recyclerviewAdaptor.NewsViewHolder>  {

    Context mContext;
    List<nicePlace> mDataSonglist =new ArrayList<>();
    private OnItemClickListner mListner;

    /** search
     /*  public Filter getFilter() {
     return searchfilter;
     }

     private Filter searchfilter = new Filter() {
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
    List<customItem> filteredlist = new ArrayList<>();
    if (constraint == null || constraint.length() == 0) {
    filteredlist.addAll(Search.mDataSarch);
    } else {
    String filterPatern = constraint.toString().toLowerCase().trim();
    for (customItem item : Search.mDataSarch) {
    if (item.song_name.toLowerCase().contains(filterPatern)) {
    filteredlist.add(item);
    }
    }
    }
    FilterResults results = new FilterResults();
    results.values = filteredlist;
    return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
    Search.mDataLoadedSarch.clear();
    Search.mDataLoadedSarch.addAll((List) results.values);
    Menu_SearchHome.adaptorsearch.notifyDataSetChanged();


    }
    };
     **/


    public interface OnItemClickListner{
        void onItemClick(int position);
        void menudialog(int position);
    }

    public void setOnItemClickListner(OnItemClickListner listner){
        mListner= (OnItemClickListner) listner;
    }

    public recyclerviewAdaptor(Context mContext, List<nicePlace> mData) {
        this.mContext = mContext;
        this.mDataSonglist = mData;
    }



    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View layout;
        layout= LayoutInflater.from(mContext).inflate(R.layout.item_view,viewGroup,false);

        return new NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, int position) {
        //bind data heare

        //    holder.Album_Cover.setImageResource(R.drawable.ic_music_note_white_24dp);

        /** Set Albub Cover**/
     /*   final String albumArtUri=mDataSonglist.get(position).albumArtUriImage;
        int SPLASH_TIME_OUT = 400;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(
                            mContext.getContentResolver(), Uri.parse(albumArtUri));
                    bitmap = Bitmap.createScaledBitmap(bitmap, 140, 140, true);
                    holder.Album_Cover.setImageBitmap(bitmap);

                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                    bitmap = BitmapFactory.decodeResource(mContext.getResources(),
                            R.drawable.logo);
                    holder.Album_Cover.setImageBitmap(bitmap);
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
        }, SPLASH_TIME_OUT);



        holder.tv_title.setText(mDataSonglist.get(position).getSong_name());
        holder.tv_Artist.setText(mDataSonglist.get(position).getArtist_name());
        holder.Song_duration.setText(mDataSonglist.get(position).getSecond()+":"+mDataSonglist.get(position).getMunite());
        holder.tv_Album.setText(mDataSonglist.get(position).getAlbam_name());
 */

//
      //  Glide.with(mContext).load("http://goo.gl/gEgYUd").into(holder.Album_Cover);

        Glide.with(mContext).load(mDataSonglist.get(position).getImageUrl()).into(holder.Album_Cover);

//        holder.Album_Cover.setImageURI(Uri.parse(mDataSonglist.get(position).getAlbumArtUriImage()));
////        holder.rl_select.setBackgroundColor(Color.parseColor("#FFFFFF"));
//        holder.rl_select.setAlpha(0);

        holder.tv_title.setText(mDataSonglist.get(position).getTitle());
      //  holder.tv_Artist.setText(mDataSonglist.get(position).getImageUrl());
//        holder.tv_Album.setText(mDataSonglist.get(position).getFolderName());
//        holder.Song_duration.setText(mDataSonglist.get(position).getMunite()+":"+mDataSonglist.get(position).getSecond());
    }

    @Override
    public int getItemCount() {
        return mDataSonglist.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{


        TextView tv_title,tv_Artist,tv_Album,Song_duration;
        ImageView Album_Cover,VideoIcon,backgroundImage;
        ImageButton songListMenu;


        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

           tv_title= itemView.findViewById(R.id.title);
            Album_Cover=itemView.findViewById(R.id.img);
            tv_Artist=itemView.findViewById(R.id.title2);
//
//            songListMenu=itemView.findViewById(R.id.VideoMore);
//            VideoIcon=itemView.findViewById(R.id.VideoIcon);
//            Album_Cover=itemView.findViewById(R.id.videoImage);
//            backgroundImage=itemView.findViewById(R.id.imageBackground);

            Album_Cover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListner!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListner.onItemClick(position);
                        }
                    }
                }
            });

//            songListMenu.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(mListner!=null){
//                        int position=getAdapterPosition();
//                        if(position!=RecyclerView.NO_POSITION){
//                            mListner.menudialog(position);
//                        }
//                    }
//
//                }
//            });


        }
    }


}