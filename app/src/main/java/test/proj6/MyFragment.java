package test.proj6;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MyFragment extends ListFragment {

    private ArrayList<String> myObjList = new ArrayList<String>();

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myObjList.add("item1");
        myObjList.add("item2");
        myObjList.add("item3");

        MyCustomAdapter adapter = new MyCustomAdapter(myObjList, getActivity());

        ListView lView = getListView();
        lView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_1, null);
    }

    /*public void myObjAdder(){
        int count = 0;

    }*/
}