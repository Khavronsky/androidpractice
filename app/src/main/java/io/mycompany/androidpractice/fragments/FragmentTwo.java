package io.mycompany.androidpractice.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import io.mycompany.androidpractice.R;
import io.mycompany.androidpractice.adapter.CardAdapter;
import io.mycompany.androidpractice.dialogs.AddNewItemDialogFragment;
import io.mycompany.androidpractice.util.DataUtilSimple;

public class FragmentTwo extends Fragment {

    private static final int LAYOUT = R.layout.fragment_two_layout;
    private CardAdapter cardAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance) {
        View view = inflater.inflate(LAYOUT, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cardAdapter = new CardAdapter(DataUtilSimple.allListData);
        recyclerView.setAdapter(cardAdapter);
        Button btnAddNewItem = view.findViewById(R.id.btnNewItem);
        btnAddNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewItemDialogFragment.newInstance()
                        .show(getActivity().getSupportFragmentManager(), AddNewItemDialogFragment.DIALOG_TAG);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_two_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.fragment_action_toast:
                Toast.makeText(getActivity(), "Fragment two Action!", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void makeToast() {
        //todo в этом методе все действие в одну строчку, поэтому нет смысла его выносить. Был бы смысл, если бы
        //todo ты в метод передавал параметр и переиспользовал в нескольких местах
    }

    public void refreshUi() {
        cardAdapter.notifyDataSetChanged();
    }
}

