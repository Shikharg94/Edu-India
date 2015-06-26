package com.thoughtworks.shikhargupta.eduindia;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    ListView l;
    String[] students;
    String[] descriptions;
    int[] images = {R.drawable.toast , R.drawable.toast , R.drawable.toast  , R.drawable.toast , R.drawable.toast,
            R.drawable.toast , R.drawable.toast};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        students = res.getStringArray(R.array.student_names);
        descriptions = res.getStringArray(R.array.student_subjects);

        l = (ListView)findViewById(R.id.list_view);

        customAdapter adapter = new customAdapter(this, students , images, descriptions  );
        l.setAdapter(adapter);

//        l = (ListView)findViewById(R.id.list_view);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.single_row, R.id.text_view , students);
//        l.setAdapter(adapter);
    }


    class customAdapter extends ArrayAdapter<String>{

        Context context;
        int[] images;
        String[] titleArray;
        String[] descriptionArray;

        customAdapter(Context c , String[] titles , int imgs[] , String[] desc){

            super(c,R.layout.single_row , R.id.text_view , titles);
            this.context = c;
            this.images = imgs;
            this.titleArray = titles;
            this.descriptionArray = desc;
        }


        class MyViewHolder{

            ImageView myImage;
            TextView myTitle;
            TextView myDescription;

            MyViewHolder( View v ){
                myImage = (ImageView) v.findViewById(R.id.image_view);
                myTitle = (TextView) v.findViewById(R.id.text_view);
                myDescription = (TextView) v.findViewById(R.id.description_view);
            }

        }

//        @Override
//        public View getView( int position , View convertView , ViewGroup parent){
//
//            //Optimization for 150% faster
//            View row = convertView;
//
//            if( row == null ) {
//                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                row = inflater.inflate(R.layout.single_row, parent, false);
//            }
//
//            ImageView myImage = (ImageView) row.findViewById(R.id.image_view);
//            TextView myTitle = (TextView) row.findViewById(R.id.text_view);
//            TextView myDescription = (TextView) row.findViewById(R.id.description_view);
//
//            myImage.setImageResource(images[position] );
//            myTitle.setText(titleArray[position]);
//            myDescription.setText(descriptionArray[position]);
//
//            return row;
//        }



        //Optimization 175%
        public View getView( int position , View convertView , ViewGroup parent){

            View row = convertView;
            MyViewHolder holder = null;

            if(row == null ){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.single_row , parent , false );
                holder = new MyViewHolder(row);
                row.setTag(holder);
                Log.d("Shikhar" , "Creating a new row");
            }

            else{
                holder = (MyViewHolder) row.getTag();
                Log.d("Shikhar" , "Recycling ");
            }
            holder.myImage.setImageResource(images[position]);
            holder.myTitle.setText(titleArray[position]);
            holder.myDescription.setText(descriptionArray[position]);
            return row;
        }

    }

    public void openDescription(View v) {
        Log.d("shikharg", "openDescription method called");
        Intent intent = new Intent(this, DetailActivity.class);
        TextView textView = (TextView) v.findViewById(R.id.text_view);
        Log.d("chi6rag", textView.getText().toString());
        intent.putExtra("name", textView.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("chi6rag", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("chi6rag", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("chi6rag", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("chi6rag", "onStop called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("chi6rag", "onRestart called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("chi6rag", "onDestroy called");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("chi6rag", "onSaveInstanceState called");
    }
}
