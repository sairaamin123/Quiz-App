package com.example.quiz_app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_app.Activities.QuestionActivity;
import com.example.quiz_app.Models.Quiz;
import com.example.quiz_app.R;
import com.example.quiz_app.Utils.ColorPicker;
import com.example.quiz_app.Utils.IconPicker;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {
    Context context;
    ArrayList<Quiz> quizzes = new ArrayList<>();
    class QuizViewHolder extends RecyclerView.ViewHolder {
        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        TextView textViewTitle = itemView.findViewById(R.id.quizTitle);
        ImageView iconView = itemView.findViewById(R.id.quizIcon);
        CardView cardContainer = itemView.findViewById(R.id.cardContainer);
    }

    public QuizAdapter(Context context, ArrayList<Quiz> quizzes){
        this.context = context;
        this.quizzes = quizzes;
    }

    @NonNull
    @Override
    public QuizAdapter.QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.quiz_item, parent, false);
        return new QuizViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        holder.textViewTitle.setText(quizzes.get(position).getTitle());
        holder.cardContainer.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()));
        holder.iconView.setImageResource(IconPicker.getIcon());
        holder.itemView.setOnClickListener( v -> {
            Toast.makeText(context, quizzes.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, QuestionActivity.class);
            intent.putExtra("Date", quizzes.get(position).getTitle());
            context.startActivity(intent);
        });
    }
}