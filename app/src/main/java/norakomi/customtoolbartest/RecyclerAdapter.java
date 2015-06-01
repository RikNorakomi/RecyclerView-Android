package norakomi.customtoolbartest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * The RecyclerView.Adapter<VH> requires a ViewHolder object which will be used in the implemented methods
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<Information> data = Collections.emptyList(); // initialize an Empty List

    public RecyclerAdapter(Context context, List<Information> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    /*Implemented methods from the RecyclerView.Adapter
    * The adapter requieres a RecyclerVIew.ViewHolder object. Documentation can be found at:
    * http://developer.android.com/reference/android/support/v7/widget/RecyclerView.ViewHolder.html*/
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_recyclerview_row, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    /*In the onBindViewholder method one should set the data that corresponds to the current Row*/
    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        Information current = data.get(position);
        viewHolder.text.setText(current.title);
        viewHolder.image.setImageResource(current.iconId);
    }

    @Override
    public int getItemCount() {
        return data.size(); // Don't forget to return the list size, RiK! :-)
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.listText);
            image = (ImageView) itemView.findViewById(R.id.listIcon);

        }
    }
}
