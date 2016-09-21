package test.proj6;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MyFragment extends ListFragment {

    private MyCustomAdapter adapter;

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
/*
        SQLiteDatabase mSqLiteDatabase;
        DataBaseHelper  mDatabaseHelper;


        mDatabaseHelper = new DataBaseHelper(getActivity(), "rows.db", null, 1);
        mSqLiteDatabase =  mDatabaseHelper.getWritableDatabase();

        ArrayList<MyObj> myObjList = new ArrayList<MyObj>();

        Cursor cursor = mSqLiteDatabase.query("rows", new String[] {
                DataBaseHelper.ROW_NAME_COLUMN, DataBaseHelper.ID_COLUMN},
                null, null,
                null, null, null);

        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            //String rowName = cursor.getString(cursor.getColumnIndex(DataBaseHelper.ROW_NAME_COLUMN));
            String objIdString = cursor.getString(cursor.getColumnIndex(DataBaseHelper.ID_COLUMN));
            MyObj newObj = new MyObj(objIdString);
            myObjList.add(newObj);
        }
        cursor.close();
        */
        ListView lView;

        adapter = new MyCustomAdapter(MyDBHelper.fetchMyObjList(getActivity()), getActivity());

        lView = getListView();
        lView.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_1, null);
    }

    public void addNewObj(){
        MyObj newObj = new MyObj("null");
        adapter.list.add(newObj);
        adapter.notifyDataSetChanged();
        MyDBHelper.onObjAdd(getActivity(), newObj.getObjId(), newObj.objName);
    }
}