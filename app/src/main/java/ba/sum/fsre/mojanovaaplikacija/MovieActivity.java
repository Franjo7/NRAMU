package ba.sum.fsre.mojanovaaplikacija;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import ba.sum.fsre.mojanovaaplikacija.adapter.MovieAdapter;
import ba.sum.fsre.mojanovaaplikacija.model.Movie;

public class MovieActivity extends AppCompatActivity {
    RecyclerView movieRecyclerView;
    MovieAdapter adapter;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        
        this.movieRecyclerView = findViewById(R.id.movieListView);
        this.movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Movie> options = new FirebaseRecyclerOptions.Builder<Movie>()
                .setQuery(this.mDatabase.getReference("movies"), Movie.class)
                .build();

        this.adapter = new MovieAdapter(options);
        this.movieRecyclerView.setAdapter(this.adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        this.adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.adapter.stopListening();
    }
}