package com.example.cula_mobile.module.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cula_mobile.ActivityBottom_navigation;
import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Project;
import com.example.cula_mobile.module.board.BoardFragment;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {
    private ArrayList<Project> projects;
    private Context context;

    public ProjectAdapter(ArrayList<Project> projects, Context context) {
        this.projects = projects;
        this.context = context;
    }

    @Override
    public ProjectAdapter.ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_projects, parent, false);

        return new ProjectViewHolder(view);
    }

    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        holder.txtProjectName.setText(projects.get(position).getProjectName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction(new BoardFragment(projects.get(position).getIdProject()));
//                intent.putExtra("idProject", projects.get(position).getIdProject());
//                context.startActivity(intent);
            }
        });

    }

    public int getItemCount() {
        return (projects != null) ? projects.size() : 0;
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder {
        private TextView txtProjectName;

        public ProjectViewHolder(View itemView) {
            super(itemView);

            txtProjectName = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    private boolean fragmentTransaction(Fragment fragment){
        FragmentManager fragmentManager = ((ActivityBottom_navigation) context).getSupportFragmentManager();
        String backStackStateName = null;
        fragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout_container, fragment, "")
                .commit();
        return true;
    }
}
