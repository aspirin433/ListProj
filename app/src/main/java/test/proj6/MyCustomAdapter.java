package test.proj6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter implements ListAdapter {

    public ArrayList<MyObj> list = new ArrayList<MyObj>();
    private Context context;

    public MyCustomAdapter(ArrayList<MyObj> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int pos) {
        return list.get(pos).objName;
    }

    @Override
    public long getItemId(int pos) {
        //String id = list.get(pos).getObjId().toString();
        return 0;
    }

    public String getObjId(int pos){
        return list.get(pos).getObjId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.mylistitem, null);
        }

        TextView listItemText = (TextView)view.findViewById(R.id.content);
        listItemText.setText(list.get(position).objName);

        Button delBtn = (Button)view.findViewById(R.id.delBtn);
        delBtn.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v) {
                MyDBHelper.onObjDel(context, getObjId(position));
                list.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}