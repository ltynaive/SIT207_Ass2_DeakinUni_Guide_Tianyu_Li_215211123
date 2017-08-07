package com.example.lty.tianyu_li_215211123;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MySimpleArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    public MySimpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);

// Change the icon for all user.

        String s = values[position];
        if (s.startsWith("A") || s.startsWith("a")) {
            imageView.setImageResource(R.drawable.a);
        } else if (s.startsWith("B") || s.startsWith("b")) {
            imageView.setImageResource(R.drawable.b);
        } else if (s.startsWith("C") || s.startsWith("c")) {
            imageView.setImageResource(R.drawable.c);
        } else if (s.startsWith("D") || s.startsWith("d")) {
            imageView.setImageResource(R.drawable.d);
        } else if (s.startsWith("E") || s.startsWith("e")) {
            imageView.setImageResource(R.drawable.e);
        } else if (s.startsWith("F") || s.startsWith("f")) {
            imageView.setImageResource(R.drawable.f);
        } else if (s.startsWith("G") || s.startsWith("g")) {
            imageView.setImageResource(R.drawable.g);
        } else if (s.startsWith("H") || s.startsWith("H")) {
            imageView.setImageResource(R.drawable.h);
        } else if (s.startsWith("I") || s.startsWith("I")) {
            imageView.setImageResource(R.drawable.i);
        } else if (s.startsWith("J") || s.startsWith("J")) {
            imageView.setImageResource(R.drawable.j);
        } else if (s.startsWith("K") || s.startsWith("K")) {
            imageView.setImageResource(R.drawable.k);
        } else if (s.startsWith("L") || s.startsWith("l")) {
            imageView.setImageResource(R.drawable.l);
        } else if (s.startsWith("M") || s.startsWith("m")) {
            imageView.setImageResource(R.drawable.m);
        } else if (s.startsWith("N") || s.startsWith("n")) {
            imageView.setImageResource(R.drawable.n);
        } else if (s.startsWith("O") || s.startsWith("o")) {
            imageView.setImageResource(R.drawable.o);
        } else if (s.startsWith("P") || s.startsWith("p")) {
            imageView.setImageResource(R.drawable.p);
        } else if (s.startsWith("Q") || s.startsWith("q")) {
            imageView.setImageResource(R.drawable.q);
        } else if (s.startsWith("R") || s.startsWith("r")) {
            imageView.setImageResource(R.drawable.r);
        } else if (s.startsWith("S") || s.startsWith("s")) {
            imageView.setImageResource(R.drawable.s);
        } else if (s.startsWith("T") || s.startsWith("t")) {
            imageView.setImageResource(R.drawable.t);
        } else if (s.startsWith("U") || s.startsWith("u")) {
            imageView.setImageResource(R.drawable.u);
        } else if (s.startsWith("V") || s.startsWith("v")) {
            imageView.setImageResource(R.drawable.v);
        } else if (s.startsWith("W") || s.startsWith("w")) {
            imageView.setImageResource(R.drawable.w);
        } else if (s.startsWith("X") || s.startsWith("x")) {
            imageView.setImageResource(R.drawable.x);
        } else if (s.startsWith("Y") || s.startsWith("y")) {
            imageView.setImageResource(R.drawable.y);
        } else if (s.startsWith("Z") || s.startsWith("z")) {
            imageView.setImageResource(R.drawable.z);
        } else {
            imageView.setImageResource(R.mipmap.ic_launcher);
        }
        return rowView;
    }
}