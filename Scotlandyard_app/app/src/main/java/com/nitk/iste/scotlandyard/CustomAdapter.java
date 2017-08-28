package com.nitk.iste.scotlandyard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private List<ItemObject> listStorage;
    private Context context;

    public CustomAdapter(Context context, List<ItemObject> customizedListView) {
        this.context = context;
        layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutinflater.inflate(R.layout.find_list, parent, false);
            listViewHolder.photo = (ImageView)convertView.findViewById(R.id.photo);
            listViewHolder.DocName = (TextView)convertView.findViewById(R.id.story_name);
            listViewHolder.Address = (TextView)convertView.findViewById(R.id.address );

            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.photo.setImageResource(listStorage.get(position).getPhoto());
        listViewHolder.DocName.setText(listStorage.get(position).getDocName());
        listViewHolder.Address.setText(listStorage.get(position).getDocAddress());

        return convertView;
    }

    static class ViewHolder{
        ImageView photo;
        TextView DocName;
        TextView Address;
    }

}
