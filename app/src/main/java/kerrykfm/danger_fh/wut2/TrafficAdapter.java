package kerrykfm.danger_fh.wut2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DaNGeR on 16/10/2016.
 */

public class TrafficAdapter extends BaseAdapter {
    //Explicit
    // Context ต่อท่อ
    private Context context;  //ท่อที่ส่งข้อมูล
    private String[] titleStrings, detailStrings;
    private int[] ints;
    private TextView titleTextView, detailTextView;
    private ImageView imageView;

    public TrafficAdapter(Context context, String[] titleStrings, String[] detailStrings, int[] ints) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
        this.ints = ints;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // ขอเปิด Service LayoutInflater
        View view = layoutInflater.inflate(R.layout.traffic_listview, parent, false); // ผูก Layout traffic_listview false คือ เขาถึงแบบไม่มีความปลอดภัย

        //Bind widget ผูก ข้อมูลของหน้า listView
        titleTextView = (TextView) view.findViewById(R.id.textView);
        detailTextView = (TextView) view.findViewById(R.id.textView2);
        imageView = (ImageView) view.findViewById(R.id.imageView);

        //show View set ค่า
        titleTextView.setText(titleStrings[position]);

        //การตัดคำ โดยจะแสดงแค่ 30 ตัวอักษรเท่านั้น แต่ถ้า Detail น้อยกว่า
        //30 ตัวอักษร ให้ แสดงทั้งหมด
        if (detailStrings[position].length() <= 30) {
            //รายละเอียดน้อยกว่า 30 ตัวอักษร
            detailTextView.setText(detailStrings[position]);
        } else {
            //มากกว่า 30 ตัวอั
            detailTextView.setText(detailStrings[position].substring(0, 30) + "...");
        }

        //Change Image
        imageView.setImageResource(ints[position]);

        return view;
    }
}   //Main Class
