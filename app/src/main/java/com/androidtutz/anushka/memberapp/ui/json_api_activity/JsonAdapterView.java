package com.androidtutz.anushka.memberapp.ui.json_api_activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.androidtutz.anushka.memberapp.R;
import com.androidtutz.anushka.memberapp.model.github_model.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Provides;

public class JsonAdapterView extends RecyclerView.Adapter<JsonAdapterView.JsonViewHolder>{

    private List<GitHubRepo> gitHubRepos = new ArrayList<>();
    @Inject
    public JsonAdapterView() {
    }

    public List<GitHubRepo> setGitHubRepos(List<GitHubRepo> repos){
        this.gitHubRepos.addAll(repos);
        return gitHubRepos;
    }

    @Override
    public JsonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        return new JsonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JsonViewHolder holder, int position) {
        holder.mRepoId.setText(""+gitHubRepos.get(position).getId());
        holder.mRepoName.setText(""+gitHubRepos.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return gitHubRepos.size();
    }


    class JsonViewHolder extends RecyclerView.ViewHolder {
        TextView mRepoId;
        TextView mRepoName;

        JsonViewHolder(View itemView) {
            super(itemView);
            mRepoId = itemView.findViewById(R.id.repo_id);
            mRepoName = itemView.findViewById(R.id.repo_name);
        }
    }
}
