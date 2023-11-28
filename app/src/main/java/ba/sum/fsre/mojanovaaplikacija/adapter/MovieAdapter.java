package ba.sum.fsre.mojanovaaplikacija.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import ba.sum.fsre.mojanovaaplikacija.R;
import ba.sum.fsre.mojanovaaplikacija.model.Movie;

public class MovieAdapter extends FirebaseRecyclerAdapter<Movie, MovieAdapter.MovieViewHolder> {
    Context ctx;
    public MovieAdapter(@NonNull FirebaseRecyclerOptions<Movie> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MovieViewHolder holder, int position, @NonNull Movie model) {
        holder.movieName.setText(model.name);
        holder.movieReleaseDate.setText(model.release_date);
        holder.movieDirector.setText(model.director);
        Picasso.get().load(model.image).into(holder.movieImage);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.ctx = parent.getContext();
        View view = LayoutInflater.from(this.ctx).inflate(R.layout.movie_item_view, parent, false);
        return new MovieViewHolder(view);
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        TextView movieName, movieReleaseDate, movieDirector;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            this.movieImage = itemView.findViewById(R.id.movieImage);
            this.movieName = itemView.findViewById(R.id.movieName);
            this.movieReleaseDate = itemView.findViewById(R.id.movieReleaseDate);
            this.movieDirector = itemView.findViewById(R.id.movieDirector);
        }
    }
}
